package com.services.bookrestservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@Entity
@XmlRootElement
@NamedQuery(name=Book.FIND_ALL, query="Select b from Book b")
public class Book {
	
	static Logger log = Logger.getLogger(Book.class.getName());
	
	public static final String FIND_ALL = "Book.find_all";
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false)
	private String title;
	
	@Column
	private Float price;
	
	public Book() {
		
	}
	
	public Book(int id, String title, Float price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public int getId() {
		log.debug("Getting Id");
		return id;
	}

	public void setId(int id) {
		log.debug("Setting Id");
		this.id = id;
	}

	public String getTitle() {
		log.debug("Getting title");
		return title;
	}

	public void setTitle(String title) {
		log.debug("Setting title");
		this.title = title;
	}

	public Float getPrice() {
		log.debug("Getting price");
		return price;
	}

	public void setPrice(Float price) {
		log.debug("Setting price");
		this.price = price;
	}
	
	
}
