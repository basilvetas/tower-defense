package game;

import java.util.List;

/**
 * This class creates a single blackhole tower
 * 
 * @author basilvetas
 */
public class BlackHole extends Tower
{
	/**
	 * Constructor
	 */
	public BlackHole(Coordinate pos)
	{
		ImageLoader loader = ImageLoader.getLoader();
		this.tower = loader.getImage("resources/blackhole.png");
		this.position = pos;
		this.anchorX = -40;
		this.anchorY = -40;
	}
	
	/**
	 * 
	 */
	public void interact(Game game, double deltaTime)
	{	// tracks time that effect has existed
		timeSinceLastFire += deltaTime;
		
		// if time less than 1.5 seconds, don't interact
		if(timeSinceLastFire < 1)
			return;
		
		List<Enemy> enemies = game.enemies; // new list of enemies
		
		// Gives position of an enemy in enemy list
		for(Enemy e: enemies)
		{	
			
			// holds position of enemy
			Coordinate enemyPos = e.getPosition().getCoordinate();

			// Compute distance of enemy to tower
			double dx, dy, dist;	// change in x, y, and total distance
			
			// calculates change in x and y position 
			dx = enemyPos.x - position.x; // x position of enemy - tower
			dy = enemyPos.y - position.y; // y position of enemy - tower
		
			// use Pythagorean theorem to calculate distance
			dist = Math.sqrt((dx*dx) + (dy*dy));
			
			// holds position of effect
			Coordinate pos = new Coordinate(position.x, position.y);	
			
			// if enemy is in range, fire salt
			if(dist < 80)
			{	StarDust stardust = new StarDust(pos, enemyPos);
				game.effects.add(stardust);
				timeSinceLastFire = 0;
				return;
			}	
		} 
	}	
}
