package com.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class APIRest {
	private HttpURLConnection conn;
	
	/**
	 * Prints the error if the GET process fails.
	 * @return Error message
	 */
	private void PrintErr(Exception e)
	{
		System.out.println(APIRest.class.getName() + " | " + e.getClass() + " | " + e.getMessage());
	}
	
	/**
	 * Executes the API GET request
	 * @param endpointURL (API url)
	 * @return JSON data 
	 */
	public String get(String endpointURL)
	{
		StringBuilder data = null;
		
		try
		{
			URL url = new URL(endpointURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
		}
		catch (MalformedURLException e)
		{
			PrintErr(e);
		}
		catch (ProtocolException e)
		{
			PrintErr(e);
		}
		catch (IOException e)
		{
			PrintErr(e);
		}
		try
		{
			int status = conn.getResponseCode();
			if(status == 200)
			{
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				data = new StringBuilder();
				while((inputLine = in.readLine()) != null)
				{
					data.append(inputLine);
				}
				in.close();
			}
		}
		catch (IOException e)
		{
			PrintErr(e);
		}
		
		return data.toString();
	}
}
