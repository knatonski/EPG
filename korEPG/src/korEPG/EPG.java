package korEPG;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.swing.JOptionPane;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class EPG {
	public static void main(String[] args) {
		String link = JOptionPane.showInputDialog("Czy wczytac aktualne dane z internetu?","https://raw.githubusercontent.com/MajkiIT/kodi/master/EPG/epg_v1.xml");
		try {
			if (link != null) {
				InputStream in = new URL(link).openStream();
				Files.copy(in, Paths.get("epg_v1-kopia.xml"), StandardCopyOption.REPLACE_EXISTING);
				Files.move(new File("epg_v1-kopia.xml").toPath(), new File("epg_v1.xml").toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Nie udalo sie wczytac danych, nastapi prezentacja ostatnio pobranych");
			e.printStackTrace();
		}
		
		
		Wczytaj.wczytaj("epg_v1.xml");
		//System.out.println(Kanal.kanaly);
		new Okienko();

		//Program.wczytujIkonyZInternetu();
	}
}



