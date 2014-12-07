package com.services.bookrestservice.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Book.class)
public class BookList extends ArrayList<Book> {
	private static final long serialVersionUID = 7440935670081172494L;

	public BookList() {
		super();
	}
	
	public BookList(Collection<? extends Book> c) {
		super(c);
	}
	
	@XmlElement(name = "book")
	public List<Book> getBooks() {
		return this;
	}
	
	public void setBooks(List<Book> books) {
		this.addAll(books);
	}
}
