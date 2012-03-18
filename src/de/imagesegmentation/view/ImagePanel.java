package de.imagesegmentation.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import de.imagesegmentation.entity.Image;

public class ImagePanel extends JComponent {

	private static final long serialVersionUID = -1698374606968040177L;
	
	private Image img = null;

	public ImagePanel(String imagePath) {
		img = Image.loadImage(imagePath);
	}
	
	public ImagePanel(Image img) {
		this.img = img;
	}
	
	@Override
	public Dimension getPreferredSize() {
		if(img == null) {
			return new Dimension(100,100);
		} else {
			return new Dimension(img.getWidth(), img.getHeight());
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img.getImage(), 0, 0, null);
	}

}
