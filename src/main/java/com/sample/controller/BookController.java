package com.sample.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.data.model.Book;
import com.sample.dto.AppResponse;
import com.sample.dto.DataWrapper;
import com.sample.service.BookService;
import com.sample.util.AppConstant;

/**
 * This is Rest controller used to expose URL for application to access Book.
 * 
 * @author shyam.pareek
 *
 */
@RestController
public class BookController {

	@Autowired
	private BookService bookSrvice;

	@RequestMapping("/getBook/{id}")
	public Book getBook(@PathVariable Long id) {

		return bookSrvice.getBook(id);
	}

	@RequestMapping("/getBooksByName/{name}")
	public Collection<Book> getBook(@PathVariable String name) {

		return bookSrvice.findByName(name);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public AppResponse addBook(@RequestBody Book book) {

		try {
			/*
			 * if (bookSrvice.findByEmail(employee.getEmail()) != null) {
			 * AppResponse response = new AppResponse(AppConstant.ERROR_CODE,
			 * true, "Email already exist !!!", null); return response; }
			 */

			bookSrvice.addBook(book);
			AppResponse response = new AppResponse(AppConstant.SUCCESS_CODE, true, "Add Success !!!", null);
			return response;
		} catch (Exception e) {
			AppResponse response = new AppResponse(AppConstant.ERROR_CODE, true, "Server Error !!!", null);
			return response;
		}
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
	public AppResponse updateBook(@RequestBody Book book) {

		try {
			/*
			 * Book bookDB = employeeService.findByEmail(employee.getEmail());
			 * if (!employeeDB.getId().equals(employee.getId())) { AppResponse
			 * response = new AppResponse(AppConstant.ERROR_CODE, true,
			 * "Email already exist !!!", null); return response; }
			 */
			bookSrvice.updateBook(book);
			AppResponse response = new AppResponse(AppConstant.SUCCESS_CODE, true, "Update Success !!!", null);
			return response;
		} catch (Exception e) {
			AppResponse response = new AppResponse(AppConstant.ERROR_CODE, true, "Server Error !!!", null);
			return response;
		}
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE)
	public AppResponse deleteBook(@PathVariable Long id) {

		try {
			bookSrvice.deleteBook(id);
			AppResponse response = new AppResponse(AppConstant.SUCCESS_CODE, true, "Delete Success !!!", null);
			return response;
		} catch (Exception e) {
			AppResponse response = new AppResponse(AppConstant.ERROR_CODE, true, "Server Error !!!", null);
			return response;
		}
	}

	@RequestMapping("/getBooks")
	public DataWrapper getBooks(@RequestParam(required = true) int currentPage) {

		int currentPageIndx = currentPage - 1;
		if (currentPageIndx < 0) {
			currentPageIndx = 0;
		}
		PageRequest pageRequest = new PageRequest(currentPageIndx, 5);

		DataWrapper dataWrapper = bookSrvice.getBooksPage(pageRequest);

		return dataWrapper;
	}
}
