package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class BishopTests {

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
	public void bishopConstructorTest()
	{
		Bishop bishop = new Bishop(5,4,"black");
		assertEquals(5, bishop.getXLocation());
		assertEquals(4, bishop.getYLocation());
		assertEquals("black", bishop.getTeam());
		assertEquals("Bishop", bishop.getType());
	}
	
	/**
	 * Tests updateMoveList for the Bishop unit
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A bishop in its initial position should have no moves
		board.getPiece(2, 7).updateMoveList(2, 7, board);
		assertEquals(0, board.getPiece(2,7).getMoveList().size());
		
		//A bishop with an enemy in each of it's 4 directions should have 4 moves
		board.addPiece(new Bishop(3,3, "black"), 3, 3);
		board.addPiece(new Pawn(2,2,"white"), 2, 2);
		board.addPiece(new Pawn(4,2,"white"), 4, 2);
		board.addPiece(new Pawn(4,4,"white"), 4, 4);
		board.addPiece(new Pawn(2,4,"white"), 2, 4);
		board.getPiece(3, 3).updateMoveList(3, 3, board);
		assertEquals(4, board.getPiece(3,3).getMoveList().size());
		
		board.removePiece(2, 2);
		board.removePiece(4, 2);
		board.removePiece(4, 4);
		board.removePiece(2, 4);
		

		//A bishop surrounded by a space of 2 and with original board pieces in place has 6 moves
		board.addPiece(new Pawn(1, 1,"white"), 1, 1);
		board.addPiece(new Pawn(5, 1,"white"), 5, 1);
		board.addPiece(new Pawn(1, 5,"white"), 1, 5);
		board.addPiece(new Pawn(5, 5,"white"), 5, 5);
		board.getPiece(3, 3).updateMoveList(3, 3, board);
		assertEquals(6, board.getPiece(3,3).getMoveList().size());
		
		//Removing the 5,5 pawn should give it one more move, 7
		board.removePiece(5, 5);
		board.getPiece(3, 3).updateMoveList(3, 3, board);
		assertEquals(7, board.getPiece(3, 3).getMoveList().size());
		board.removePiece(1, 1);
		board.removePiece(5, 1);
		board.removePiece(1, 5);
		
		//At the edge of the board with surrounding units 1 space away, should have 2 moves
		board.removePiece(3,3);
		board.addPiece(new Bishop(7,3,"black"), 7, 3);
		board.addPiece(new Pawn(6,2, "white"), 6, 2);
		board.addPiece(new Pawn(6,4, "white"), 6, 4);
		board.getPiece(7, 3).updateMoveList(7, 3, board);
		assertEquals(2, board.getPiece(7, 3).getMoveList().size());
		
		
	}

}
