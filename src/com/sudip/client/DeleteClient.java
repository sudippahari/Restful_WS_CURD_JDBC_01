package com.sudip.client;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeleteClient {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id for the product to be deleted: ");

		String url = "http://localhost:8525/Restful_WS_CURD_JDBC_01/rest/manager/delete/" + sc.nextInt();
		Client client = Client.create();
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.delete(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		System.out.println("Output from server:");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}

}
