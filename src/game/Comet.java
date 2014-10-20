package game;

/**
 * This class creates a single comet enemy
 * 
 * @author basilvetas
 */
public class Comet extends Enemy
{
	/**
	 * Constructor
	 */
	Comet(PathPosition p)
	{
		ImageLoader loader = ImageLoader.getLoader();
		this.enemy = loader.getImage("resources/comet.png");
		this.position = p;
		this.anchorX = -25;
		this.anchorY = -25;
		this.velocity = 8;
	}
	
}
