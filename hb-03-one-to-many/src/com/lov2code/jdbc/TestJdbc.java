package com.lov2code.jdbc;

import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connecting to database: "+jdbcUrl);
			
			DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful !!!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
