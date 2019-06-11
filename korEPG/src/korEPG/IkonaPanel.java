package korEPG;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Panel w lewym dolnym rogu (kolo opisu programu) z obrazkiem
 */
public class IkonaPanel extends JPanel{
	
	final static int wysokosc = 150;
	
	Image ikona;
	
	int x;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		g.drawImage(ikona,0,0,x,wysokosc,null);
	}
	
	public void zmienObrazek(Image obrazek) {
		ikona=obrazek;
		x = przeliczX(ikona,wysokosc);
		setPreferredSize(new Dimension(x, wysokosc));
		repaint();
	}
	
	public static int przeliczX(Image ikona,int y) {
		if (ikona==null) {
			return 1;
		}else {
			return ikona.getWidth(null)*y/ikona.getHeight(null);
		}
		
	}
}
