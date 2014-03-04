package player;
import java.util.ArrayList;

import pieces.*;

public class Player {
	protected String team;
	protected ArrayList<Piece> pieceList;
	
	/**
	 * Default constructor for the player class
	 */
	public Player()
	{
		team = null;
		pieceList = new ArrayList<Piece>();
	}
	
	/**
	 * Constructor for the player class that assigns the player a team
	 * @param color
	 */
	public Player(String color)
	{
		team = color;
		pieceList = new ArrayList<Piece>();
	}
	
	/**
	 * @return returns the team (black or white) the player is on
	 */
	public String getTeam()
	{
		return team;
	}
	
	/**
	 * Returns the pieceList for this player
	 * @return
	 */
	public ArrayList<Piece> getPieceList()
	{
		return pieceList;
	}
	
	/**
	 * Returns the current size of the pieceList for this player
	 * @return
	 */
	public int getSizeOfPieceList()
	{
		return pieceList.size();
	}
	
	/**
	 * Adds a piece to the corresponding pieceList
	 * @param piece, the piece to be added
	 */
	public void addToList(Piece piece)
	{
		pieceList.add(piece);
	}
	
	/**
	 * Removes a specific piece from the pieceList
	 * @param piece, the piece to be removed
	 */
	public void removeFromList(Piece piece)
	{
		for(int index = 0; index < pieceList.size(); index++)
		{
			Piece unit = pieceList.get(index);
			if (unit.getLocation().equals(piece.getLocation()))
				pieceList.remove(index);
			}
	}
	
	/**
	 * Returns the king piece of the player
	 * @return the king piece from the player's pieceList
	 */
	public King getKing()
	{
		King king = null;
		for(int index = 0; index < pieceList.size(); index++)
		{
			if (pieceList.get(index).getType()=="King")
				king = (King)pieceList.get(index);
		}
		return king;
	}
}
