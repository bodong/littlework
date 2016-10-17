package com.lifefortress.basic.app.library;

import java.util.List;

import com.lifefortress.basic.app.library.domain.Book;
import com.lifefortress.basic.app.library.service.BookService;
import com.lifefortress.basic.app.library.service.impl.BookServiceImpl;

public class LibraryApp {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			System.out.println(book.getId() + " |" + book.getTitle() + "| " + book.getDescription());
		}
	}

}
