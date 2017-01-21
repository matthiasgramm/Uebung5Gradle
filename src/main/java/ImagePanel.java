import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel
{	
	Image image;
		
	ImagePanel(Image image)
	{
		this.image = image;
	}
	
	public void paint(Graphics g)
	{
//		g.drawImage(image, 0, 0, Color.CYAN, this);
		g.drawImage(image, 0, 0, this);
		validate();
		//System.out.println("biste da");
	}
	

}
