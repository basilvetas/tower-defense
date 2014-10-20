package game;

import java.util.List;

/**
 * A PathPosition object represents a single position along a segmented path.
 * The position can be advanced along the path, and can be converted into an (x, y) coordinate.
 * 
 * Has three components that make up the position: the path that the object is on, the segment
 * that the object is in, and the percentage across that segment.
 * 
 * @author basilvetas
 * @date 3/27/13
 */
public class PathPosition
{	
	// Instance variables
	private int segment;			// The segment this position is on
	private double percentage;		// Distance along the current segment
	private List <Coordinate> path;	// List of path coordinates for current path
	
	/**
	 * Constructor:  Sets up this path position to be at the start
	 * 
	 * @param path
	 */
	PathPosition(List<Coordinate> points)
	{	// Initializes variables
		
		this.segment = 0;		//starting segment
		this.percentage = 0;	//starting percentage across segment
		this.path = points;		// stores list of coordinate points in path
	}
	
	/**
     * Returns true if this path position is at
     * the end of the path.
     * 
     * @return true if this position cannot be advanced any further
     */
    public boolean isAtTheEnd ()
    {   
    	return segment == path.size()-1;	// ask how this works
    }
    
    /**
     * Returns a coordinate object containing the (x, y) location
     * of the current path position.  The path position is
     * converted to its (x, y) representation, a coordinate object
     * is built containing the (x, y) location, and the coordinate
     * is returned.
     * 
     * @return A Coordinate object containing the (x, y) location of this position
     */
    public Coordinate getCoordinate ()
    {	
    	if(isAtTheEnd())
    		return path.get(path.size()-1);
    	
    	// variables for starting and ending position of the X coordinate
    	int startX = path.get(segment).x;
    	int endX = path.get(segment + 1).x;
    	
    	// variables for starting and ending position of the Y coordinate
    	int startY = path.get(segment).y;
    	int endY = path.get(segment + 1).y;
    	
    	// calculates the change in the X and Y position by taking the difference
    	int dX = endX - startX;
    	int dY = endY - startY;
 	
    	// sets the new position of the ball by adding change to start
    	int ballX = startX + (int) (dX*percentage);
    	int ballY = startY + (int) (dY*percentage);
    	
        return new Coordinate(ballX, ballY);    // returns new position
    }
    
    /**
     * This method advances this path position by the specified number
     * of Cartesian units.  (Pythagorean's theorem is used internally
     * help with the computation.)  If the specified distance would
     * cause the position to pass the end of the path, the current
     * position is stopped at the end of the path.
     *  
     * @param distance  the distance to travel along the path
     */
    public void advance (double distance)
    {	
    	// checks if the object is at the end of the path
        if(isAtTheEnd())
        	return;		// path does not advance
    	
    	// variables for starting and ending position of the X coordinate
    	int startX = path.get(segment).x;
    	int endX = path.get(segment + 1).x;
    	
    	// variables for starting and ending position of the Y coordinate
    	int startY = path.get(segment).y;
    	int endY = path.get(segment + 1).y;
    	
    	// calculates the change in the X and Y position by taking the difference
    	int dX = endX - startX;
    	int dY = endY - startY;
    	
    	// uses the Pythagorean theorem to calculate the new position
    	double length = Math.sqrt((double) (dX*dX) + (double) (dY*dY));
    	double unit = 1/length;	// variable for the unit change in position as a percent of length
    	
    	percentage += unit*distance;	// adds change to previous percentage
    	
    	// find the ratio of distance and length
    	//double percentageAdvanced = distance / length; 
    	
    	// checks how far along segment the object is
    	if(percentage > 1)
    	{
    		segment ++;										// increment segment
    		distance = distance-(1-percentage)*length;	// decrease distance by length
    		percentage = 0;									// set percent to 0
    		advance(distance);								// advance remaining distance
    	}
    }
}