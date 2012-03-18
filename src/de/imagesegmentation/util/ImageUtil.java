package de.imagesegmentation.util;

import de.imagesegmentation.entity.Image;
import de.imagesegmentation.entity.RGBEntry;

public class ImageUtil {
	
	public static Image processImageNormalization(Image imageToNormalize) {
		RGBEntry[][] color = imageToNormalize.getColorEntries();
		
		RGBEntry[][] norm = new RGBEntry[color.length][color[0].length];
		
		for(int i=0;i<color.length;i++) {
			for(int j=0;j<color[i].length;j++) {
				norm[i][j] = color[i][j].normalize();
			}
		}
		
		return Image.createImage(norm);
	}
	
	public static Image processGrayScaling(Image image) {
		RGBEntry[][] color = image.getColorEntries();
		
		RGBEntry[][] norm = new RGBEntry[color.length][color[0].length];
		
		for(int i=0;i<color.length;i++) {
			for(int j=0;j<color[i].length;j++) {
				norm[i][j] = color[i][j].grayScale();
			}
		}
		
		return Image.createImage(norm);
	}

}
