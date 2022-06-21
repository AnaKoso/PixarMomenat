package popDialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.SoftwareToolController;
import gui.MainFrame;
import model.SoftwareTool;

public class DeleteToolDialog extends JDialog  implements ActionListener{

	
	private static final long serialVersionUID = 1L;

	public DeleteToolDialog(SoftwareTool t) {
		Object[] options = { "Da", "Ne" };
		
		int option = JOptionPane.showOptionDialog(null,"Da li ste sigurni da zelite da \n "
			    + "obrisete alat?", "Brisanje alata",
		    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		    null, options, options[1]);
		
		if(option == JOptionPane.YES_OPTION) {
			SoftwareToolController.getInstance().deleteTool(t);
		}
		
		
		
		
		setLocationRelativeTo(null);
		setSize(new Dimension(250,150));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
	
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

