package de.imagesegmentation.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import de.imagesegmentation.entity.Image;

public class ImageClient {
	
	public ImageClient() {}
	
	public void show(String filename) {
		
		JFrame f = new JFrame("Load Image Sample");
        
		f.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                   System.exit(0);
               }
		});

		f.add(new ImagePanel(filename));
		f.pack();
		f.setVisible(true);
	}
	
	public void show(Image img) {
		JFrame f = new JFrame("Load Image Sample");
        
		f.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                   System.exit(0);
               }
		});

		f.add(new ImagePanel(img));
		f.pack();
		f.setVisible(true);
	}
}
