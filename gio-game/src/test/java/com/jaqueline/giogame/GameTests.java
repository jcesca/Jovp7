package com.jaqueline.giogame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameTests {
	
	@Test
	void should_game_start_only_when_two_players_are_registered() {
		Game g = new Game();
		assertTrue(g.addPlayer("Gio"));
		assertFalse(g.isGameOngoing());
		assertTrue(g.addPlayer("Chiara"));
		assertTrue(g.isGameOngoing());
	}
	
	@Test
	void should_return_winner_when_player_has_won_the_game() {
		Game g = new Game();
		g.addPlayer("Gio");
		g.addPlayer("Chiara");
		
		g.addDisc("Gio", 1);
		g.addDisc("Chiara",2);
		g.addDisc("Gio", 1);
		g.addDisc("Chiara",3);
		g.addDisc("Gio", 1);
		g.addDisc("Chiara", 4);
		g.addDisc("Gio", 1);
		g.addDisc("Chiara", 4);
		
		assertTrue(g.isGameOngoing());
		g.addDisc("Gio", 1);
		assertFalse(g.isGameOngoing());
		assertEquals("Gio", g.getWinner());
	}
	
	@Test
	void should_stay_playing_when_player_plays_out_of_bounds() {
		Game g = new Game();
		g.addPlayer("Gio");
		g.addPlayer("Chiara");
		g.addDisc("Gio", 0);
		assertEquals("Gio", g.getCurrentPlayer());
	}
	
	@Test
	void should_player_only_plays_at_their_turn() {
		Game g = new Game();
		g.addPlayer("Gio");
		g.addPlayer("Chiara");	
		
		assertEquals("Gio", g.getCurrentPlayer());
		assertFalse(g.addDisc("Chiara", 8));
		assertEquals("Gio", g.getCurrentPlayer());
		g.addDisc("Gio", 2);
		
		assertEquals("Chiara", g.getCurrentPlayer());
		assertFalse(g.addDisc("Gio", 6));
		assertEquals("Chiara", g.getCurrentPlayer());
	}
	
	@Test
	void should_game_be_over_when_players_tie_when_board_is_full_and_nobody_wins() {
		// Testing full board
//		  1   2   3   4   5   6   7   8   9  
//		 [X] [X] [O] [X] [X] [X] [O] [X] [X] 
//		 [O] [X] [X] [O] [O] [X] [X] [O] [O] 
//		 [O] [O] [O] [X] [O] [O] [O] [X] [O] 
//		 [X] [O] [X] [O] [X] [X] [X] [O] [O] 
//		 [O] [X] [O] [X] [X] [O] [O] [X] [X] 
//		 [O] [O] [X] [O] [X] [X] [O] [X] [O] 
		
		Game g = new Game();
		g.addPlayer("Gio");
		g.addPlayer("Chiara");
		
		g.addDisc("Gio"   , 3);
		g.addDisc("Chiara", 1);
		g.addDisc("Gio"   , 5);
		g.addDisc("Chiara", 2);
		g.addDisc("Gio"   , 6);
		g.addDisc("Chiara", 4);
		g.addDisc("Gio"   , 8);
		g.addDisc("Chiara", 7);
		g.addDisc("Gio"   , 2);		
		g.addDisc("Chiara", 9);
		
		g.addDisc("Gio"   , 9);
		g.addDisc("Chiara", 1);
		g.addDisc("Gio"   , 4);
		g.addDisc("Chiara", 3);
		g.addDisc("Gio"   , 5);
		g.addDisc("Chiara", 6);
		g.addDisc("Gio"   , 8);
		g.addDisc("Chiara", 7);		
		g.addDisc("Gio"   , 1);
		g.addDisc("Chiara", 2);
		
		g.addDisc("Gio"   , 3);
		g.addDisc("Chiara", 4);
		g.addDisc("Gio"   , 5);
		g.addDisc("Chiara", 8);
		g.addDisc("Gio"   , 6);
		g.addDisc("Chiara", 9);
		g.addDisc("Gio"   , 7);		
		g.addDisc("Chiara", 1);		
		g.addDisc("Gio"   , 4);
		g.addDisc("Chiara", 2);
		
		g.addDisc("Gio"   , 8);
		g.addDisc("Chiara", 3);
		g.addDisc("Gio"   , 2);
		g.addDisc("Chiara", 5);
		g.addDisc("Gio"   , 3);
		g.addDisc("Chiara", 6);		
		g.addDisc("Gio"   , 6);
		g.addDisc("Chiara", 7);
		g.addDisc("Gio"   , 7);
		g.addDisc("Chiara", 9);
		
		g.addDisc("Gio"   , 2);
		g.addDisc("Chiara", 1);
		g.addDisc("Gio"   , 1);
		g.addDisc("Chiara", 4);
		g.addDisc("Gio"   , 4);
		g.addDisc("Chiara", 5);
		g.addDisc("Gio"   , 5);
		g.addDisc("Chiara", 8);
		g.addDisc("Gio"   , 6);
		g.addDisc("Chiara", 9);
		
		g.addDisc("Gio"   , 8);
		g.addDisc("Chiara", 3);
		g.addDisc("Gio"   , 9);
		g.addDisc("Chiara", 7);
		
		assertFalse(g.isGameOngoing());
		assertEquals("There is no winner. Game tied!!", g.getWinner());
				
	}
}
