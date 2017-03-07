package com.sample.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sample.data.model.Book;
import com.sample.dto.DataWrapper;

/**
 * This is abstract layer to Book.
 * 
 * @author shyam.pareek
 *
 */
public interface BookService {

	Book addBook(Book book);

	Book getBook(Long id);

	Collection<Book> findByName(String name);

	Book updateBook(Book book);

	void deleteBook(Long id);

	List<Book> getBooks();

	DataWrapper getBooksPage(Pageable pageable);
}
