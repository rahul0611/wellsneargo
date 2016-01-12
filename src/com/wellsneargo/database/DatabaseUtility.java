package com.wellsneargo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {

	static Connection connection;

	
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		if (connection == null) {
			Class.forName(DatabaseConfig.DB_DRIVER_CLASS);
			connection = DriverManager.getConnection(DatabaseConfig.DB_URL
					+ "/" + DatabaseConfig.DB_NAME, DatabaseConfig.DB_USERNAME,
					DatabaseConfig.DB_PASSWORD);
			return connection;
		} else {
			return connection;
		}
	}
}