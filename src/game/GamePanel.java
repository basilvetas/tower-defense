package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * The GamePanel class represents the drawable area on the screen.
 * This class is kept simple, and can be used as-is.
 * 
 * @author basilvetas
 */
public class GamePanel extends JPanel implements MouseListener, MouseMotionListener
{
    /* Static variables */
   
    /* This static variable is just to avoid an Eclipse warning.  It serves no other purpose (for us). */
    
    private static final long serialVersionUID = -266426690684141363L;
    
     
    /* Object fields and methods */
   
    private Game enclosingGame;  	// A reference back to the Game object that created 'this' object.
    public int mouseX;				// Tracks X position of mouse events
    public int mouseY;				// Tracks Y position of mouse events
    public boolean mouseIsPressed;	// Determines if mouse has been clicked or not
    
    /**
     * Creates the GamePanel object (which is really just
     * a JPanel object with a little extra functionality.)
     * The GamePanel represents a drawable area on the screen.
     * It has a paint method, and we can listen for events on this
     * object if we want.
     * 
     * @param enclosingGame the Game object that is creating this panel
     */
    public GamePanel (Game enclosingGame)
    {
        // Keep track of the Game object that created this panel.
        //   That way, we can call methods in the game object when needed.
    	
    	this.addMouseListener(this); 			// Listen to our own mouse events.
    	this.addMouseMotionListener(this);		// Listen to mouse movements
        this.enclosingGame = enclosingGame;
    }
    
    /**
     * Redraws the panel.  The panel does not have access to any of the objects
     * in the game.  (The panel does not have a path object, or a snail object, etc.)
     * This means the panel cannot directly draw them.  Instead, we'll just have
     * our panel call back to the Game object, and let the Game object draw
     * everything.
     * 
     * @param g  the Graphics object that corresponds to the panel
     */
    public void paintComponent (Graphics g)
    {
        enclosingGame.draw (g);
    }
    
    /**
     * returns X & Y coordinates of mouse
     * 
     * @return
     */
    public Coordinate getCoordinate()
    {
    	return new Coordinate(mouseX, mouseY);
    }
    
    /* Overridden methods that report the correct panel size when needed. */
    
    public Dimension getMinimumSize ()
    {
        return new Dimension(800,600);
    }
    public Dimension getMaximumSize ()
    {
        return new Dimension(800,600);
    }
    public Dimension getPreferredSize ()
    {
        return new Dimension(800,600);
    }

    /* MouseListener methods */
    
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = true;
		
	}

	/* MouseMotionListener methods */
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{	
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = false;

	}
}
