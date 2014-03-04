package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class BishopHorseTests {
	
	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
		board.setupAll();
	}

	/**
	 * Tests the BishopHorse's constructor by checking its initializations
	 */
	@Test
	public void bishophorseConstructorTest()
	{
		BishopHorse bishophorse = new BishopHorse(5,4,"black");
		assertEquals(5, bishophorse.getXLocation());
		assertEquals(4, bishophorse.getYLocation());
		assertEquals("black", bishophorse.getTeam());
		assertEquals("BishopHorse", bishophorse.getType());
	}
	
	/**
	 * Tests updateMoveList for the BishopHorse unit
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A bishophorse at the edge of the board with an initial setup should have 4 moves
		board.addPiece(new BishopHorse(7,3,"black"),7,3);
		assertEquals(4,board.getPiece(7, 3).getMoveList().size());
		board.removePiece(7, 3);


		//A bishophorse in the middle of the initial board has 8 moves
		BishopHorse bishophorse = new BishopHorse(4,4,"black");
		board.addPiece(bishophorse, 4, 4);
		assertEquals(8, bishophorse.getMoveList().size());
		
		//2 allies and 2 enemies in adjacent places should result in 6 valid moves
		board.addPiece(new Pawn(5,5,"black"),5,5);
		board.addPiece(new Pawn(5,3,"black"),5,3);
		board.addPiece(new Pawn(3,3,"white"),3,3);
		board.addPiece(new Pawn(3,5,"white"),3,5);
		assertEquals(6,bishophorse.getMoveList().size());
		
		//Pieces 3 spaces away should make no difference to the bishophorse
		board.removePiece(7,7);
		assertEquals(6,bishophorse.getMoveList().size());
		board.removePiece(1, 1);
		assertEquals(6,bishophorse.getMoveList().size());
		
	}
}
