package com.sudip.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public void createTable() {
		GetConnection gc = new GetConnection();
		Connection con = gc.getJDBCConnection();
		try {
			Statement st = con.createStatement();
			st.execute("create table restful(id int(3), name varchar(10), price decimal(10))");
			System.out.println("Table Successfully created.");
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
