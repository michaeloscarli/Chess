package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import board.Board;
import pieces.Piece;

public class PieceTests {

	static Piece boringPiece;
	static Piece piece;
	static Board board;
	
	/**
	 * Sets up a board, a default "boring" piece, and a piece placed in the middle of the board
	 * @throws Exception
	 */
	@Before public void setup() throws Exception
	{
		board = new Board();
		boringPiece= new Piece();
		piece = new Piece(5,4,"black");
	}
	
	/**
	 * Tests the Piece class's get location by asserting it returns the correct Point with x and y location
	 */
	@Test
	public void testGetLocation()
	{
		Point point = piece.getLocation();
		assertEquals(5, (int)point.getX());
		assertEquals(4, (int)point.getY());
		point = boringPiece.getLocation();
		assertEquals(null, point);
	}
	
	/**
	 * Tests a piece's specific getX and getY functions
	 */
	@Test
	public void GetXYLocation()
	{
		assertEquals(5, piece.getXLocation());
		assertEquals(4, piece.getYLocation());
		assertEquals(-1, boringPiece.getXLocation());
		assertEquals(-1, boringPiece.getYLocation());
	}
	
	/**
	 * Tests a Piece's getTeam, getType, and getMoveList function  to ensure they are initializing correctly
	 */
	@Test
	public void testTeamTypeAndMoveList()
	{
		assertEquals("black", piece.getTeam());
		assertEquals(null, piece.getType());
		assertEquals(true, piece.getMoveList() instanceof ArrayList);
		piece.movePiece(6, 6);
		assertEquals("black", piece.getTeam());
		assertEquals(null, piece.getType());
		assertEquals(true, piece.getMoveList() instanceof ArrayList);
		
		assertEquals(null, boringPiece.getTeam());
		assertEquals(null, boringPiece.getType());
		assertEquals(null, boringPiece.getMoveList());
		
	}
	
	/**
	 * Tests moving a piece, checks that attempting to move a null piece does not break anything
	 */
	@Test
	public void testMovePiece()
	{
		piece.movePiece(6, 5);
		assertEquals(6, piece.getXLocation());
		assertEquals(5, piece.getYLocation());
		piece.movePiece(6, 6);
		assertEquals(6, piece.getXLocation());
		assertEquals(6, piece.getYLocation());
		boringPiece.movePiece(4,4);		
	}
}
