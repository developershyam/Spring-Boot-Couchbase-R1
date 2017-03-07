package com.sample.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.data.model.Book;
import com.sample.data.repository.BookRepository;
import com.sample.dto.DataWrapper;
import com.sample.util.AppUtils;

/**
 * This is business layer which contains logic related to Book.
 * 
 * @author shyam.pareek
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		book.setBookId(AppUtils.generateUniqueId());
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findOne(id);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.delete(id);
		;
	}

	@Override
	public List<Book> getBooks() {

		List<Book> books = new ArrayList<>();

		bookRepository.findAll().forEach(books::add);

		return books;
	}

	@Override
	public DataWrapper getBooksPage(Pageable pageable) {

		Page<Book> bookPages = bookRepository.findAll(pageable);
		DataWrapper dataWrapper = new DataWrapper();
		dataWrapper.setPageNumber(bookPages.getNumber() + 1);
		dataWrapper.setPageSize(bookPages.getSize());
		dataWrapper.setTotalElement(bookPages.getTotalElements());
		dataWrapper.setTotalPages(bookPages.getTotalPages());

		List<Book> books = bookPages.getContent();
		dataWrapper.setData(books);

		// employeeRepository.findAll().forEach(employees::add);

		return dataWrapper;
	}

	@Override
	public Collection<Book> findByName(String name) {
		List<Book> books = bookRepository.findByName(name);
		return books;
	}

}
