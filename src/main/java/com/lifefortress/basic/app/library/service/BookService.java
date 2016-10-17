package com.lifefortress.basic.app.library.service;

import java.util.List;

import com.lifefortress.basic.app.library.domain.Book;

public interface BookService {
	boolean insert(Book book) throws Exception;
	
	boolean update(Book book) throws Exception;
	
	List<Book> findAll();
	
	Book findById(final Long id);
}
