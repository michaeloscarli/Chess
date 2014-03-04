package pieces;
import board.*;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rook extends Piece{
	
	/**
	 * Constructor for Rook, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public Rook(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "Rook";
		if (teamColor.equals("white"))
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/whiteRook.png")));
		else
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/blackRook.png")));
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
		Rook rook = (Rook)board.getPiece(curX, curY);
		rook.updateHelper(curX, curY-1, board, "N");
		rook.updateHelper(curX+1, curY, board, "E");
		rook.updateHelper(curX-1, curY, board, "W");
		rook.updateHelper(curX, curY+1, board, "S");
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
			if (direction.equals("N"))
				updateHelper(curX, curY-1, board, "N");
			else if (direction.equals("E"))
				updateHelper(curX+1, curY, board, "E");
			else if (direction.equals("W"))
				updateHelper(curX-1, curY, board, "W");
			else //S
				updateHelper(curX, curY+1, board, "S");
		}
	}	
}

