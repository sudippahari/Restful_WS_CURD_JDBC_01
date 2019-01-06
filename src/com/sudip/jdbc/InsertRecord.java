package com.sudip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecord {

	public String insert(int id, String name, int price) {

		String result = null;
		GetConnection gc = new GetConnection();
		Connection con = gc.getJDBCConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into restful values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("Successfully inserted");
				result = "Successfully inserted";
			} else {
				result = "Cannot insert";
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
