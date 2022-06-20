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
import javax.swing.JTextArea;

class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	
	public AboutDialog() {
		setSize(750,550);
        setLocationRelativeTo(null);
        setTitle("About");

        ImageIcon aboutIcon=new ImageIcon("Images"+File.separator+"about.png");

        setIconImage(aboutIcon.getImage());
        
        
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
       
        JTextArea aboutDialog=new JTextArea(20,20);
        aboutDialog.setEditable(false);
        aboutDialog.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        aboutDialog.setText("\n"+"About us:                                "+"\r"+"\n"
        +"	Verzija applikacije : 1.0 "+"\n"	
        
      		
        		);
        getContentPane().add(aboutDialog);
		
        
	}
}

