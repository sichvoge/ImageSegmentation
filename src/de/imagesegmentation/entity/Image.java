package de.imagesegmentation.entity;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	
	BufferedImage img = null;
	
	RGBEntry[][] colorEntries;

	public Image() {}
	
	public static Image createImage(RGBEntry[][] colorEntries) {
		Image rImage = new Image();
		
		rImage.img = new BufferedImage(colorEntries.length, colorEntries[0].length, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < colorEntries.length; i++) {
			for(int j = 0; j < colorEntries[0].length; j++) {
				rImage.img.setRGB(i, j, colorEntries[i][j].getRGB());
			}
		}
		
		return rImage;
	}
	
	public boolean save(String path) {
	    File outputfile = new File(path);
	    try {
			ImageIO.write(img, "jpg", outputfile);
		} catch (IOException e) {
			System.err.println("Saving image interrupted. Message: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static Image loadImage(String imagefilename) {
		Image rImage = new Image();
		
		if(imagefilename == null) {
			System.err.println("Argument is null!");
			return null;
		}
		
		File f = new File(imagefilename);
		
		if(!f.exists()) {
			System.err.println("File do not exists!");
			return null;
		}
		
		try {
			rImage.img = ImageIO.read(f);
		} catch (IOException e) {
			System.err.println("Error during loading image. Message: " + e.getMessage());
			return null;
		}
		
		rImage.createRGBEntries();
		
		return rImage;
	}
	
	private void createRGBEntries() {
		colorEntries = new RGBEntry[img.getWidth()][img.getHeight()];
		
		for(int row=0;row<img.getWidth(); row++) {
			for(int col=0;col<img.getHeight();col++) {
				Color rgb = new Color(img.getRGB(row, col));
				
				colorEntries[row][col] = new RGBEntry(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
			}
		}
	}
	
	public int getHeight() {
		return img.getHeight();
	}
	
	public RGBEntry[][] getColorEntries() {
		return colorEntries;
	}
	
	public int getWidth() {
		return img.getWidth();
	}
	
	public BufferedImage getImage() {
		return img;
	}
}
