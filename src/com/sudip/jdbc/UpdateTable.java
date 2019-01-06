package com.sudip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {

	public String updateTable(int id, int price) {
		GetConnection gc = new GetConnection();
		Connection con = gc.getJDBCConnection();
		String result = null;
		try {
			PreparedStatement ps = con.prepareStatement("update restful set price = ? where id = ?");
			ps.setInt(1, price);
			ps.setInt(2, id);
			int n = ps.executeUpdate();
			if (n != 0) {
				result = "Successfully updated";
			}else{
				result = "Cannot update";
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
