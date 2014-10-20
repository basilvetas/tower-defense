package game;

/**
 * This class creates a single alien enemy
 * 
 * @author basilvetas
 */
public class Alien extends Enemy 
{
	/**
	 * Constructor
	 */
	Alien(PathPosition p)
	{
		ImageLoader loader = ImageLoader.getLoader();
		this.enemy = loader.getImage("resources/Alien-Ship.png");
		this.position = p;
		this.anchorX = -20;
		this.anchorY = -20;
		this.velocity = 6;
	}

}
