package de.imagesegmentation.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import de.imagesegmentation.entity.Image;

public class ImageClient {
	
	public ImageClient() {}
	
	public void show(String filename) {
		this.show(new ImagePanel(filename));
	}
	
	public void show(Image img) {
		this.show(new ImagePanel(img));
	}
	
	public void show(ImagePanel panel) {
		JFrame f = new JFrame("Image Sample");
        
		f.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                   System.exit(0);
               }
		});

		f.add(panel);
		f.pack();
		f.setVisible(true);
	}
}
