package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class RookTests {
	
	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
		board.setupAll();
	}

	/**
	 * Tests the Rook's constructor by checking its initializations
	 */
	@Test
	public void rookConstructorTest()
	{
		Rook rook = new Rook(5,4,"black");
		assertEquals(5, rook.getXLocation());
		assertEquals(4, rook.getYLocation());
		assertEquals("black", rook.getTeam());
		assertEquals("Rook", rook.getType());
	}
	
	/**
	 * Tests updateMoveList for the Rook unit
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A rook in its intial poition should have no moves
		board.getPiece(7, 7).updateMoveList(7, 7, board);
		assertEquals(0, board.getPiece(7,7).getMoveList().size());
		
		//A rook with enemies in each of its 4 directions should have 4 moves
		board.addPiece(new Rook(4,4,"black"), 4, 4);
		board.addPiece(new Pawn(4,5,"white"), 4, 5);
		board.addPiece(new Pawn(5,4,"white"), 5, 4);
		board.addPiece(new Pawn(4,3,"white"), 4, 3);
		board.addPiece(new Pawn(3,4,"white"), 3, 4);
		board.getPiece(4, 4).updateMoveList(4, 4, board);
		assertEquals(4, board.getPiece(4,4).getMoveList().size());
		board.removePiece(4,4);
		board.removePiece(4,5);
		board.removePiece(5,4);
		board.removePiece(4,3);
		board.removePiece(3,4);
		
		//A rook on the right edge of a default board has 10 moves
		board.addPiece(new Rook(7,3,"black"), 7, 3);
		board.getPiece(7,3).updateMoveList(7, 3, board);
		assertEquals(11, board.getPiece(7,3).getMoveList().size());
		
		//A rook in a corner surrounded by units should have two moves
		board.removePiece(7,7);
		board.addPiece(new Rook(7,7,"black"), 7, 7);
		board.getPiece(7,7).updateMoveList(7, 7, board);
		assertEquals(2, board.getPiece(7,7).getMoveList().size());


	}

}
