package com.jaqueline.giogameclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GameServerAPI {
	// Class that represents all HTTP requests that can be made to the game-server
	// All methods use the getURL method to access the server
	// Each method define the URL to be used (including parameters)

	String serverURL = "http://localhost:8080/"; // URL where Game Server is running

	// Adds a player to the server
	public boolean addPlayer(String playerName) {
		String URL = serverURL + "addPlayer?name=" + playerName;
		boolean result = Boolean.parseBoolean(getURL(URL));
		return result;
	}

	// Checks with the server if the game is over or is still ongoing
	public boolean isGameOngoing() {
		String URL = serverURL + "isGameOngoing";
		boolean result = Boolean.parseBoolean(getURL(URL));
		return result;
	}

	// Get from the server which player's turn is
	public String getCurrentPlayer() {
		String URL = serverURL + "getCurrentPlayer";
		return getURL(URL);
	}

	// Requests the server to add a disc on a given column
	public boolean addDisc(String playerName, int column) {
		String URL = serverURL + "addDisc?playerName=" + playerName + "&column=" + column;
		boolean result = Boolean.parseBoolean(getURL(URL));
		return result;
	}

	// Get the current state of the board from the server
	public String getBoard() {
		String URL = serverURL + "getBoard";
		return getURL(URL);
	}

	// Check if there is a winner and displays to the players
	public String getWinner() {
		String URL = serverURL + "getWinner";
		return getURL(URL);
	}
	
	// End the game before closing the Client application
	public void endGame(String playerName) {
		String URL = serverURL + "endGame?playerName=" + playerName;
		getURL(URL);
	}
	

	// Generic method to make HTTP connection to the server and return a String with
	// the response
	public String getURL(String address) {

		// Based on: https://www.baeldung.com/java-http-request

		String result = "";
		HttpURLConnection con = null;

		try {
			URL url = null;
			url = new URL(address);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.getResponseCode(); // to execute submit the connection

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine + "\n");
			}
			in.close();

			result = content.toString();
			result = result.substring(0, result.length() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
		}

		return result;
	}
	
	

}
