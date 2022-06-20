package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;
	public MenuBar() {
		
		
		//File JMenu--------------
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		Icon crossIcon=new ImageIcon("Images"+ File.separator +"cancel.png");
		Icon addIcon=new ImageIcon("Images"+ File.separator +"addd.png");
		Icon staffIcon=new ImageIcon("Images"+ File.separator +"team.png");
		Icon toolsIcon=new ImageIcon("Images"+ File.separator +"design-software.png");
		Icon openIcon=new ImageIcon("Images"+ File.separator +"share.png");
		
		
		JMenu newSubmenu = new JMenu("New");
		newSubmenu.setIcon(addIcon);
		
		JMenuItem miNewStaff = new JMenuItem("Zaposleni",staffIcon);
		miNewStaff.setToolTipText("Dodavanje novog zaposlenog");
		
		miNewStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(0);
				ActionNew action = new ActionNew();
            	action.actionPerformed(e);
			}
		});
		
		JMenuItem miNewTools = new JMenuItem("Softverski alat",toolsIcon);
		miNewTools.setToolTipText("Dodavanje spoftverskog alata");
	
		miNewTools.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(1);
				ActionNew action = new ActionNew();
            	action.actionPerformed(e);
			}
		});
		newSubmenu.add(miNewStaff);
		newSubmenu.add(miNewTools);
		
		
		////////////////////
		
		
		
		JMenuItem miClose = new JMenuItem("Close",crossIcon);
		miClose.setToolTipText("Zatvaranje aplikacije");
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		miClose.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		
		
		JMenu open = new JMenu("Open");
		open.setIcon(openIcon);
		
		JMenuItem miStaff = new JMenuItem("Zaposleni",staffIcon);
		miStaff.setToolTipText("Prikaz zaposlenih");
	
		miStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO:IZMENITI INDEKS
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(0);
				
			}
		});
		
		JMenuItem miTools = new JMenuItem("Softverski alat",toolsIcon);
		miTools.setToolTipText("Prikaz alata");

		miTools.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO:IZMENITI INDEKS
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(1);
				
			}
		});
		
		
		open.add(miStaff);
		open.add(miTools);
		
		file.add(newSubmenu);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(miClose);
	
		
		
		//Edit JMenu------------------------------------------

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);

		Icon garbageIcon=new ImageIcon("Images"+ File.separator +"garbage.png");
		Icon pencilIcon=new ImageIcon("Images"+ File.separator +"pencil.png");
		
		JMenuItem miEdit = new JMenuItem("Edit",pencilIcon);
		miEdit.setToolTipText("Izmjena postojeceg entiteta.");
		miEdit.setMnemonic(KeyEvent.VK_T);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	ActionEdit action= new ActionEdit();
            	action.actionPerformed(arg0);
            }
        });
		
		JMenuItem miDelete = new JMenuItem("Delete",garbageIcon);
		miDelete.setToolTipText("Brisanje postojeceg entiteta.");
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		// Help JMenu----------------------------------------------------
		
		JMenu help = new JMenu("Help");
	
		help.setMnemonic(KeyEvent.VK_H);

		Icon helpIcon=new ImageIcon("Images"+ File.separator +"help.png");
		Icon aboutIcon=new ImageIcon("Images"+ File.separator +"about.png");
		
	
		
		JMenuItem miHelp = new JMenuItem("Help",helpIcon);
		miHelp.setToolTipText("Otvara Help Dialog");
		miHelp.setMnemonic(KeyEvent.VK_P);
		JMenuItem miAbout = new JMenuItem("About",aboutIcon);
		miAbout.setToolTipText("Otvara About Dialog");
		miAbout.setMnemonic(KeyEvent.VK_A);
		

		 miHelp.setAccelerator(KeyStroke.getKeyStroke(
				    KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		 miHelp.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                HelpDialog h=new HelpDialog();
	                h.setVisible(true);

	            }
	        });

		 
		 miAbout.setAccelerator(KeyStroke.getKeyStroke(
				    KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		 
		 miAbout.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                AboutDialog a=new AboutDialog();
	                a.setVisible(true);

	            }
	        });
		 
		
		
		 help.add(miHelp);
		 help.addSeparator();
		 help.add(miAbout);
		 
		add(file);
		add(edit);
		add(help);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
