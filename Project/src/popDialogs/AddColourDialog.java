package popDialogs;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;


public class AddColourDialog extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	static JColorChooser colorF;
	private Color color; 
	
	public AddColourDialog() {
		setTitle("Odabir boje");

	}

	private void setLayout(JButton okButton, JButton cancelButton) {
		setLayout(new GridBagLayout());
		
		FlowLayout buttonsLayout = new FlowLayout();
		final JPanel buttons = new JPanel();
		buttons.setLayout(buttonsLayout);
		buttons.add(okButton);
		buttons.add(cancelButton);
		buttons.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(colorF,gc);
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.gridwidth = 3;
		gc.anchor=GridBagConstraints.LINE_START;
		add(buttons,gc);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	public Color getColor() {
		return color;
	}
}
