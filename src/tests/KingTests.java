package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class KingTests {

	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
	}

	/**
	 * Tests the Knight's constructor by checking its initializations
	 */
	@Test
	public void kingConstructorTest()
	{
		board.setupAll();
		King king = new King(5,4,"black");
		assertEquals(5, king.getXLocation());
		assertEquals(4, king.getYLocation());
		assertEquals("black", king.getTeam());
		assertEquals("King", king.getType());
	}
	
	/**
	 * Tests updateMoveList for the King unit
	 */
	@Test
	public void testUpdateMoveList()
	{
		//Tests the king's moveList when threatened by one knight
		board.setupPlayers();
		board.setupSpaces(board.getBoard());
		board.addPiece(new King(1,4,"white"), 1, 4);
		board.addPiece(new Knight(4,3,"black"), 4, 3);
		assertEquals(7, board.getPiece(1,4).getMoveList().size());
		
		//The king should be able to kill the pawn diagonal from it
		board.addPiece(new Pawn(2,5,"black"),2, 5);
		assertEquals(7, board.getPiece(1,4).getMoveList().size());
		
		//A king in its starting position should have 0 moves
		board.setupAll();
		assertEquals(0, board.getPiece(4,7).getMoveList().size());

	}
	

}
