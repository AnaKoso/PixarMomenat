package listeners;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.MainFrame;

public class OptionPaneExample extends JFrame{  
	
	
	public JFrame x=null;
	public OptionPaneExample() {
	x=  new JFrame();
	Object[] options = { "Da", "Ne" };
	
	int opcija = JOptionPane.showOptionDialog(null,"Da li ste sigurni da zelite da \n "
		    + "ponistite zposlenog?", "Brisanje zaposlenog.",
	    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	    null, options, options[1]);
	
	if(opcija == JOptionPane.YES_OPTION) {
		System.out.println("Brisanje zaposlenog");
	}
	

	x.setLocationRelativeTo(null);
	x.setSize(new Dimension(250,150));
	x.setResizable(false);
	
	
	x.setLocationRelativeTo(MainFrame.getInstance());
	x.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	
	}
	}