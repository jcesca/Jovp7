package com.jaqueline.giogame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GioGameApplication {
	
	Game game = new Game();

	public static void main(String[] args) {
		SpringApplication.run(GioGameApplication.class, args);
	}
		
	// Server side - Receives player name from client
	@GetMapping("/addPlayer")
	public boolean addPlayer(@RequestParam(value = "name") String name) {
		return game.addPlayer(name);
		
	}
	
	// Server side - Receives GET request if the game is ongoing
	@GetMapping("/isGameOngoing")
	public boolean isGameOngoing() {
		return game.isGameOngoing();
	}
	
	// Server side - Receives current player from client
	@GetMapping("/getCurrentPlayer")
	public String getCurrentPlayer() {
		return game.getCurrentPlayer();
	}
	
	// Server side - Receives player name and what column the player has played from client
	@GetMapping("/addDisc")
	public boolean addDisc(@RequestParam(value = "playerName") String playerName, @RequestParam(value = "column") int column) {
		return game.addDisc(playerName, column);
		
	}
	
	// Server side - Sends the current state of the board board to client
	@GetMapping("/getBoard")
	public String getBoard() {
		return game.getBoard();
	}
	
	// Server side - Receives player name of the winner of the game and displays to the players
	@GetMapping("/getWinner")
	public String getWinner() {
		return game.getWinner();
	}
	
	// Server side - Ends the Game before closing the client application
	@GetMapping("/endGame")
	public String endGame(@RequestParam(value = "playerName") String playerName) {
		game.endGame(playerName);
		return "Bye!";
	}
	

}
