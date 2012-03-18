package de.imagesegmentation;

import de.imagesegmentation.entity.Image;
import de.imagesegmentation.util.ImageUtil;
import de.imagesegmentation.view.ImageClient;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Image img = Image.loadImage("example/game.jpg");
		
		ImageClient c1 = new ImageClient();
		c1.show(img);
		
		Image image = ImageUtil.processGrayScaling(img);
		ImageClient c2 = new ImageClient();
		c2.show(image);
	}

}
