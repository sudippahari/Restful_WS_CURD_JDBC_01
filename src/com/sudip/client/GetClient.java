package com.sudip.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetClient {

	public static void main(String[] args) {

		String url = "http://localhost:8525/Restful_WS_CURD_JDBC_01/rest/manager/selectAll";

		Client client = Client.create();
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		System.out.println("Output from server");
		String output = response.getEntity(String.class);
		System.out.println(output);

	}

}