package com.lifefortress.basic.app.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lifefortress.basic.app.library.dao.BookDao;
import com.lifefortress.basic.app.library.db.ConnectionFactory;
import com.lifefortress.basic.app.library.db.DBUtil;
import com.lifefortress.basic.app.library.domain.Book;

public class BookDaoImpl implements BookDao {

	private Connection connection;
	private PreparedStatement statement;

	public BookDaoImpl() {}
	
	@Override
	public boolean insert(Book book) throws Exception {
		String query = "insert into book values(?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, book.getId());
			statement.setString(2, book.getDescription());
			statement.setString(3, book.getTitle());
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("There is a problem " + e.getMessage());
			return false;
		} finally{
			DBUtil.closeStatement(statement);
			DBUtil.closeConnection(connection);
		}
		return true;
	}

	@Override
	public List<Book> findAll() {
		String query = "select * from book";
		ResultSet rs = null;
		List<Book> books = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			
			rs = statement.executeQuery();
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
		String query = "select * from book where id=?";
		ResultSet rs = null;
		Book book = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setId(rs.getLong("id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
			}
			
		} catch (Exception e) {
			System.err.println("There is a problem " + e.getMessage());
		} finally{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(statement);
			DBUtil.closeConnection(connection);
		}
		return book;
	}

	@Override
	public boolean update(Book book) throws Exception {
		String query = "update book set title=?, description=? where id=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getDescription());
			statement.setLong(3, book.getId());
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("There is a problem " + e.getMessage());
			return false;
		} finally{
			DBUtil.closeStatement(statement);
			DBUtil.closeConnection(connection);
		}
		return true;
	}

}
