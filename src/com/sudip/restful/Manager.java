package com.sudip.restful;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sudip.jdbc.CreateTable;
import com.sudip.jdbc.DeleteTable;
import com.sudip.jdbc.InsertRecord;
import com.sudip.jdbc.Restful;
import com.sudip.jdbc.SelectAll;
import com.sudip.jdbc.SelectRecord;
import com.sudip.jdbc.UpdateTable;

@Path("/manager")
public class Manager {

	@Path("/create")
	@GET
	public void createTable() {
		CreateTable ct = new CreateTable();
		ct.createTable();
	}

	@Path("/insert/{id}/{name}/{price}")
	@PUT
	public String insertRecord(@PathParam("id") int id, @PathParam("name") String name, @PathParam("price") int price) {
		InsertRecord ir = new InsertRecord();
		String result = ir.insert(id, name, price);
		return result;
	}

	@Path("/delete/{id}")
	@DELETE
	public String deleteRecord(@PathParam("id") int id) {
		DeleteTable dt = new DeleteTable();
		String result = dt.deleteTable(id);
		return result;
	}

	@Path("/selectAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Restful> selectAll() {
		SelectAll sa = new SelectAll();
		ArrayList<Restful> rfl = sa.selectAll();
		/*
		 * ArrayList<String> als = new ArrayList<String>(); String r = ""; for
		 * (Restful rs : rfl) { r = r + rs.getId() + "\t" + rs.getName() + "\t"
		 * + rs.getPrice() + "\n";
		 * 
		 * }
		 * 
		 * return r;
		 */
		return rfl;
	}

	@Path("/displayRecord/{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String displayRecord(@PathParam("id") int id) {
		SelectRecord sr = new SelectRecord();
		Restful rs = sr.selectRecord(id);
		return rs.getId() + "\t" + rs.getName() + "\t" + rs.getPrice();
	}

	@Path("/update/{id}/{price}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String updateRecord(@PathParam("id") int id, @PathParam("price") int price) {
		UpdateTable ut = new UpdateTable();
		String result = ut.updateTable(id, price);
		return result;

	}

}
