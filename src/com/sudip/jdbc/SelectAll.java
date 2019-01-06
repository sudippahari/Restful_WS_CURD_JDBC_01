package com.sudip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectAll {

	public ArrayList<Restful> selectAll() {
		GetConnection gc = new GetConnection();
		Connection con = gc.getJDBCConnection();
		ArrayList<Restful> rfl = new ArrayList<Restful>();
			try {
				PreparedStatement ps = con.prepareStatement("select * from restful");
				ResultSet rs = ps.executeQuery();
				Restful rf = null;
				while (rs.next()) {
					rf = new Restful();
					rf.setId(rs.getInt(1));
					rf.setName(rs.getString(2));
					rf.setPrice(rs.getInt(3));
					rfl.add(rf);
				}
				ps.close();
				con.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rfl;
			
	}
}
