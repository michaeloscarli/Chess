package pieces;
import java.util.ArrayList;
import java.awt.Point;

import javax.swing.JLabel;

import board.Board;

public class Piece {
	protected Point location;
	protected String team;
	protected String type;
	protected ArrayList<Point> moveList; //list of valid moves
	protected JLabel icon;
	
	/**
	 * Piece Constructor 
	 * @param: x, y coordinates and team ("black" or "white")
	 */
	public Piece(int xLocation, int yLocation, String teamColor)
	{
		location = new Point(xLocation, yLocation);
		team = teamColor;
		moveList = new ArrayList<Point>();
		type = null;
		icon = null;
	}
	
	/**
	 * Default constructor that initializes all variables to null
	 */
	public Piece()
	{
		location = null;
		team = null;
		type = null;
		moveList = null;
	}
	
	/**
	 * @return the current position of the piece as a Point object
	 */
	public Point getLocation()
	{
		return location;
	}
	
	/**
	 * @return the x-coordinate of the piece
	 */
	
	public int getXLocation()
	{
		if (location == null)
			return -1;
		return (int)location.getX();
	}

	/**
	 * @return the y-coordinate of the piece
	 */
	
	public int getYLocation()
	{
		if (location == null)
			return -1;
		return (int)location.getY();
	}
	
	/**
	 * @return the team ("black" or "white") of the piece
	 */
	public String getTeam()
	{
		return team;
	}
	
	/**
	 * @return the type of the piece (ex: "Rook")
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * @return an ArrayList of valid moves for a piece
	 */
	
	public ArrayList<Point> getMoveList()
	{
		return moveList;
	}
	
	/**
	 * Moves a piece to a specified location, does not update Spaces
	 * Should NEVER be called except for by Board's "move" method
	 * @param newX, the new x-coordinate of the piece
	 * @param newY, the new y-coordinate of the piece
	 */
	public void movePiece(int newX, int newY)
	{
		if (location == null)
			return;
		location.setLocation(newX, newY);
	}
	
	/**
	 * Determines if the unit at a target space is an enemy
	 * @param targetX, the x-coordinate of the space we are moving to
	 * @param targetY, the y-coordinate of the space we are moving to
	 * @param board, the board we are playing on
	 * @return true if the unit is an enemy, false otherwise
	 */
	public boolean isEnemyUnit(int targetX, int targetY, Board board)
	{
		if (board.getPiece(targetX,targetY)==null)
			return false;
		return !board.getPiece(targetX, targetY).getTeam().equals(getTeam());
	}
	
	/**
	 * Gets the icon of the piece
	 * @return the .png file corresponding to the piece
	 */
	public JLabel getIcon()
	{
		return icon;
	}
	
	/**
	 * Returns true if a specified point is in the piece's moveList
	 * @param point, the point the piece is attempting to be moved to
	 * @return true if the move exists in the piece's moveList, false otherwise
	 */
	public boolean isInMoveList(Point point)
	{
		for(int index = 0; index < moveList.size(); index++)
		{
			if (point.equals(moveList.get(index)))
				return true;
		}
		return false;
	}
	
	///////////// Methods that will be overriden /////////////
	
	/**
	 * Updates the available valid moves for a piece
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{
		return;
	}
	
	
}
