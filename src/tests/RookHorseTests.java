package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class RookHorseTests {
	
	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
		board.setupAll();
	}

	/**
	 * Tests the RookHorse's constructor by checking its initializations
	 */
	@Test
	public void rookhorseConstructorTest()
	{
		RookHorse rookhorse = new RookHorse(5,4,"black");
		assertEquals(5, rookhorse.getXLocation());
		assertEquals(4, rookhorse.getYLocation());
		assertEquals("black", rookhorse.getTeam());
		assertEquals("RookHorse", rookhorse.getType());
	}
	
	/**
	 * Tests updateMoveList for the Rook unit
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A rookhorse on the edge of the board with an initial board should have 8 moves
		board.addPiece(new RookHorse(7,3,"black"),7,3);
		assertEquals(8,board.getPiece(7,3).getMoveList().size());

		//A rookhorse in the middle of a starting board should have 9 moves
		RookHorse rookhorse = new RookHorse(4,4,"black");
		board.addPiece(rookhorse, 4, 4);
		assertEquals(9,rookhorse.getMoveList().size());
		
		//A rookhorse surrounded by 4 allies in a starting board should have 5 moves
		board.addPiece(new Pawn(4,5,"black"),4,5);
		board.addPiece(new Pawn(4,3,"black"),4,3);
		board.addPiece(new Pawn(3,4,"black"),3,4);
		board.addPiece(new Pawn(5,4,"black"),5,4);
		assertEquals(5,rookhorse.getMoveList().size());
		
		//Adding a layer of enemies behind those allies should give the rookhorse 4 moves
		board.removePiece(4, 6);
		board.addPiece(new Pawn(4,6,"white"),4,6);
		board.addPiece(new Pawn(4,2,"white"),4,2);
		board.addPiece(new Pawn(2,4,"white"),2,4);
		board.addPiece(new Pawn(6,4,"white"),6,4);
		assertEquals(4, rookhorse.getMoveList().size());

	}
}