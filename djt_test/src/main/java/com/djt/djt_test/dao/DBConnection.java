package com.djt.djt_test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);

    private static final String dbUser = "root";
    private static final String dbPassword = "orange";

    public static Connection getConnectionToDatabase() throws SQLException {
        Connection connection = null;
		//load the class driver
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mysql jdbc driver loaded");
				
        // Get hold of the driver manager
	    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/djt_test",dbUser,dbPassword);
		
        }  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	System.out.println("jdbc driver not found");
			e.printStackTrace();
		}
	    
        catch (SQLException e) { 
		// TODO Auto-generated catch block
    	System.out.println("jdbc connection failed");
		e.printStackTrace();
		}
	    
	    
	    if (connection != null) {
			System.out.println("databse connection successful");
		}
		
        return connection;
    
    }
}

