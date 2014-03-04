package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import game.*;
 
 
public class Gui{
	
	protected Game game;
	protected JFrame window;
	protected ModifiedJPanel squares[][];
	protected JMenuItem newButton;
	protected JMenuItem forfeitGame;
	protected JMenuItem undo;
	protected JMenuItem tie;
    private JLabel lastLabel;
    private ModifiedJPanel lastPanel;
    private ModifiedJPanel currentPanel;
 
	/**
	 * Constructor for the Gui class
	 * Makes a JFrame with 64 JPanels and sets the appropriate images to each panel
	 * Sets the window size to 720x720 and disallows resizing
	 * @param board, the board we are playing on
	 */
    public Gui(Controller controller){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            //silently ignore
        }
        JFrame window = new JFrame("Basic Application Example");
    	squares = new ModifiedJPanel[8][8];
        window.setSize(720, 720);
        window.setLayout(new GridLayout(8, 8));
        window.setResizable(false);
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y] = new ModifiedJPanel(x,y);
                squares[x][y].addMouseListener(controller);

                if ((x + y) % 2 == 0) {
                    squares[x][y].setBackground(new Color(178,161,127));
                    placeInitialImages(squares[x][y],x,y);
                } else {
                    squares[x][y].setBackground(new Color(184,116,48));
                    placeInitialImages(squares[x][y],x,y);
                }   
                window.add(squares[x][y]);
            }
        }
        setUpMenu(window);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Returns a specific jpanel at the coordinates specified
     * @param x the x-coordinate of the panel
     * @param y the y-coordinate of the panel
     * @return the ModifiedJPanel at the coordinates specified
     */
    public ModifiedJPanel getPanel(int x, int y)
    {
    	return squares[x][y];
    }
    
    /**
     * Undoes the last move on the GUI
     */
    public void undo()
    {
    	currentPanel.removeAll();
    	currentPanel.validate();
		currentPanel.repaint();
		lastPanel.add(lastLabel);
		lastPanel.validate();
		lastPanel.repaint();
    }
    
    /**
     * Places a given image at a specified location
     * @param label the image to be placed
     * @param x the x-coordinate of the destination
     * @param y the y-coordinate of the destination
     */
    public void placeImage(JLabel label, int x, int y, ModifiedJPanel sourcePanel)
    {
    	lastLabel = label;
    	lastPanel = sourcePanel;
    	currentPanel = squares[x][y];
    	
    	
    	squares[x][y].removeAll();
    	squares[x][y].validate();
		squares[x][y].repaint();
    	if (squares == null)
    		return;
    	else
    	{
    		squares[x][y].add(label);
    		squares[x][y].validate();
    		squares[x][y].repaint();
    	}
    }
    
    
    /**
     * Depending on the location of the JPanel, places the appropriate image
     * @param board, the board we are playing on
     * @param square, the JPanel we may be placing an image on
     * @param x, the JPanel's x-coordinate
     * @param y, the JPanel's y-coordinate
     */
    public void placeInitialImages(ModifiedJPanel square,int x, int y)
    {
    	JLabel picLabel = null;
    	if (x == 1)
    		picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/blackPawn.png")));
    	else if (x == 0)
    	{
    		if (y == 0 || y == 7)
        		picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/blackRook.png")));
    		else if (y == 1 || y == 6)
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/blackKnight.png")));
    		else if (y == 2 || y == 5)
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/blackBishop.png")));
    		else if (y == 4)
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/blackKing.png")));
    		else
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/blackQueen.png")));
    	}
    	
    	else if (x == 6)
    		picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/whitePawn.png")));
    	else if (x == 7)
    	{
    		if (y == 0 || y == 7)
        		picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/whiteRook.png")));
    		else if (y == 1 || y == 6)
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/whiteKnight.png")));
    		else if (y == 2 || y == 5)
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/whiteBishop.png")));
    		else if (y == 4)
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/whiteKing.png")));
    		else
    			picLabel = new JLabel(new ImageIcon(getClass().getResource("/images/whiteQueen.png")));
    	}
    	if (picLabel != null)
    		square.add(picLabel);
    }
    
    /**
     * Resets the GUI board with it's correct 
     */
    public void resetBoard()
    {
    	for (int x = 0; x < 8; x++)
    	{
    		for (int y = 0; y < 8; y++)
    		{
    			squares[x][y].removeAll();
    			placeInitialImages(squares[x][y],x,y);
    			squares[x][y].validate();
    			squares[x][y].repaint();
    		}
    	}
    }
    
 
    /**
     * Sets up the menu bar
     * @param window, the frame we are putting the menu bar in
     */
    private void setUpMenu(JFrame window) {
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        newButton = new JMenuItem("New");
        forfeitGame = new JMenuItem("Forfeit");
        tie = new JMenuItem("Tie");
        undo = new JMenuItem("Undo");
        file.add(newButton);
        file.add(forfeitGame);
        file.add(undo);
        file.add(tie);
        menubar.add(file);
        window.setJMenuBar(menubar);
    }
    
    /**
     * The following functions add actionListeners to the menu buttons
     * @param a
     */
    public void addNewGameListener(ActionListener a)
    {
    	newButton.addActionListener(a);
    }
    
    public void addForfeitGameListener(ActionListener a)
    {
    	forfeitGame.addActionListener(a);
    }
    
    public void addUndoListener(ActionListener a)
    {
    	undo.addActionListener(a);
    }
    
    public void addTieListener(ActionListener a)
    {
    	tie.addActionListener(a);
    }
    /**
     * End actionListener adder functions
     */
}
