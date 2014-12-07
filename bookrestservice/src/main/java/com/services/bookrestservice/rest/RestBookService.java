package com.services.bookrestservice.rest;

import java.net.URI;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.services.bookrestservice.entity.Book;
import com.services.bookrestservice.entity.BookList;

@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class RestBookService {
	@PersistenceContext(unitName="bookPU")
	private EntityManager em;
	
	@Context
	protected UriInfo uriInfo;
	
	@POST
	public Response createBook(Book book) {
		if (book == null)
			throw new BadRequestException();
		em.persist(book);
		URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId() + "").build();
		return Response.created(bookUri).build();
	}
	
	@PUT
	public Response updateBook(Book book) {
		if (book == null)
			throw new BadRequestException();
		em.merge(book);
		return Response.ok().build();
	}
	
	@GET
	@Path("{id}")
	public Response getBook(@PathParam("id") String id) {
		Book book = em.find(Book.class, id);
		if (book == null)
			throw new NotFoundException();
		return Response.ok(book).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteBook(@PathParam("id") String id) {
		Book book = em.find(Book.class, id);
		if (book == null)
			throw new NotFoundException();
		em.remove(book);
		return Response.noContent().build();
	}
	
	@GET
	public Response getAllBooks() {
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
		BookList books = new BookList(query.getResultList());
		return Response.ok(books).build();
	}

}
