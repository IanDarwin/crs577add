package com.darwinsys.clientware;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A JAX-RS client NOT using the JAX-RS Client API
 * In fact, not using anything except Core Java APIs.
 */
public class UrlJaxRsClient {

	static final String BASE_URL = 
		"http://androidcookbook.com/rest/recipe";

	public static void main(String[] args) throws Exception {
		final int recipeId = 4;
		URL url = new URL(BASE_URL + "/" + recipeId);
		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("Accept", "application/json");
		InputStream is = connection.getInputStream();
		// Read "is" to get the response from a GET
		BufferedReader bi = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = bi.readLine()) != null) {
			System.out.println(line);
		}
	}
}