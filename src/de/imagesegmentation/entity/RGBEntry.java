package de.imagesegmentation.entity;

public class RGBEntry {
	private int r,g,b;
	
	public RGBEntry(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public int getR() {
		return r;
	}
	
	public int getG() {
		return g;
	}
	
	public int getB() {
		return b;
	}
	
	public int getRGB() {
		return ((255 & 0xFF) << 24) |
		  	((r & 0xFF) << 16) |
		  	((g & 0xFF) << 8)  |
		  	((b & 0xFF) << 0);
	}
	
	public RGBEntry normalize() {
		float sumRGB = r + g + b;
		RGBEntry normEntry = null;			
			
		if(sumRGB != 0) {
			float normR = (float)r/sumRGB;
			float normG = (float)g/sumRGB;
			float normB = (float)b/sumRGB;
			normEntry = new RGBEntry((int) (normR*255+0.5), 
					(int) (normG*255+0.5), (int) (normB*255+0.5));
		} else {
			normEntry = new RGBEntry(0, 0, 0);
		}
			
		return normEntry;
	}
	
	public RGBEntry grayScale() {
		int brightness = (int) (0.212671 * r + 0.715160 * g + 0.072169 * b);
		
		return new RGBEntry(brightness, brightness, brightness);
	}
	
	@Override
	public String toString() {
		return r + "," + g + "," + b;
	}
}
