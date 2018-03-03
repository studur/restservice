package com.telagene.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {


   public static void main(String[] args) {
      String USER_AGENT = "Mozilla/5.0";
      String url = "http://localhost:8088/rest/status";

      URL obj = null;
      try {
         obj = new URL(url);

      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod("GET");

      //add request header
      con.setRequestProperty("User-Agent", USER_AGENT);

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
         response.append(inputLine);
      }
      in.close();
         //print result
         System.out.println(response.toString());
      } catch (Exception e) {
         e.printStackTrace();
      }


   }
}

