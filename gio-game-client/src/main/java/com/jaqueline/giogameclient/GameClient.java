package com.jaqueline.giogameclient;

import java.util.Scanner;

public class GameClient {

	static Scanner inputScanner = new Scanner(System.in); // Creates a Scanner object
	static GameServerAPI gs = new GameServerAPI(); // Creates a server API object to handle communication with game server
	static String playerName = "";

	public static void main(String[] args) {
		
		// Basic game client flow
		
		if (!gs.isGameOngoing()) {
			registerNewPlayer();
			playGame();
			endGame();			
		} else {
			System.out.println("There is already a game ongoing on the server!");
		}

	}

	// Register new player
	public static void registerNewPlayer() {

		System.out.println("Please, enter player name: ");
		
		playerName = inputScanner.nextLine(); // Read user input
		
		while (!gs.addPlayer(playerName)) {
			System.out.println("Invalid player name. Please enter a valid name:");
			playerName = inputScanner.nextLine(); // Read user input
		}
		System.out.println("Player  " + playerName + " added to the server!"); // Output user input

		// Wait for game to start (two players registered)
		System.out.println("Waiting for the next player to join...");
		while (!gs.isGameOngoing()) {
			try {
				Thread.sleep(1000); // Waits one second between checks with server
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Game has started!");

	}

	// Gets the players inputs and outputs for the game
	public static void playGame() {
		while (gs.isGameOngoing()) {

			// Retrieve board from server and Print it
			String board = gs.getBoard();
			System.out.println("\n" + board);

			// player will add disc on the board
			if (playerName.equals(gs.getCurrentPlayer())) {
				System.out
						.println("It is your turn to play, choose column from 1 to 9 on the board to make your move!");

				System.out.println("Please, enter column number: ");

				int column = inputScanner.nextInt(); // Read user input	
				System.out.println("Column entered is: " + column); // Output user input

				// Ask to player play again when player make a out of bounds move
				if (!gs.addDisc(playerName, column)) {
					System.out.println("Invalid column number, please try again");
				}
			} else { // If it's not players turn, wait for their turn, or for the game to end
				System.out.println("Waiting for the other player to play...");
				while (!gs.getCurrentPlayer().equals(playerName) && gs.isGameOngoing()) {
					try {
						Thread.sleep(1000); // Waits a second between requests to server
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		}
	}

	// Finish the game when there is a winner and close players input 
	public static void endGame() {

		System.out.println("Game is over");

		String board = gs.getBoard();
		System.out.println(board);

		String winner = gs.getWinner();
		System.out.println("The winner is: " + winner);
		
		gs.endGame(playerName); // Unregister the player from server

		inputScanner.close();
	}
	
}


