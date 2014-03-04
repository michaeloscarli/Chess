package board;

import pieces.*;

public class Space {
	boolean occupied;	
	Piece piece;
	
	/**
	 * Constructor for a single space
	 * @param state, true if the space is occupied, false otherwise
	 * @param item, the piece inside the space, null if there is none
	 */
	public Space(boolean state, Piece item)
	{
		occupied = state;
		piece = item;
	}
	
	/**
	 * Default space constructor, simulates an empty space
	 */
	public Space()
	{
		occupied = false;
		piece = null;
	}
		
	Piece getPiece()
	{
		return piece;
	}
	
	public boolean isOccupied()
	{
		return occupied;
	}
	
	/**
	 * Sets whether a space is occupied or not
	 * @param status, true if the space is occupied, false otherwise
	 */
	public void changeOccupation(boolean status)
	{
		occupied = status;
	}
	
	/**
	 * Sets the piece inside the space
	 * @param item, the item inside the space
	 */
	public void setPiece(Piece item)
	{
		piece = item;
	}
	
	
}
