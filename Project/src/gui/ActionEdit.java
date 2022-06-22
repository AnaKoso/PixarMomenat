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
import popDialogs.EditStaffDialog;
import popDialogs.EditToolDialog;

public class ActionEdit extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	@SuppressWarnings("deprecation")
	public ActionEdit() {
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(SHORT_DESCRIPTION, "Edit");
		putValue(SMALL_ICON, new ImageIcon("Images" + File.separator + "pencil (1).png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	switch(MainFrame.getInstance().selectedTab()) {
	
		case 0:
			Staff staff= MainFrame.getInstance().selectedStaff();
				if(staff == null) {
	
					JOptionPane.showMessageDialog(null, "Morate selektovati zaposlenog");;
				}else {
					
					@SuppressWarnings("unused")
					EditStaffDialog  dialog = new EditStaffDialog(staff);
				}
			break;
		case 1:
			SoftwareTool tool = MainFrame.getInstance().selectedTool();
			if(tool == null) {
				JOptionPane.showMessageDialog(null, "Morate selektovati alat");
			}
			else {
				EditToolDialog  toolDialog = new EditToolDialog(tool);
				System.out.println("OVDJE TREBA STAVITI OTVVARANJE PROZORA ZA EDIT SOFTVERAA");
			
			}
			break;
		default:
				break;
				
		}

	}
}
