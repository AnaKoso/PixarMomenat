package popDialogs;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Brush;

public class AddBrushDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	static JLabel nameL;
	static JLabel usageL;
	static JLabel colorsL;
	static JLabel selectedColors;
	
	static JTextField nameF;
	static JTextField usageF;
	static JColorChooser colorF;
	static JPanel colorPanel;
	private Brush brush;
	private List<Color> colors = new ArrayList<Color>();
	private AddColourDialog dialog;
	
	static int  colorNum;

	public AddBrushDialog() {
		colorNum = 0;
		Window parent = SwingUtilities.getWindowAncestor(this);
		setTitle("Dodavanje cetkice");
		nameL = new JLabel("Naziv cetkice *");
		usageL = new JLabel("Namena cetkice *");
		colorsL = new JLabel("Boje: *");
		selectedColors = new JLabel("");
		
		nameF = new JTextField(15);
		nameF.setName("Naziv cetkice *");
		
		usageF = new JTextField(15);
		usageF.setName("Namena cetkice*");
		
	
		colorF = new JColorChooser(Color.black);
		colorF.setName("Boja cetkice*");
		
		JButton okButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Odustani");
		JButton addColor = new JButton("Dodaj boju");
		
		
		addColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				colors.add(colorF.getColor());
				System.out.println("AKCIJA DODAVANJA BOJE ZAPOCELA");
				updateColorList();
				changeColors();
				colorNum = colorNum + 1;
			}

			private void updateColorList() {
				
				System.out.println("AKCIJA DODAVANJA BOJE SE NASTAVLJA");
				String help = "";
				for (Color color : colors) {
					help = help  + color.getRGB() + ", ";
				}
				selectedColors.setText(help);
				System.out.println(help);
			}
			
			private void changeColors() {
				if(colorNum<30) {
					var a = colorPanel.getComponent(colorNum);
					a.setBackground(colors.get(colorNum));
				}

			}
		});
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Brush brush;
				try {
					brush = collectData();
					
					if(brush == null) {
						JOptionPane.showMessageDialog(parent, "morate popuniti sva polja!");
						okButton.setToolTipText("Morate uneti sva polja!");
						okButton.setBackground(Color.RED);
						okButton.setForeground(Color.WHITE);
						
					}
				
					dispose();
				}catch(ParseException pe) {
					pe.printStackTrace();
				}				
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		setLayout(okButton,cancelButton, addColor);
		
		setLocationRelativeTo(null);
		setSize(new Dimension(650,700));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setVisible(true);
		
	}
	
	
	
	
	private void setLayout(JButton okButton, JButton cancelButton, JButton addColor) {
	
		FlowLayout colorsLayout = new FlowLayout();
		colorPanel = new JPanel();
		colorPanel.setLayout(colorsLayout);
		colorPanel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		for (int i = 0; i < 30; i++) {
			JPanel c = new JPanel();
			colorPanel.add(c);
		}
		
		setLayout(new GridBagLayout());
		final JPanel name = new JPanel();
		FlowLayout nameLayout = new FlowLayout();
		name.setLayout(nameLayout);

		name.add(nameL);
		name.add(nameF);
		name.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		
		FlowLayout usageLayout = new FlowLayout();
		final JPanel usage = new JPanel();
		usage.setLayout(usageLayout);
		usage.add(usageL);
		usage.add(usageF);
		usage.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		FlowLayout buttonsLayout = new FlowLayout();
		final JPanel buttons = new JPanel();
		buttons.setLayout(buttonsLayout);
		buttons.add(okButton);
		buttons.add(cancelButton);
		buttons.add(addColor);
		buttons.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.gridwidth = 3;
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(name,gc);
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.gridwidth = 3;
		gc.anchor=GridBagConstraints.LINE_START;
		add(usage,gc);
		

		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 2;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);

		gc.anchor=GridBagConstraints.LINE_START;
		add(colorsL,gc);
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 3;
		gc.gridx = 0;
		gc.insets = new Insets(0, 20, 0, 0);

		gc.anchor=GridBagConstraints.LINE_START;
		add(colorPanel,gc);
		

		gc.gridy = 4;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.gridwidth = 1;
		gc.anchor=GridBagConstraints.LINE_START;

		add(colorF,gc);


		gc.gridy = 5;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(buttons,gc);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	private Brush collectData() throws ParseException {
			
			
			brush = null;
			try {
			String name = nameF.getText();
			String usage = usageF.getText();
			Color color = colorF.getColor();
			if(name.equals("") || usage.equals("") || colors == null) {
				System.out.println("Error input");
				return null;	
			}
		
			List<Color> colorsList = new ArrayList<Color>();
			colorsList = colors;
			brush = new Brush(name, colorsList, usage);
					
			}catch (Exception e) {
				e.printStackTrace();
			}
			return brush;
		}
	
	public Brush getBrush() {
		return brush;
	}
	
	private  void openTableAction() {
	      if (dialog == null) {
	         Window win = SwingUtilities.getWindowAncestor(this);
	         if (win != null) {
	        	dialog = new AddColourDialog();
	         }
	      }
	      dialog.setVisible(true);;
	      colors.add(dialog.getColor());
	     for (Color color : colors) {
	    	 System.out.println(color.toString());
		}
	     
	   }

}
