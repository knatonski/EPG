package korEPG;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Okienko extends JFrame{
	
	private static int grubosc=50;
	private static int skala=20000;
	private static Panel panel;
	private PanelNazwyKanalow panelKanaly;
	private PanelOsCzasu panelOsCzasu;
	final static Dimension rozmiarPlachty = new Dimension((int) (Program.getMaxStop()-Program.getMinStart())/skala,Kanal.kanaly.size()*(grubosc+2));
	private static JTextArea opisProgramu;
	
	private static JPanel opisProgramuPanel = new JPanel();
	
	private static IkonaPanel obrazekPanel = new IkonaPanel();
	
	public Okienko() {
		setLayout(new BorderLayout());
		
		panel=new Panel();
		//Ustalamy rozmiar panelu z programami
		System.out.println(rozmiarPlachty+" "+Kanal.kanaly.size());
		panel.setPreferredSize(rozmiarPlachty);
		panel.setOpaque(false);//optymalizacja, aby panel sie nie zacinal przy przewijaniu
		panel.setDoubleBuffered(false);//optymalizacja, aby panel sie nie zacinal przy przewijaniu
		JScrollPane jsp = new JScrollPane(panel);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		add(jsp,BorderLayout.CENTER);
		
		
		panelKanaly=new PanelNazwyKanalow();
		panelKanaly.setPreferredSize(new Dimension(100, rozmiarPlachty.height));
		jsp.setRowHeaderView(panelKanaly);
		
		panelOsCzasu=new PanelOsCzasu();
		panelOsCzasu.setPreferredSize(new Dimension(rozmiarPlachty.width, 40));
		jsp.setColumnHeaderView(panelOsCzasu);
		
		opisProgramuPanel = new JPanel();
		opisProgramuPanel.setLayout(new BorderLayout());
		
		
		opisProgramuPanel.add(obrazekPanel,BorderLayout.WEST);
		
		opisProgramu=new JTextArea();
		opisProgramu.setEditable(false);
		opisProgramu.setLineWrap(true);
		opisProgramu.setWrapStyleWord(true);
		opisProgramu.setFont(new Font("Arial", 0, 20));
		JScrollPane jsp2 = new JScrollPane(opisProgramu);
		opisProgramuPanel.add(jsp2,BorderLayout.CENTER);
		opisProgramuPanel.setPreferredSize(new Dimension(0, IkonaPanel.wysokosc));
		
		add(opisProgramuPanel,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}

	public static int getGrubosc() {
		return grubosc;
	}
	
	public static int getSkala() {
		return skala;
	}
	
	public static void setDlugosc(int d) {
		skala=d;
	}
	
	public static void setSzczegolyProgramu(String opis) {
		opisProgramu.setText(opis);
	}
	
	public static void odmaluj() {
		panel.repaint();
	}
	
	public static void getUstawIkone(final Image ikona) {
		obrazekPanel.zmienObrazek(ikona);
		opisProgramuPanel.revalidate();
	}

	public static Dimension getRozmiarplachty() {
		return rozmiarPlachty;
	}
}
