package com.lifefortress.basic.app.library;

import com.lifefortress.basic.app.library.domain.Book;
import com.lifefortress.basic.app.library.service.BookService;
import com.lifefortress.basic.app.library.service.impl.BookServiceImpl;

public class LibraryApp {
	public static void main(String[] args) {
		
		BookService bookService = new BookServiceImpl();
		
		Book book = bookService.findById(1l);
		System.out.println("before update ## desc : " +  book.getDescription());
		book.setDescription("please update this again!");
		update(bookService, book);
		book = bookService.findById(1l);
		System.out.println("after update ## desc : " +  book.getDescription());
	}

	private static void update(BookService bookService, Book book) {
		try {
			bookService.update(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createNewBook(BookService bookService) {
		Book newBook = getNewBook();
		boolean status;
		try {
			status = bookService.insert(newBook);
			System.out.println("boook is inserted : " + status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Book getNewBook() {
		Book book = new Book();
		book.setId(3l);
		book.setTitle("test");
		book.setDescription("ok");
		return book;
	}

}
