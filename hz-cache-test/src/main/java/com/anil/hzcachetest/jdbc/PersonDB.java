package com.anil.hzcachetest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDB {


	public static void createTable(){

		Connection con = null;
		Statement stmt = null;
		int result = 0;

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/persondb", "", "");
			stmt = con.createStatement();

			stmt.executeUpdate("DROP TABLE person IF EXISTS");
			result = stmt.executeUpdate("CREATE TABLE person ("+
					"id varchar(50) NOT NULL, name VARCHAR(50) NOT NULL,"+
					"city VARCHAR(20) NOT NULL, state varchar(20) not null)");
			stmt.close();
			for(int i=0;i<10;i++){
				stmt = con.createStatement();
				StringBuffer sb = new StringBuffer();
				sb.append("insert into person values(");
				sb.append("'").append(i).append("'").append(",").append("'").append("name").append(i).append("'").append(",")
				.append("'").append("city").append(i).append("'").append(",")
				.append("'").append("state").append(i).append("'")
				.append(")");
				System.out.println(sb.toString());
				int k = stmt.executeUpdate(sb.toString());
				stmt.close();	 
			}
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person");
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}

		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public static void main(String[] args) {
		createTable();
	}
}
