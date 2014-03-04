package pieces;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import board.*;

public class Bishop extends Piece {
		
	/**
	 * Constructor for Bishop, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public Bishop(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "Bishop";
		if (teamColor.equals("white"))
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/whiteBishop.png")));
		else
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/blackBishop.png")));
	}
	
	/**
	 * Updates the list of valid moves for a bishop
	 * @param curX, the current x-coordinate of the bishop
	 * @param curY, the current y-coordinate of the bishop
	 * @param board, the board we are playing on
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{
		//Clears the moveList
		moveList.clear();
		Bishop bishop = (Bishop)board.getPiece(curX, curY);
		bishop.updateHelper(curX-1, curY-1, board, "NW");
		bishop.updateHelper(curX+1, curY-1, board, "NE");
		bishop.updateHelper(curX-1, curY+1, board, "SW");
		bishop.updateHelper(curX+1, curY+1, board, "SE");
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
				updateHelper(curX-1, curY-1, board, "NW");
			else if (direction.equals("NE"))
				updateHelper(curX+1, curY-1, board, "NE");
			else if (direction.equals("SW"))
				updateHelper(curX-1, curY+1, board, "SW");
			else //SE
				updateHelper(curX+1, curY+1, board, "SE");
		}
	}		
}
