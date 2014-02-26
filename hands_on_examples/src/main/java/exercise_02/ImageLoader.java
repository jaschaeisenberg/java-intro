package exercise_02;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A helper class which loads an image into a image object.
 */
public class ImageLoader {

	/**
	 * Loads the icon and returns an images which is paintable by the drawImage method.
	 * 
	 * @return loaded icon, or null if there were problems loading it.
	 */
	public Image loadIcon(String fileName) {
		try {
			/*
			 * Icon by http://www.artua.com/, retrieved here:
			 * http://www.iconarchive.com/show/star-wars-icons-by-artua.html
			 */
			return ImageIO.read(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}