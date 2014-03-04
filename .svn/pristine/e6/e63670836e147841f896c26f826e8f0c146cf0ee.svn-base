package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class QueenTests {

	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
		board.setupAll();
	}
	
	/**
	 * Tests the Bishop's constructor by checking its initializations
	 */
	@Test
	public void queenConstructorTest()
	{
		Queen queen = new Queen(5,4,"black");
		assertEquals(5, queen.getXLocation());
		assertEquals(4, queen.getYLocation());
		assertEquals("black", queen.getTeam());
		assertEquals("Queen", queen.getType());
	}
	
	/**
	 * Tests updateMoveList for the Queen unit
	 * The Queen is completely comprised of copy/pasted Rook and Bishop code so testing is not as extensive
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A bishop in its initial position should have no moves
		board.getPiece(3, 7).updateMoveList(3, 7, board);
		assertEquals(0, board.getPiece(3,7).getMoveList().size());
	}

}
