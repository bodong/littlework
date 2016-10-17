package com.lifefortress.basic.app.library.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			System.err.println("unable to close the connection " + e.getMessage());
		}
	}
	
	public static void closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (Exception e) {
			System.err.println("unable to close the statement " + e.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			System.err.println("unable to close the result set " + e.getMessage());
		}
	}
}
