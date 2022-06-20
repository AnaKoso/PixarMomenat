package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import pop.dialogs.AddStaffDialog;
import pop.dialogs.AddToolDialog;

public class ActionNew extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public ActionNew() {
	
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(SHORT_DESCRIPTION, "New");
		putValue(SMALL_ICON, new ImageIcon("Images" + File.separator + "add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(MainFrame.getInstance().selectedTab()) {
		
		case 0:
			AddStaffDialog d = new AddStaffDialog();
			break;
		case 1:
			AddToolDialog e = new AddToolDialog();
			break;
		default:
				break;
				
		}
		
	}

}
