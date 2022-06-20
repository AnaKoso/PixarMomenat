package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class HelpDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HelpDialog() {
		setSize(750,550);
        setLocationRelativeTo(null);
        setTitle("Help");
        ImageIcon helpIcon=new ImageIcon("Images"+File.separator+"help.png");
        setIconImage(helpIcon.getImage());
		
        
        JPanel panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closebutton=new JButton("Close");
        
        
        panel.add(closebutton);
        getContentPane().add(panel,BorderLayout.SOUTH);
        
        closebutton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                
            }
        });
        
        JTextArea helpDialog=new JTextArea(20,20);
        helpDialog.setEditable(false);
        helpDialog.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        helpDialog.setText("Aplikacija implementira:\r\n"
        		+ "-----------------------------------------------------------------------------------------------------------------------------------------------\r\n"
        		+ "- Traku sa menijima (engl. Menu Bar) aplikacije\r\n"
        		+ "- Traku sa alatkama (engl. Toolbar) aplikacije\r\n"
        		+ "- Centralni panel koji sadrži tabove: Studenti, Profesori i Predmeti\r\n"
        		+ "- Statusnu traku (engl. Status Bar) aplikacije\r\n"
        		+ "\r\n"
        		+ "U nastavku su objasnjene njihove funkcionalnosti.\r\n"
        		+ "        		\r\n"
        		+ "MenuBar :\r\n"
        		+ "-File\r\n"
        		+ "	New - Dodavanje novog entiteta u sistem.\r\n"
        		+ "	Close - Zatvaranje aplikacije.\r\n"
        		+ "-Edit\r\n"
        		+ "	Edit - Izmena postojećeg entiteta.\r\n"
        		+ "	Delete - Brisanje postojećeg entiteta.\r\n"
        		+ "-Help\r\n"
        		+ "	Help - Ova sekcija sadrži detaljan opis o načinu korišćenja aplikacije.\r\n"
        		+ "	About - Prikaz verzije aplikacije, kao i kratak opis iste. Nakon toga treba da sledi sažeta biografija svakog autora.\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "ToolBar :\r\n"
        		+ "- Prvo dugme  - otvaranje dijaloga za kreiranje entiteta informacionog sistema (student, profesor, predmet). \r\n"
        		+ "- Drugo dugme - otvaranje dijaloga za izmenu označenog entiteta.\r\n"
        		+ "- Treće dugme - briše označeni enitet iz sistema. \r\n"
        		+ "\r\n"
        		+ "Tekstualno polje za pretragu - Možete uneti kriterijum pretrage i pritiskom na dugme za pretragu pretražiti tabelu aktivnog taba.\r\n"
        		+ "			 (U tabeli će biti prikazani entiteti koji zadovoljavaju kriterijum pretrage.)\r\n"
        		+ "\r\n"
        		+ "Status bar :\r\n"
        		+ "- Trenutni datum \r\n"
        		+ "- Trenutno vreme \r\n"
        		+ "- Naziv aplikacije\r\n"
        		+ "----------------------------------------------------------------------------------------------------------------------------------------------\r\n"
        		+ "Precice:       		\r\n"
        		+ "---------------------------------------------------------------------------------------------------------------------------------------------\r\n"
        		+ "- Dodavanje entiteta(student/predmet/profesor)		ALT+N/CTRL+N\r\n"
        		+ "- Izmena entiteta   (student/predmet/profesor)		ALT+E/CTRL+E\r\n"
        		+ "- Brisanje entiteta (student/predmet/profesor)		CTRL+O/CTRL+D\r\n"
        		+ "- Pomoc u vezi sa koriscenjem programa        		CTRL+H\r\n"
        		+ "- Ispisuje informacije u vezi sa programom    		CTRL+A\r\n"
        		+ "- Izlazak iz programa                     		 CTRL+C\r\n"
        		+ "Mnemonici\r\n"
        		+ "- File				ALT+F  \r\n"
        		+ "- Edit				ALT+E  \r\n"
        		+ "- Help				ALT+H  \r\n"
        		+ "- Dodavanje entiteta(student/predmet/profesor)		ALT+F+N\r\n"
        		+ "- Izmena entiteta   (student/predmet/profesor)		ALT+E+T\r\n"
        		+ "- Brisanje entiteta (student/predmet/profesor)		ALT+E+D\r\n"
        		+ "- Pomoc u vezi sa koriscenjem programa        		ALT+H+P\r\n"
        		+ "- Ispisuje informacije u vezi sa programom    		ALT+H+A\r\n"
        		+ "- Izlazak iz programa                     		ALT+F+C ");
       
        JScrollPane scrollPane = new JScrollPane(helpDialog);
        
        getContentPane().add(scrollPane,BorderLayout.CENTER);
      
		
      
		
	}

}

