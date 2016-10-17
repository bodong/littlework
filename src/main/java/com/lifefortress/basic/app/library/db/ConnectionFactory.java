package com.lifefortress.basic.app.library.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static ConnectionFactory INSTANCE = new ConnectionFactory();
	public static final String URL = "jdbc:postgresql://localhost/library";
	public static final String USER = "postgres";
	public static final String PASSWORD = "root";
	public static final String DRIVER = "org.postgresql.Driver";
	
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.err.println("Unable to load the driver");
		} 
		
		return connection;
	}
	
	public static Connection getConnection() {
		return INSTANCE.createConnection();
	}
}
