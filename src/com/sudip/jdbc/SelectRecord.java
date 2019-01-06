package com.sudip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectRecord {

	public Restful selectRecord(int id) {
		GetConnection gc = new GetConnection();
		Connection con = gc.getJDBCConnection();
		Restful rf = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from restful where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rf = new Restful();
			while (rs.next()) {
				rf.setId(rs.getInt(1));
				rf.setName(rs.getString(2));
				rf.setPrice(rs.getInt(3));
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rf;
	}
}
