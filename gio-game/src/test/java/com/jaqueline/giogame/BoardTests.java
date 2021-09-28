package com.jaqueline.giogame;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTests {

	@Test
	void should_return_false_when_add_disc_out_of_bounds() {
		// Valid columns are from 1 to 9
		Board b = new Board();
		assertFalse(b.add("X", 0));
		assertFalse(b.add("X", 10));		
	}
	
	@Test
	void should_return_false_when_add_disc_to_a_full_column() {
		Board b = new Board();
		b.add("X", 3);
		b.add("O", 3);
		b.add("X", 3);
		b.add("O", 3);
		b.add("X", 3);
		b.add("O", 3);
		assertFalse(b.add("X", 3));
		
	}
	
	@Test
	void should_set_made_five_to_true_when_put_five_togheter_vertical() {
		Board b = new Board();
		b.add("X", 1);
		b.add("O", 2);
		b.add("X", 1);
		b.add("O", 3);
		b.add("X", 1);
		b.add("O", 4);
		b.add("X", 1);
		b.add("O", 4);
		assertTrue(b.add("X", 1));
		assertTrue(b.getMadeFive());
	}
	
	@Test
	void should_set_made_five_to_true_when_put_five_togheter_horizontal_last_position() {
		Board b = new Board();
		b.add("X", 1);
		b.add("O", 1);
		b.add("X", 2);
		b.add("O", 3);
		b.add("X", 2);
		b.add("O", 4);
		b.add("X", 3);
		b.add("O", 5);
		b.add("X", 4);
		b.add("O", 6);
		b.add("X", 5);
		assertTrue(b.add("O", 7));
		assertTrue(b.getMadeFive());
	}
	
	@Test
	void should_set_made_five_to_true_when_put_five_togheter_horizontal_first_position() {
		Board b = new Board();
		b.add("X", 1);
		b.add("O", 1);
		b.add("X", 2);
		b.add("O", 3);
		b.add("X", 3);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 6);
		b.add("X", 6);
		b.add("O", 1);
		assertTrue(b.add("X", 2));
		assertTrue(b.getMadeFive());
	}

	@Test
	void should_set_made_five_to_true_when_put_five_togheter_horizontal_mid_position() {
		Board b = new Board();
		b.add("X", 1);
		b.add("O", 1);
		b.add("X", 2);
		b.add("O", 3);
		b.add("X", 3);
		b.add("O", 4);
		b.add("X", 2);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 6);
		b.add("X", 6);
		b.add("O", 1);
		assertTrue(b.add("X", 4));
		assertTrue(b.getMadeFive());
	}

	@Test
	void should_set_made_five_to_true_when_put_five_togheter_diagonal_forward_last_position() {
		Board b = new Board();
		b.add("X", 1);
		b.add("O", 2);
		b.add("X", 2);
		b.add("O", 3);
		b.add("X", 4);
		b.add("O", 3);
		b.add("X", 3);
		b.add("O", 4);
		b.add("X", 5);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 5);
		assertTrue(b.add("X", 5));
		assertTrue(b.getMadeFive());
	}
	
	@Test
	void should_set_made_five_to_true_when_put_five_togheter_diagonal_forward_first_position() {
		Board b = new Board();
		b.add("X", 9);
		b.add("O", 2);
		b.add("X", 2);
		b.add("O", 3);
		b.add("X", 4);
		b.add("O", 3);
		b.add("X", 3);
		b.add("O", 4);
		b.add("X", 5);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 5);
		assertTrue(b.add("X", 1));
		assertTrue(b.getMadeFive());
	}
	
	@Test
	void should_set_made_five_to_true_when_put_five_togheter_diagonal_forward_mid_position() {
		Board b = new Board();
		b.add("X", 1);
		b.add("O", 2);
		b.add("X", 2);
		b.add("O", 3);
		b.add("X", 4);
		b.add("O", 3);
		b.add("X", 9);
		b.add("O", 4);
		b.add("X", 5);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 9);		
		assertTrue(b.add("X", 3));
		assertTrue(b.getMadeFive());
	}
	
	@Test
	void should_set_made_five_to_true_when_put_five_togheter_diagonal_backwards_first_position() {
		Board b = new Board();
		b.add("X", 9);
		b.add("O", 5);
		b.add("X", 8);
		b.add("O", 6);
		b.add("X", 8);
		b.add("O", 7);
		b.add("X", 7);
		b.add("O", 4);
		b.add("X", 7);
		b.add("O", 6);
		b.add("X", 3);
		b.add("O", 6);
		b.add("X", 6);
		b.add("O", 5);
		b.add("X", 5);
		b.add("O", 5);
		assertTrue(b.add("X", 5));
		assertTrue(b.getMadeFive());
	}

	@Test
	void should_set_made_five_to_true_when_put_five_togheter_diagonal_backwards_last_position() {
		Board b = new Board();
		b.add("X", 4);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 4);
		b.add("X", 5);
		b.add("O", 6);
		b.add("X", 5);
		b.add("O", 5);
		b.add("X", 6);
		b.add("O", 5);
		b.add("X", 6);
		b.add("O", 5);
		b.add("X", 7);
		b.add("O", 7);
		b.add("X", 8);
		b.add("O", 7);
		b.add("X", 9);
		b.add("O", 6);
		b.add("X", 3);
		assertTrue(b.add("O", 8));
		assertTrue(b.getMadeFive());
	}

	@Test
	void should_set_made_five_to_true_when_put_five_togheter_diagonal_backwards_mid_position() {
		Board b = new Board();
		b.add("X", 4);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 4);
		b.add("X", 4);
		b.add("O", 4);
		b.add("X", 5);
		b.add("O", 6);
		b.add("X", 5);
		b.add("O", 5);
		b.add("X", 6);
		b.add("O", 5);
		b.add("X", 6);
		b.add("O", 5);
		b.add("X", 7);
		b.add("O", 7);
		b.add("X", 8);
		b.add("O", 7);
		b.add("X", 9);
		b.add("O", 8);
		b.add("X", 3);
		assertTrue(b.add("O", 6));
		assertTrue(b.getMadeFive());
	}
	
}
