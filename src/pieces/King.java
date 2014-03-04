package pieces;
import board.*;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class King extends Piece {
	
	/**
	 * Constructor for King, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public King(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "King";
		if (teamColor.equals("white"))
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/whiteKing.png")));
		else
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/blackKing.png")));
	}

	/**
	 * Updates the list of valid moves for a king
	 * @param curX, the current x-coordinate of the king
	 * @param curY, the current y-coordinate of the king
	 * @param board, the board we are playing on
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{
		//Clears the moveList
		moveList.clear();
		updateWrapper(curX, curY, -1, -1, board);
		updateWrapper(curX, curY, 0, -1, board);
		updateWrapper(curX, curY, 1, -1, board);
		updateWrapper(curX, curY, -1, 0, board);
		updateWrapper(curX, curY, 1, 0, board);
		updateWrapper(curX, curY, -1, 1, board);
		updateWrapper(curX, curY, 0, 1, board);
		updateWrapper(curX, curY, 1, 1, board);
	}
	
	/**
	 * Helper function that simply makes updateMoveList code shorter by using parameters to change calls
	 * @param curX starting x-coordinate
	 * @param curY starting y-coordinate
	 * @param moveX amount x-coordinate is changing by
	 * @param moveY amount y-coordinate is changing by
	 * @param board the board we are playing on
	 */
	public void updateWrapper(int curX, int curY, int moveX, int moveY, Board board)
	{
		if (isLegal(curX+moveX, curY+moveY, board))
		{
			if(team.equals("black"))
				checkSafe(curX+moveX, curY+moveY, board);
			else //team is white
				checkSafe(curX+moveX, curY+moveY, board);
		}
	}
	
	/**
	 * Helper function that returns whether an address is in bounds
	 * @param x, the target x-coordinate
	 * @param y, the target y-coordinate
	 * @return true if the coordinate is in bounds, false otherwise
	 */
	public boolean isLegal(int x, int y, Board board)
	{
		if (x < 0 || x >= Board.BOARD_LENGTH || y < 0 || y >= Board.BOARD_LENGTH)
		{
			return false;
		}
		if (board.isOccupied(x,y) && (board.getPiece(x,y).getTeam().equals(team)))
			return false;
		return true;
	}
	
	/**
	 * Checks enemy moveList if the specified space is not a move that would result in a check
	 * @param curX, the x-coordinate we are checking the safety of
	 * @param curY, the y-coordinate we are checking the safety of
	 * @param board, the board we are playing on
	 */
	public void checkSafe(int curX, int curY, Board board)
	{
		Point potentialMove = new Point(curX, curY);
		if (team == "black")
		{
			if(board.isInEntireMoveList(potentialMove, board.getWhitePlayer()))
				return;
		}
		else //The piece is from team white
		{
			if(board.isInEntireMoveList(potentialMove, board.getBlackPlayer()))
				return;
		}
		moveList.add(new Point(curX, curY));
	}
}
