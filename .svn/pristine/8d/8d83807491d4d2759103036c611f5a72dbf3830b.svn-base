package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class PawnTests {

	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
		board.setupAll();
	}
	
	/**
	 * Tests the Pawn's constructor by checking its initializations
	 */
	@Test
	public void pawnConstructorTest()
	{
		Pawn pawn = new Pawn(5,4,"black");
		assertEquals(5, pawn.getXLocation());
		assertEquals(4, pawn.getYLocation());
		assertEquals("black", pawn.getTeam());		
	}
	
	/**
	 * Tests the updateMoveList function for a pawn
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A pawn can't move forward if something is in front of it
		board.addPiece(new Pawn(3,2, "black"),3,2);
		board.getPiece(3, 1).updateMoveList(3,1,board);
		assertEquals(0, board.getPiece(3,1).getMoveList().size());
		
		//A pawn from can move 2 or 1 spaces forward of nothing is in front of it
		board.removePiece(3,2);
		board.getPiece(3, 1).updateMoveList(3,1,board);
		assertEquals(2, board.getPiece(3,1).getMoveList().size());
		
		//A pawn should be able to eat an enemy unit diagonal to it
		board.addPiece(new Pawn(3,2, "white"),3,2);
		board.move(board.getPiece(3,2), 4, 2);
		board.getPiece(3, 1).updateMoveList(3,1,board);
		assertEquals(3, board.getPiece(3,1).getMoveList().size());

		//A pawn should not be able to eat a friendly unit diagonal to it
		board.addPiece(new Pawn(3,2, "black"),3,2);
		board.move(board.getPiece(3,2), 2, 2);
		board.getPiece(3, 1).updateMoveList(3,1,board);
		assertEquals(3, board.getPiece(3,1).getMoveList().size());
		
		//Testing the functionality of the a white piece to make sure it is the same as the black
		
		//A pawn should be able to eat an enemy unit diagonal to it
		board.addPiece(new Pawn(2,5, "black"), 2, 5);
		board.getPiece(1, 6).updateMoveList(1, 6, board);
		assertEquals(3, board.getPiece(1,6).getMoveList().size());
		
		//A pawn should not be able to eat a friendly unit diagonal to it
		board.addPiece(new Pawn(3,5, "black"), 3, 5);
		board.getPiece(1, 6).updateMoveList(1, 6, board);
		assertEquals(3, board.getPiece(1,6).getMoveList().size());
		
		//A pawn should not be able to jump two spaces from it's start if it's occupied
		board.addPiece(new Pawn(1,4,"white"), 1, 4);
		board.getPiece(1, 6).updateMoveList(1, 6, board);
		assertEquals(2, board.getPiece(1,6).getMoveList().size());
		
		//A pawn in the middle of the field with no surrounding units should have one move
		board.getPiece(1, 4).updateMoveList(1, 4, board);
		assertEquals(1, board.getPiece(1,4).getMoveList().size());
		
		//A pawn in the middle of the field with one enemy unit diagonal should have two moves
		board.addPiece(new Pawn(2,3,"black"),2,3);
		board.getPiece(1, 4).updateMoveList(1, 4, board);
		assertEquals(2, board.getPiece(1,4).getMoveList().size());
		
		//A pawn in the middle of the field with enemy units diagonal and in front of it should have 2 moves
		board.addPiece(new Pawn(1,3,"black"),1,3);
		board.addPiece(new Pawn(0,3,"black"),0,3);
		board.getPiece(1, 4).updateMoveList(1, 4, board);
		assertEquals(2, board.getPiece(1,4).getMoveList().size());
		
		//A white pawn at the opposite edge of the board has no moves
		board.addPiece(new Pawn(0,0,"white"), 0, 0);
		board.getPiece(0, 0).updateMoveList(0, 0, board);
		assertEquals(0, board.getPiece(0,0).getMoveList().size());

		//A black pawn at the opposite edge of the board has no moves
		board.addPiece(new Pawn(7,7,"black"), 7, 7);
		board.getPiece(7, 7).updateMoveList(7, 7, board);
		assertEquals(0, board.getPiece(7,7).getMoveList().size());
	}
	
}
