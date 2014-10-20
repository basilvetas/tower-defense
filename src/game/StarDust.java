package game;

/**
 * Game effect when the Black hole attacks 
 * 
 * @author basilvetas
 */
public class StarDust extends Effect 
{
	public StarDust(Coordinate pos, Coordinate target)
	{
		// Loads star dust image
		ImageLoader loader = ImageLoader.getLoader();
		this.picture = loader.getImage("resources/star_dust.png");
		
		// X and Y position of Effect
		this.posX = pos.x;
		this.posY = pos.y;		
		
		// X and Y position of target enemy
		this.velocityX = target.x - this.posX;
		this.velocityY = target.y - this.posY;
		
		// Sets time to 0
		this.ageInSeconds = 0;
	}	
}
