package com.jaqueline.giogame;

public class Game {

	private String player1 = ""; // X
	private String player2 = ""; // O
	private String currentPlayer;
	private boolean isGameOngoing = false;
	private Board board;
	private String winner;

	// Adds players to the game receiving their names and storing in the variables
	// "player1" and "player2"
	public boolean addPlayer(String name) {

		// Checks for empty name
		if (name.trim().equals("")) {
			return false;
		}

		if (player1 == "") {
			player1 = name;
			return true;
		} else if (player2 == "") {
			player2 = name;

			// when the two players are added successfully, calls start the game method
			startGame();
			return true;
		}

		return false;
	}

	// start the game by setting the game as ongoing, sets current player and
	// initialize board
	private void startGame() {
		isGameOngoing = true;
		currentPlayer = player1;
		board = new Board();
	}

	// calls the method to get which player should play
	public String getCurrentPlayer() {
		return currentPlayer;
	}

	// calls the method to verify if the game is ongoing
	public boolean isGameOngoing() {
		return isGameOngoing;
	}

	// calls the method to verify the winner when game is finished
	public String getWinner() {
		if (!isGameOngoing) {
			return winner;
		}
		return "";
	}

	// Makes the play by adding discs to the board by each player
	public boolean addDisc(String playerName, int column) {
		boolean result = false;

		// Receives player name, column and symbol to make the play
		if (playerName.equals(currentPlayer)) {
			if (playerName.equals(player1)) {
				result = board.add("X", column);

				// Check if there is a winner with the last move received
				if (board.getMadeFive()) {
					winner = playerName;
					isGameOngoing = false;

				} else {
					// Check if board is full (and game is tied)
					if (board.isBoardFull()) {
						isGameOngoing = false;
						winner = "There is no winner. Game tied!!";
					}

					// Pass turn to play to the other player if there is no winner
					if (result) {
						currentPlayer = player2;
					}
				}

				// Second player make the play passing players name and column
			} else if (playerName.equals(player2)) {
				result = board.add("O", column);

				// check if second player has won, if not pass the turn to player 1
				if (board.getMadeFive()) {
					winner = playerName;
					isGameOngoing = false;
				} else {
					// Check if board is full (and game is tied)
					if (board.isBoardFull()) {
						isGameOngoing = false;
						winner = "There is no winner. Game tied!!";
					}

					// Pass turn to play to the other player if there is no winner
					if (result) {
						currentPlayer = player1;
					}

				}
			}
		}

		return result;
	}

	// Cleanup after the game
	public void endGame(String playerName) {
		
		// Unregister the player
		if (player1.equals(playerName)) {
			player1 = "";
		}
		
		if (player2.equals(playerName)) {
			player2 = "";
		}
		
		// If all players are unregistered and there is no game ongoing, clear the game for the next round
		if ( !isGameOngoing && player1.equals("") && player2.equals("")) {
			currentPlayer = "";
			winner = ""; // reset winner from the last game
			board = new Board();
		}
	}

	// Calls the method to get the updated board and show to the players
	public String getBoard() {
		return board.toString();
	}

}
