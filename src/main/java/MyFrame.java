import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyFrame extends JFrame
{
	MyFrame()
	{
		setSize(200,200);
		setBackground(Color.gray);
		String imagePath = "/Users/mats/Desktop/Musterbilder/";
		String[] elements = new File(imagePath).list();
		Image[] images = new Image[new File(imagePath).list().length];
		Toolkit defaultTK=Toolkit.getDefaultToolkit();	
		System.out.println(new File(imagePath).list());
		
		for(int i = 0; i<elements.length; i++) {
			images[i] = defaultTK.getImage(imagePath+elements[i]);
		}
		
		System.out.println(images.length);
		
		setVisible(true);
		
	//	final JPanel panel = new JPanel();
		
		ImagePanel panel1 = new ImagePanel(images[0]); //button Listener i+1
		MyPanel panel2 = new MyPanel(Color.BLUE);
		MyPanel panel3 = new MyPanel(Color.BLACK);
		MyPanel panel4 = new MyPanel(Color.GREEN);
		MyPanel panel5 = new MyPanel(Color.YELLOW);
		
		add(panel1, BorderLayout.CENTER);
		
		add(panel2, BorderLayout.SOUTH);
		add(panel3, BorderLayout.NORTH);
		add(panel4, BorderLayout.EAST);
		add(panel5, BorderLayout.WEST);
	
		panel2.add(new JButton("weiter"));
		panel2.add(new JButton("zurueck"));		
		panel2.add(new JButton("groesser"));		
		panel2.add(new JButton("kleiner"));
		panel2.add(new JButton("reset"));
		
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		

	//	for(int i=0; i<feld.size; )

		validate();
		repaint();
	}
}






