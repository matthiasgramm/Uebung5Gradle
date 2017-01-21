import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyPanel extends JPanel
{
	Image image;
	MyPanel()
	{
		MyPanel.this.setSize(150,150);
		MyPanel.this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	MyPanel(Color background){
		this();
		this.setBackground(background);
	}
	
	MyPanel(Image image){
		this();
		this.image = image;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//System.out.println(image);
		
		if(image != null){
			int size = Math.min(getSize().width, getSize().height);
			g.drawImage(image, 0, 0, size, size, this);
		}	
	}
}