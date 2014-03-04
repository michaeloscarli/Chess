package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.*;

public class KnightTests {

	Board board;
	
	@Before public void setup() throws Exception
	{
		board = new Board();
		board.setupAll();
	}

	/**
	 * Tests the Knight's constructor by checking its initializations
	 */
	@Test
	public void knightConstructorTest()
	{
		Knight knight = new Knight(5,4,"black");
		assertEquals(5, knight.getXLocation());
		assertEquals(4, knight.getYLocation());
		assertEquals("black", knight.getTeam());
		assertEquals("Knight", knight.getType());
	}
	
	/**
	 * Tests the isEnemyUnit function on friendly, enemy, and null units
	 */
	@Test
	public void testIsEnemyUnit()
	{
		//Detecting an enemy unit should return true
		board.addPiece(new Knight(5,5,"black"), 5, 5);
		assertEquals(true, board.getPiece(6,7).isEnemyUnit(5,5,board));
		
		//Attempting to check a unit that doesn't exist returns false
		assertEquals(false, board.getPiece(6,7).isEnemyUnit(4,5,board));
		
		//Detecting a friendly unit should return false
		board.addPiece(new Knight(7,5,"white"), 7, 5);
		assertEquals(false, board.getPiece(6,7).isEnemyUnit(7,5,board));
	}
	
	/**
	 * Tests updateMoveList for the Knight unit
	 */
	@Test
	public void testUpdateMoveList()
	{
		//A knight in the middle of the board near the enemy side should have 8 moves
		board.addPiece(new Knight(4,3,"white"), 4,3);
		board.getPiece(4, 3).updateMoveList(4, 3, board);
		assertEquals(8, board.getPiece(4,3).getMoveList().size());
		board.removePiece(4, 3);
		
		//A knight in a initial board should only have 2 moves
		board.getPiece(1,7).updateMoveList(1, 7, board);
		assertEquals(2, board.getPiece(1,7).getMoveList().size());
		
		//A knight on the left edge of a board near the middle should have 4 moves
		board.addPiece(new Knight(0,3,"white"), 0,3);
		board.getPiece(0, 3).updateMoveList(0, 3, board);
		assertEquals(4, board.getPiece(0,3).getMoveList().size());
		board.removePiece(0, 3);
		
		//A knight with no moves should have an empty moveList
		board.addPiece(new Pawn(2,5,"white"), 2, 5);
		board.addPiece(new Pawn(0,5,"white"), 0, 5);
		board.getPiece(1, 7).updateMoveList(1, 7, board);
		assertEquals(0, board.getPiece(1,7).getMoveList().size());
	}

}
