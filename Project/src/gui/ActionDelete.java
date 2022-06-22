package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.SoftwareTool;
import model.Staff;
import popDialogs.DeleteStaffDialog;
import popDialogs.DeleteToolDialog;

public class ActionDelete extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public ActionDelete() {
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, "Delete");
		putValue(SMALL_ICON, new ImageIcon("Images" + File.separator + "delete.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(MainFrame.getInstance().selectedTab()) {

		
		case 0:
			Staff staff= MainFrame.getInstance().selectedStaff();
			if(staff== null) {
				JOptionPane.showMessageDialog(null, "Morate selektovati zaposlenog.");
			}else {
				DeleteStaffDialog dialog = new DeleteStaffDialog(staff);
			}
			break;
		case 1:
			SoftwareTool tool = MainFrame.getInstance().selectedTool();
			if(tool== null) {
				JOptionPane.showMessageDialog(null, "Morate selektovati alat.");
			}else {
				DeleteToolDialog dialog = new DeleteToolDialog(tool);
			}
			break;
		default:
				break;
				
		}
	}
			
}
