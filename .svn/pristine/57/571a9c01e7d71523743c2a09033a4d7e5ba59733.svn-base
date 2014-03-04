package pieces;
import board.*;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pawn extends Piece {
	
	/**
	 * Constructor for Pawn, extends the Piece constructor
	 * @param xLocation, the initial x-coordinate
	 * @param yLocation, the initial y-coordinate
	 * @param teamColor, the team (black or white)
	 */
	public Pawn(int xLocation, int yLocation, String teamColor)
	{
		super(xLocation, yLocation, teamColor);
		type = "Pawn";
		if (teamColor.equals("white"))
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/whitePawn.png")));
		else
			icon = new JLabel(new ImageIcon(getClass().getResource("/images/blackPawn.png")));
	}
	
	/**
	 * Updates the list of valid moves for a piece in a certain space
	 * @param curX, the x-coordinate of the piece
	 * @param curY, the y-coordinate of the piece
	 * @param board, the board being played on
	 */
	public void updateMoveList(int curX, int curY, Board board)
	{	
		
		//if there is no piece there, return
		if (board.getPiece(curX, curY) == null)
			return;
		
		//Clears the moveList
		moveList.clear();
		
		if(team.equals("black"))
			updateBlackMoves(curX, curY, board);
		
		else //team is white
			updateWhiteMoves(curX, curY, board);
	}
	
	/**
	 * Helper function that is called to update when the piece is black
	 * @param curX, the x-coordinate of the piece
	 * @param curY, the y-coordinate of the piece
	 * @param board, the board being played on
	 */
	
	void updateBlackMoves(int curX, int curY, Board board)
	{
		//Checks for a pawn's initial 2-space move
		if (curY == 1 && !board.isOccupied(curX, curY+2) && !board.isOccupied(curX, curY+1))
			moveList.add(new Point(curX, curY+2));
		
		if (curY != Board.BOARD_LENGTH-1)
		{
			//Checks for legal movement 1 space forward
			if (!board.isOccupied(curX, curY+1))
				moveList.add(new Point(curX, curY+1));
			
			//Checks for legal diagonal movement left
			if (curX != 0)
			{
				//Checks if neighbors are valid enemies
				if (board.isOccupied(curX-1, curY+1) && board.getPiece(curX-1,curY+1).getTeam()!="black")
					moveList.add(new Point(curX-1, curY+1));	
			}	
			
			//Checks for legal diagonal movement right
			if (curX != 7)
			{
				//Checks if neighbors are valid enemies
				if (board.isOccupied(curX+1, curY+1) && board.getPiece(curX+1, curY+1).getTeam()!="black")
					moveList.add(new Point(curX+1, curY+1));
			}
		}
	}
	
	/**
	 * Helper function that is called to update when the piece is white
	 * @param curX, the x-coordinate of the piece
	 * @param curY, the y-coordinate of the piece
	 * @param board, the board being played on
	 */

	void updateWhiteMoves(int curX, int curY, Board board)
	{
		if (curY == 6 && !board.isOccupied(curX, curY-2) && !board.isOccupied(curX, curY-1))
			moveList.add(new Point(curX, curY-2));
		
		if (curY != 0)
		{
			if (!board.isOccupied(curX, curY-1))
				moveList.add(new Point(curX, curY-1));
			//Checks for legal diagonal movement left
			if (curX != 0)
			{
				//Checks if neighbors are valid enemies
				if (board.isOccupied(curX-1, curY-1) && board.getPiece(curX-1,curY-1).getTeam()!="white")
					moveList.add(new Point(curX-1, curY-1));
			}	
			
			//Checks for legal diagonal movement right
			if (curX != 7)
			{
				//Checks if neighbors are valid enemies
				if (board.isOccupied(curX+1, curY-1) && board.getPiece(curX+1, curY-1).getTeam()!="white")
					moveList.add(new Point(curX+1, curY-1));
			}
		}
	}
}