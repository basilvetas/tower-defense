package game;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class ImageLoader 
{
	private Map<String, Image> imageBank;	//declares a map to hold images
	private static ImageLoader instance;
	/**
	 *  Constructor to initialize imageBank variable
	 *  
	 * @param null
	 */
	private ImageLoader()
	{
		imageBank = new TreeMap<String, Image>();	// creates a treeMap
	}
	
	/**
	 * 
	 * 
	 * @param null
	 * @return image loader
	 */
	static ImageLoader getLoader()
	{	
		if(instance == null)
			instance = new ImageLoader();
		return instance;	// gets the image loader object
	}
	
	/**
	 * 
	 * @param pic
	 * @return Image
	 */
	public Image getImage(String pic)
	{	
		Image loaded = null;
		
		// Prevents and image from being loaded twice
		if(imageBank.containsKey(pic))	// if image is already in the map	
			return imageBank.get(pic);	// return that image
		else
		{
			try
			{
	    		// Create a loader for accessing files stored in the resources package.
				ClassLoader myLoader = this.getClass().getClassLoader();
		        
	    		// Use the loader to read the background image.
				InputStream imageStream = myLoader.getResourceAsStream(pic);
				
				// stores image in 'loaded'
				loaded = ImageIO.read(imageStream);
					
			}
			catch (IOException e) {System.out.println ("Could not load: " + e);}
			
			imageBank.put(pic, loaded);	// Adds new key and value to the map
			
			return loaded;	// returns the specified image 
		}
	}
}
