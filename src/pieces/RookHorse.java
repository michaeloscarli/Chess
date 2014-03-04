package pieces;
import java.awt.Point;

import board.*;
/**
 * A rook except it moves exclusively in steps of 2, skipping the square in between
 * It can also move to its adjacent spaces
 * @author Oscar
 *
 */
public class RookHorse extends Piece{
	
	/**
	 * Constructor for RookHorse, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public RookHorse(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "RookHorse";
	}
	
	/**
	 * Updates the list of valid moves for a piece in a certain space
	 * @param curX, the x-coordinate of the piece
	 * @param curY, the y-coordinate of the piece
	 * @param board, the board being played on
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{
		moveList.clear();
		RookHorse rookhorse = (RookHorse)board.getPiece(curX, curY);
		updateListNeighbors(curX, curY-1, board);
		updateListNeighbors(curX+1, curY, board);
		updateListNeighbors(curX-1, curY, board);
		updateListNeighbors(curX, curY+1, board);
		rookhorse.updateHelper(curX, curY-2, board, "N");
		rookhorse.updateHelper(curX+2, curY, board, "E");
		rookhorse.updateHelper(curX-2, curY, board, "W");
		rookhorse.updateHelper(curX, curY+2, board, "S");
	}
	
	/**
	 * Helper function to allow a recursive DFS to find available moves
	 * @param curX the current x-coordinate we are inspecting
	 * @param curY the current y-coordinate we are inspecting
	 * @param board the board we are playing on
	 * @param direction the direction (N, E, W, S) we are DFS-ing in
	 */

	public void updateHelper(int curX, int curY, Board board, String direction)
	{
		//If we're out of bounds, return
		if(curX < 0 || curY < 0 || curX >= Board.BOARD_LENGTH || curY >= Board.BOARD_LENGTH)
			return;
		//If we find a piece, keep going
		else if (board.isOccupied(curX, curY))
		{
			//If it's an enemy piece, add to moveList
			if (isEnemyUnit(curX, curY, board))
			{
				moveList.add(new Point(curX, curY));
				return;
			}
			return;
		}
		else
		{
			moveList.add(new Point(curX, curY));
			if (direction.equals("N"))
				updateHelper(curX, curY-2, board, "N");
			else if (direction.equals("E"))
				updateHelper(curX+2, curY, board, "E");
			else if (direction.equals("W"))
				updateHelper(curX-2, curY, board, "W");
			else //S
				updateHelper(curX, curY+2, board, "S");
		}
	}
	
	/**
	 * Helper function, adds the neighboring spaces (if valid) to the moveList
	 * @param curX the current x-coordinate we are inspecting
	 * @param curY the current y-coordinate we are inspecting
	 * @param board the board we are playing on
	 */
	public void updateListNeighbors(int curX, int curY, Board board)
	{
		//If we're out of bounds, return
		if(curX < 0 || curY < 0 || curX >= Board.BOARD_LENGTH || curY >= Board.BOARD_LENGTH)
			return;
		if(!board.isOccupied(curX, curY) || !board.getPiece(curX,curY).getTeam().equals(team))
			moveList.add(new Point(curX, curY));

	}


}
