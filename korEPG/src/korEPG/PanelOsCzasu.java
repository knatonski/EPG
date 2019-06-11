package korEPG;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
/**
 * Gorny panel z datami i godzinami
 */
public class PanelOsCzasu extends JPanel{
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int skala = Okienko.getSkala();//
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 100000, 1000000);
		for (int i=0;i<Okienko.rozmiarPlachty.width;i+=100) {
			g.setColor(Color.white);
			long czasWMilisekundach = (i*skala)+Program.getMinStart();
			g.drawString(""+zamienMilisekondyNaDate(czasWMilisekundach), i, 20);
			g.fillRect(i, 20, 2, 100);
		}
	}
	
	/**
	 * Zamienia milisekundy liczone od  January 1, 1970, 00:00:00 GMT {@link Date#Date(long)} na date
	 * wyrazona slownie (w sposob czytelny dla czlowieka)
	 */
	private String zamienMilisekondyNaDate(long data) {
		DateFormat df = new SimpleDateFormat("dd.MM HH:mm");
		return df.format(new Date(data));
	}
}
