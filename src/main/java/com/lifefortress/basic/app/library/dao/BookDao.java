package com.lifefortress.basic.app.library.dao;

import java.util.List;

import com.lifefortress.basic.app.library.domain.Book;

public interface BookDao {
	boolean insert(Book book) throws Exception;
	
	List<Book> findAll();
	
	Book findById(final Long id);
}
