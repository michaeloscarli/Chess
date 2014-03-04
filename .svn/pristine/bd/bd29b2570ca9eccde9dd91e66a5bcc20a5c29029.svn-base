package pieces;
import java.awt.Point;

import board.*;
/**
 * A bishop except it moves exclusively in steps of 2, skipping the square in between
 * It can also move to it's diagonally adjacent spaces
 * @author Oscar
 *
 */
public class BishopHorse extends Piece{
	
	/**
	 * Constructor for Bishop, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public BishopHorse(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "BishopHorse";
	}
	
	/**
	 * Updates the list of valid moves for a bishophorse
	 * @param curX, the current x-coordinate of the bishop
	 * @param curY, the current y-coordinate of the bishop
	 * @param board, the board we are playing on
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{
		//Clears the moveList
		moveList.clear();
		BishopHorse bishophorse = (BishopHorse)board.getPiece(curX, curY);
		updateListNeighbors(curX-1, curY-1, board);
		updateListNeighbors(curX+1, curY-1, board);
		updateListNeighbors(curX-1, curY+1, board);
		updateListNeighbors(curX+1, curY+1, board);
		bishophorse.updateHelper(curX-2, curY-2, board, "NW");
		bishophorse.updateHelper(curX+2, curY-2, board, "NE");
		bishophorse.updateHelper(curX-2, curY+2, board, "SW");
		bishophorse.updateHelper(curX+2, curY+2, board, "SE");
	}
	
	/**
	 * Helper function to allow a recursive DFS to find available moves
	 * @param curX the current x-coordinate we are inspecting
	 * @param curY the current y-coordinate we are inspecting
	 * @param board the board we are playing on
	 * @param direction the direction (NW, NE, SW, SE) we are DFS-ing in
	 */
	public void updateHelper(int curX, int curY, Board board, String direction)
	{
		//If we're out of bounds, return
		if(curX < 0 || curY < 0 || curX >= Board.BOARD_LENGTH || curY >= Board.BOARD_LENGTH)
			return;
		//If we find a piece, we're done
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
			if (direction.equals("NW"))
				updateHelper(curX-2, curY-2, board, "NW");
			else if (direction.equals("NE"))
				updateHelper(curX+2, curY-2, board, "NE");
			else if (direction.equals("SW"))
				updateHelper(curX-2, curY+2, board, "SW");
			else //SE
				updateHelper(curX+2, curY+2, board, "SE");
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
		if(curX < 0 || curY < 0 || curX >= Board.BOARD_LENGTH || curY >= Board.BOARD_LENGTH)
			return;
		if(!board.isOccupied(curX, curY) || !board.getPiece(curX,curY).getTeam().equals(team))
			moveList.add(new Point(curX, curY));
	}
}