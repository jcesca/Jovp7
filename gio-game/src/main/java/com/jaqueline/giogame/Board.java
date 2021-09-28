package com.jaqueline.giogame;

public class Board {

	
	private String[][] board = new String[6][9]; // Board size
	private boolean madeFive = false; // calls method madeFive 
	private int discsPlayed = 0;

	// Initialize board with " " on all positions
	public Board() {

		// Builds the board configurable
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = " ";
			}
		}

	}
	
	// Make the play by adding the symbol to the given column
	public boolean add(String symbol, int column) {
		// The bottom row is 0
		// Returns false for invalid plays (like out of bounds)
		// Returns true for successful plays

		// Offset from board display to Java Array
		column--;

		// Checks for column boundaries
		if ( (column < 0) || (column > board[0].length-1)) {
			return false;
		}

		// When there's a empty space on the board, add a symbol from a player
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == " ") {
				board[i][column] = symbol;	
				discsPlayed++;	// Increments the number of discs played (in case of tie)
				checkMadeFive(i, column, symbol);
				return true;
			}
		}
		return false;
	}
	
	// Returns a String representing the current state of the board  
	public String toString() {
		// Creates board header configurable
		String result = "";
		for(int i = 1; i <= board[0].length; i++) {
			result = result + " " + i + "  ";			
		}
		result = result + "\n";
		
		for (int r = board.length - 1; r >= 0; r--) {
			String row = "";
			for (int c = 0; c < board[r].length; c++) {
				row += "[" + board[r][c] + "] ";
			}
			result += row + "\n";
		}
		return result;
	}
	
	// Verifies if last play made five discs in a row vertically, horizontally, diagonal forward and diagonal backwards
	public void checkMadeFive(int row, int column, String symbol) {		
		madeFive = checkFiveVertical(row, column, symbol) ||
				checkFiveHorizontal(row, column, symbol) ||
				checkFiveDiagonalForward(row, column, symbol) ||
				checkFiveDiagonalBackwards(row, column, symbol);
		
	}
	
	public boolean getMadeFive() {
		return madeFive;
	}
	
	// Check Vertical (always top to bottom)
	private boolean checkFiveVertical(int row, int column, String symbol) {
		
		int down = 0;
		int i = row-1;
		while((i >= 0) && (board[i][column] == symbol)) {
			down++;
			i--;
		}
		
		// Verifies if there are four discs down (there is no disc up)
		if(down == 4) {
			return true;
		} else {
			return false;
		}
	}
	
	// Check horizontal (check both sides - left and right of the disc)
	private boolean checkFiveHorizontal(int row, int column, String symbol) {
		//Check Horizontal
		int countRight = 0;
		int countLeft = 0;

		
		// Count to the Right 
		int i=1;
		boolean sameSymbol = true;
		while(column + i < board[0].length && sameSymbol) {
			sameSymbol = board[row][column+i].equals(symbol);
			if(sameSymbol) {
				countRight++;
				i++;
			}
		}

		// Count to the Left
		i=1;
		sameSymbol = true;
		while(column - i >= 0 && sameSymbol) {
			sameSymbol = board[row][column-i].equals(symbol);
			if(sameSymbol) {
				countLeft++;
				i++;
			}
		}

		
		// Checks if they sum 4
		if(countRight + countLeft == 4) {
			return true;
		} else {
			return false;
		}

	}

	// Check Diagonal Forward "/"
	private boolean checkFiveDiagonalForward(int row, int column, String symbol) {
		
		int countUpRight = 0;
		int countDownLeft = 0;
		int i = 1;
		boolean sameSymbol = true;

		// Counts Up and Right
		while((column + i < board[0].length) && (row + i < board.length) && (sameSymbol)){
			sameSymbol = board[row+i][column+i].equals(symbol);
			if (sameSymbol) {
				countUpRight++;
				i++;				
			}
		}


		// Counts Down and Left
		i = 1;
		sameSymbol = true;
		
		while((column - i >= 0) && (row - i >= 0) && (sameSymbol)){
			sameSymbol = board[row-i][column-i].equals(symbol);
			if (sameSymbol) {
				countDownLeft++;
				i++;				
			}
		}

		// Checks if they sum 4
		if(countUpRight + countDownLeft == 4) {
			return true;
		} else {
			return false;
		}
	}

	// Checks Diagonal Backwards "\"
	private boolean checkFiveDiagonalBackwards(int row, int column, String symbol) {
		
		int countDownRight = 0;
		int countUpLeft = 0;
		int i = 1;
		boolean sameSymbol = true;

		// Count Down and Right
		while((column + i < board[0].length) && (row - i >= 0) && (sameSymbol)){
			sameSymbol = board[row-i][column+i].equals(symbol);
			if (sameSymbol) {
				countDownRight++;
				i++;				
			}
		}
		
		// Count Up and Left
		i = 1;
		sameSymbol = true;
		
		while((column -i >= 0) && (row + i < board.length) && (sameSymbol)){
			sameSymbol = board[row+i][column-i].equals(symbol);
			if (sameSymbol) {
				countUpLeft++;
				i++;				
			}
		}

		// Checks if it sums 4
		if(countDownRight + countUpLeft == 4) {
			return true;
		} else {
			return false;
		}
		
	}
	
	// Check if board is full based on the amount of successful plays
	public boolean isBoardFull() {
		if (discsPlayed == 54) {
			return true;
		} else {
			return false;
		}
	}

}
