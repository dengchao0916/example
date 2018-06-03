package com.dengchao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	private static Connection connection = null;
	public static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	static {
		// 1.加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库的连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void prepareStatement(String sql) {
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ResultSet getResultSetQuery() {
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void executeInsert() {
		try {
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}