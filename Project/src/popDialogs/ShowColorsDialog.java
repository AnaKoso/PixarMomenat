package popDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Brush;

public class ShowColorsDialog extends JDialog implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Color> brushColors ;
	
	public ShowColorsDialog( List<Color> c) {

		setName("Boje cetkice");
		Window parent = SwingUtilities.getWindowAncestor(this);
		brushColors = addCollors(c);
		
		setLayout();
		
		
		setLocationRelativeTo(null);
		setSize(new Dimension(300,150));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setVisible(true);
	}
	
	
	private List<Color> addCollors(List<Color> c) {
		List<Color> returnValue = new ArrayList<>();
		for (Color color : c) {
			returnValue.add(color);
		}
		System.out.println("60linija: " + returnValue.size());
		return returnValue;
	}


	private void setLayout() {
		FlowLayout colorsLayout = new FlowLayout();
		setLayout(colorsLayout);
		
		for (Color color : brushColors) {
			System.out.println("duzina niza boja:"+brushColors.size());
			JPanel c = new JPanel();
			c.setBackground(color);
			c.setSize(new Dimension(100, 100));
			add(c);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
