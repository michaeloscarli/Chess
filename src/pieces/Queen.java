package pieces;
import board.*;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Queen extends Piece {

	/**
	 * Constructor for Queen, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public Queen(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "Queen";
		if (teamColor.equals("white"))
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/whiteQueen.png")));
		else
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/blackQueen.png")));
	}
	
	public void updateMoveList(int curX, int curY, Board board)
	{
		//Clears the moveList
		moveList.clear();
		Queen queen = (Queen)board.getPiece(curX, curY);
		queen.updateHelper(curX-1, curY-1, board, "NW");
		queen.updateHelper(curX+1, curY-1, board, "NE");
		queen.updateHelper(curX-1, curY+1, board, "SW");
		queen.updateHelper(curX+1, curY+1, board, "SE");
		queen.updateHelper(curX, curY-1, board, "N");
		queen.updateHelper(curX+1, curY, board, "E");
		queen.updateHelper(curX-1, curY, board, "W");
		queen.updateHelper(curX, curY+1, board, "S");
	}
	
	/**
	 * Helper function to allow a recursive DFS to find available moves
	 * @param curX the current x-coordinate we are inspecting
	 * @param curY the current y-coordinate we are inspecting
	 * @param board the board we are playing on
	 * @param direction the direction (NW, NE, SW, SE, N, E, W, S) we are DFS-ing in
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
				updateHelper(curX-1, curY-1, board, "NW");
			else if (direction.equals("NE"))
				updateHelper(curX+1, curY-1, board, "NE");
			else if (direction.equals("SW"))
				updateHelper(curX-1, curY+1, board, "SW");
			else if (direction.equals("SE"))
				updateHelper(curX+1, curY+1, board, "SE");
			else if (direction.equals("N"))
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
