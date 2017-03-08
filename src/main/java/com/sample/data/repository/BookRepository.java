package com.sample.data.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sample.data.model.Book;
/**
 * This is Book repository used to perform CRUD operations.
 * 
 * @author shyam.pareek
 *
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

	@View(viewName="byName")
	List<Book> findByName(String name);
	
}
