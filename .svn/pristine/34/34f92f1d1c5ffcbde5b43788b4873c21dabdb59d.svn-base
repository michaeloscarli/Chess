package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import board.Board;

public class BoardTests {
		static Board board;
		
		/**
		 * Creates a new board before every test
		 */
		@Before public void setup() throws Exception
		{
			board = new Board();
			board.setupAll();
		}
		
		/**
		 * Tests Board's getPiece function by checking if it returns the expected piece
		 */
		@Test
		public void testGetPiece() 
		{
			String piece = "Rook";
			String color = "white";
			Piece item = board.getPiece(0,7);
			Piece nullItem = board.getPiece(5,5);
			assertEquals(piece, item.getType());	
			assertEquals(color, item.getTeam());
			assertEquals(null, nullItem);
		}
		
		/**
		 * Tests Board's removePiece function and makes sure it can detect occupancy
		 */
		@Test
		public void testRemovePieceAndIsOccupied()
		{
			board.removePiece(0, 0);
			board.removePiece(5, 5);
			assertEquals(false, board.isOccupied(0,0));
			assertEquals(false, board.isOccupied(5,5));
			assertEquals(null, board.getPiece(0, 0));
		}
		
		/**
		 * Tests Board's setupBlack function by checking initializations
		 */
		@Test
		public void testSetupBlack()
		{
			assertEquals("black", board.getPiece(0,0).getTeam());
			assertEquals("Rook", board.getPiece(0, 0).getType());
			assertEquals("black", board.getPiece(7,1).getTeam());
			assertEquals("Pawn", board.getPiece(7, 1).getType());
		}
		
		/**
		 * Tests Board's setupWhite function by checking initializations
		 */
		@Test
		public void testSetupWhite()
		{
			assertEquals("white", board.getPiece(0,6).getTeam());
			assertEquals("white", board.getPiece(7,7).getTeam());
		}
		
		/**
		 * Tests a Board's move function. Should clear the old space and if a piece is captured, it should remove
		 * that piece from its respective pieceList
		 */
		@Test
		public void testMove()
		{
			Piece piece = board.getPiece(0,6);
			assertEquals(true, board.move(piece,0,5));
			assertEquals(false, board.isOccupied(0,6));
			assertEquals(null, board.getPiece(0,6));
			assertEquals("white", piece.getTeam());
			assertEquals("Pawn", piece.getType());
			assertEquals(0, piece.getXLocation());
			assertEquals(5, piece.getYLocation());
			
			piece = new Pawn(4,4,"white");
			board.addPiece(piece, 4 ,4);
			assertEquals(17, board.getWhitePlayer().getSizeOfPieceList());
			board.move(piece, 7, 1);
			assertEquals(15, board.getBlackPlayer().getSizeOfPieceList());
		}
}
