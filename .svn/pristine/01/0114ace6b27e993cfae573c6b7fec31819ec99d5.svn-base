package pieces;
import java.awt.Point;



import javax.swing.ImageIcon;
import javax.swing.JLabel;

import board.*;

public class Knight extends Piece{

	/**
	 * Constructor for Knight, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public Knight(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "Knight";
		if (teamColor.equals("white"))
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/whiteKnight.png")));
		else
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/blackKnight.png")));
	}
	
	/**
	 * Updates the list of valid moves for a knight
	 * @param curX, the current x-coordinate of the knight
	 * @param curY, the current y-coordinate of the knight
	 * @param board, the board we are playing on
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{
		
		//if there is no piece there, return
		if (board.getPiece(curX, curY) == null)
			return;
		
		//Clears the moveList
		moveList.clear();
		
		//The specific piece we are finding a move list for and the list we are editing
		Knight knight = (Knight)board.getPiece(curX,curY);
		
		////////////////////////// BEGIN Movement checks for each of 8 movement options //////////////////////////
		if ((curX+1 < Board.BOARD_LENGTH) && curY + 2 < Board.BOARD_LENGTH)
			knightUpdateHelper(curX, curY, 1, 2, board, knight);
		
		if ((curX+1 < Board.BOARD_LENGTH) && curY-2 >= 0)
			knightUpdateHelper(curX, curY, 1, -2, board, knight);
		
		if (curX-1 >= 0 && curY + 2 < Board.BOARD_LENGTH)
			knightUpdateHelper(curX, curY, -1, 2, board, knight);
		
		if (curX-1 >= 0 && curY-2 >= 0)
			knightUpdateHelper(curX, curY, -1, -2, board, knight);
		
		if ((curX+2 < Board.BOARD_LENGTH) && curY+1 < Board.BOARD_LENGTH)
			knightUpdateHelper(curX, curY, 2, 1, board, knight);
		
		if ((curX+2 < Board.BOARD_LENGTH) && curY-1 >= 0)
			knightUpdateHelper(curX, curY, 2, -1, board, knight);
		
		if (curX-2 >= 0 && curY+1 < Board.BOARD_LENGTH)
			knightUpdateHelper(curX, curY, -2, 1, board, knight);
		
		if (curX-2 >= 0 && curY-1 >= 0)
			knightUpdateHelper(curX, curY, -2, -1, board, knight);
		////////////////////////// END Movement checks for each of 8 movement options //////////////////////////
	}
	
	/**
	 * 
	 */
	public void knightUpdateHelper(int curX, int curY, int moveX, int moveY, Board board, Knight knight)
	{
		//If there is an enemy unit in the space
		if (board.isOccupied(curX+moveX, curY+moveY) && knight.isEnemyUnit(curX+moveX, curY+moveY, board))
			moveList.add(new Point(curX+moveX, curY+moveY));

		//Or if the space is empty
		else if(!board.isOccupied(curX+moveX, curY+moveY))
			moveList.add(new Point(curX+moveX, curY+moveY));
	}
	/**
	 * Determines if the unit at a target space is an enemy
	 * @param knight, the unit we are moving
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
}
