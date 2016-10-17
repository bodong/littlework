package com.lifefortress.basic.app.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lifefortress.basic.app.library.dao.BookDao;
import com.lifefortress.basic.app.library.db.ConnectionFactory;
import com.lifefortress.basic.app.library.db.DBUtil;
import com.lifefortress.basic.app.library.domain.Book;

public class BookDaoImpl implements BookDao {

	private Connection connection;
	private Statement statement;

	public BookDaoImpl() {}
	
	@Override
	public boolean insert(Book book) throws Exception {
		return false;
	}

	@Override
	public List<Book> findAll() {
		String query = "select * from book";
		ResultSet rs = null;
		List<Book> books = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			
			rs = statement.executeQuery(query);
			books = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				
				books.add(book);
			}
			
		} catch (Exception e) {
			System.err.println("There is a problem " + e.getMessage());
		} finally{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(statement);
			DBUtil.closeConnection(connection);
		}
		return books;
	}

	@Override
	public Book findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
