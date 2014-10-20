package game;

import java.awt.Graphics;
import java.awt.Image;

/**
 * This is an abstract superclass for a tower in the game
 * 
 * @author basilvetas
 *
 */
abstract public class Tower 
{
	/* instance variables */
	protected Coordinate position;	// holds position of tower
	protected Image tower; 			// holds tower image
	protected int anchorX;			// shifts X coordinate
	protected int anchorY;			// shifts Y coordinate
	protected double timeSinceLastFire;// time since last effect was fired
	
	public void draw(Graphics g)
	{
		// Draws tower object to location specified by user
		g.drawImage(tower, position.getX() + anchorX, position.getY() + anchorY, null);
		
		// Draws dot on Enemy's (x, y) coordinates
		//g.setColor(Color.WHITE);
		//g.fillOval(position.getX(), position.getY(), 5, 5);	
	}
	/**
	 * 
	 * @param c
	 */
	public void setPosition(Coordinate c)
	{
		position = c;
	}
	
	abstract void interact(Game game, double deltaTime);
}





