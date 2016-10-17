package com.lifefortress.basic.app.library.service.impl;

import java.util.List;

import com.lifefortress.basic.app.library.dao.BookDao;
import com.lifefortress.basic.app.library.dao.impl.BookDaoImpl;
import com.lifefortress.basic.app.library.domain.Book;
import com.lifefortress.basic.app.library.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public boolean insert(Book book) throws Exception {
		return bookDao.insert(book);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookDao.findById(id);
	}

}
