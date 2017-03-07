package com.sample.data.model;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

/**
 * This is simple model for Book
 * 
 * @author shyam.pareek
 *
 */
@Document
public class Book {

	@Id
	@Field("bookId")
	private Long bookId;
	@Field("bookName")
	private String name;
	@Field("email")
	private String email;
	@Field("author")
	private String author;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(Long bookId, String name, String author, String email) {
		this.bookId=bookId;
		this.name=name;
		this.author=author;
		this.email =email;
	}
	
	private String description;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", description=" + description
				+ "]";
	}
	
	
	
}
