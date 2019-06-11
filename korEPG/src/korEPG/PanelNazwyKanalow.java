package korEPG;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Boczny panel z nazwami kanalow
 */
public class PanelNazwyKanalow extends JPanel{
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 100000, 1000000);
		g.setColor(Color.WHITE);
		int grubosc = Okienko.getGrubosc();
		int h=0;
		for (Kanal k: Kanal.kanaly.values()) {
		
			g.drawString(k.getID(), 0, h+grubosc);
			g.setColor(Color.WHITE);
			g.fillRect(0, h-1, 100000000, 2);
			h+=grubosc+2;
		}
	}
}
