package com.sudip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTable {

	public String deleteTable(int id) {
		String result = null;
		GetConnection gc = new GetConnection();
		Connection con = gc.getJDBCConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from restful where id = ?");
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("Sucessfully deleted record.");
				result = "Sucessfully deleted record";
			} else {
				result = "Cannot delete record";
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
