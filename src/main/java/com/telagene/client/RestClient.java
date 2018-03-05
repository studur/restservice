package com.telagene.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class RestClient {

   public static final String REST_SERVICE_BASE_URL = "http://127.0.0.1:8088/rest/";

   public static void main(String[] args) {


      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(REST_SERVICE_BASE_URL);
      String response = target.path("status").request().get(String.class);

      System.out.println(response.toString());

      client.close();

   }
}

