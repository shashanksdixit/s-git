package com.services.bookrestservice.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.services.bookrestservice.entity.Book;

public class BookPUClient {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookPU");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		Book book = new Book(1, "Anything", (float) 1.0);
		em.persist(book);
		System.out.println("Book created..");
		
		transaction.commit();
		System.out.println("Complete..");

	}
}
