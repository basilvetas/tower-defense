package game;
/**
* A simple class for representing x, y coordinates.  Note
* that the fields are not private.  This allows you to
* directly access the x, y values without calling a method.
* This is common for very, very simple classes.
* 
* @author vetas
* @date 3/27/13
*/
public class Coordinate
{
    // Every object will have an x, y integer.
	
	public int x, y;
	
	/**
    * Constructor - initializes this object with the provided coordinates.
    * Since the fields are final, they won't be able to be changed
    * after they are first assigned (below)
    * 
    * @param x
    * @param y
    */
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Get X coordinate
	 * 
	 * @return X coordinate
	 */
	public int getX()
	{
		return this.x; 
	}
	
	/**
	 * Get Y coordinate
	 * 
	 * @return Y coordinate
	 */
	public int getY()
	{
		return this.y; 
	}
	
	public String toString()
	{
		return ("" + x + " " + y);
	}

}