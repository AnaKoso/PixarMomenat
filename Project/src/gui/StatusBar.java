package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

class StatusBar extends JPanel {


	private static final long serialVersionUID = 1L;
	StatusBar(){
		 JPanel statusBar = new JPanel();
		 JLabel appTime=new JLabel();
		 JLabel appName =new JLabel("  OISISI  ",JLabel.LEFT);
		 
		 
		 setLayout(new BorderLayout()); 
		 statusBar.setLayout(new BorderLayout());
		 statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
		 statusBar.setBackground(Color.lightGray);
		 statusBar.add(appName,BorderLayout.WEST);
		 statusBar.add(appTime, BorderLayout.EAST);
		 appTime.setSize(getPreferredSize());
		 add("South",statusBar);
		 
		//adding the date and time to status bar
			Timer timee=new  javax.swing.Timer(1000, new ActionListener() {
				 
		            @Override
		            public void actionPerformed(ActionEvent e) {

		                Date now = new java.util.Date();
		                DateFormat Date=new SimpleDateFormat("  dd.MM.yyyy.  ");
		                String nowS=Date.format(now);
		               	     

		                appTime.setText(nowS);
		                appTime.setToolTipText("Welcome, Today is " + nowS);
		 
		            }
		        });
		        timee.start();
			 
		
		
	}
}

