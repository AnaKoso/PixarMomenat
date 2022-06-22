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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.SoftwareToolController;
import model.Brush;
import model.Render;
import model.SoftwareTool;

public class EditToolDialog  extends JDialog implements ActionListener {

	private JTable tableBrushes;
	private JTabbedPane tabbedPane;
	
	static JLabel nameL;
	static JLabel brushesL;
	static JLabel modificatorsL;
	static JLabel fileFormatL;
	static JLabel animationToolsL;
	
	static JTextField fileFormatF;
	static JTextField nameF;
	static JTextField modificatorsF;
	static JTextField animationToolsF;
	private List<Brush> brushes = new ArrayList<Brush>();
	
	static JLabel renderL;
	static JLabel renderNameL;
	static JLabel camerasL;
	static JLabel materialsL;
	static JLabel objectsL;
	static JLabel lightL;
	static JTextField renderNameF;
	static JTextField camerasF;
	static JTextField materialsF;
	static JTextField objectsF;
	static JTextField lightF;
	
	private AddBrushDialog dialogAdd;
	private EditBrushesForToolDialog dialogEdit;
	
	public EditToolDialog(SoftwareTool tool) {
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		brushes = tool.getBrushes();
		
		setTitle("Editovanje softverskog alata");
		nameL = new JLabel("Naziv alata *");
		brushesL = new JLabel("Cetkice *");
		modificatorsL = new JLabel("Modifikatori *");
		fileFormatL = new JLabel("Format fajla *");
		animationToolsL = new JLabel("Alati za animaciju *");
		
		renderL = new JLabel("RENDER");
		renderNameL = new JLabel("Naziv rendera *");
		lightL = new JLabel("Svetlo *");
		materialsL = new JLabel("Materijali *");
		objectsL = new JLabel("Objekti *");
		camerasL = new JLabel("Kamere *");
		
		nameF = new JTextField(15);
		nameF.setName("Naziv alata*");
		nameF.setText(tool.getName());
		nameF.setEditable(false);
		
		fileFormatF = new JTextField(15);
		fileFormatF.setName("Format fajla*");
		fileFormatF.setText(tool.getFileFormat());
		
		modificatorsF = new JTextField(15);
		modificatorsF.setName("Modifikatori*");
		modificatorsF.setText(tool.getModificators());
		
		animationToolsF = new JTextField(15);
		animationToolsF.setName("Alati za animaciju*");
		animationToolsF.setText(tool.getAnimationTools());
		
		
		JButton editBrushes = new JButton("Edituj cetkice");
		
		
		renderNameF = new JTextField(15);
		renderNameF.setName("Naziv rendera*");
		renderNameF.setText(tool.getRender().getName());
		
		camerasF = new JTextField(15);
		camerasF.setName("Kamere *");
		camerasF.setText(tool.getRender().getCameras());
		
		materialsF = new JTextField(15);
		materialsF.setName("Materijali*");
		materialsF.setText(tool.getRender().getMaterials());
		
		objectsF = new JTextField(15);
		objectsF.setName("Objekti*");
		objectsF.setText(tool.getRender().getObjects());
		
		lightF = new JTextField(15);
		lightF.setName("Svetlo*");
		lightF.setText(tool.getRender().getLight());
		
		JButton okButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Odustani");
		

		editBrushes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openEditBrushesDialogAction();
				
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SoftwareTool tool;
				try {
					tool = collectData();
					
					if(tool == null) {
						
						okButton.setToolTipText("Morate uneti sva polja!");
						JOptionPane.showMessageDialog(parent,"Polja nisu popunjena!");
						okButton.setBackground(Color.RED);
						okButton.setForeground(Color.WHITE);
						
					}else {
							SoftwareToolController.getInstance().editTool(tool);
							dispose();
						
					}
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
		
		
		setLayout(okButton,cancelButton,editBrushes);
		
		setLocationRelativeTo(null);
		setSize(new Dimension(500,600));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setVisible(true);
		
	}
	
	
	private void setLayout(JButton okButton, JButton cancelButton, JButton editBrushes) {
		
		FlowLayout buttonsLayout = new FlowLayout();
		final JPanel brushButtons = new JPanel();
		brushButtons.setLayout(buttonsLayout);
		brushButtons.add(editBrushes);
		brushButtons.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
	
		FlowLayout buttonsLayout1 = new FlowLayout();
		final JPanel buttons = new JPanel();
		buttons.setLayout(buttonsLayout1);
		buttons.add(okButton);
		buttons.add(cancelButton);
		buttons.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(nameL,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor=GridBagConstraints.LINE_START;

		add(nameF,gc);
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.anchor=GridBagConstraints.LINE_START;
		add(brushesL,gc);
		

		gc.gridy = 1;
		gc.gridx = 1;
		gc.gridwidth = 2;
		gc.anchor=GridBagConstraints.LINE_START;
		add(brushButtons,gc);
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 2;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);

		gc.anchor=GridBagConstraints.LINE_START;
		add(fileFormatL,gc);
		

		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;

		add(fileFormatF,gc);
	
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 3;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(animationToolsL,gc);
				
		gc.gridy = 3;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(animationToolsF,gc);
		
		
		gc.gridy = 4;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(modificatorsL,gc);
				
		gc.gridy = 4;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(modificatorsF,gc);
		
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 5;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.anchor=GridBagConstraints.LINE_START;
		add(renderL,gc);
		

		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 6;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);

		gc.anchor=GridBagConstraints.LINE_START;
		add(renderNameL,gc);
		

		gc.gridy = 6;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;

		add(renderNameF,gc);
	
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 7;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(materialsL,gc);
				
		gc.gridy = 7;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(materialsF,gc);
		
		
		gc.gridy = 8;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(camerasL,gc);
				
		gc.gridy = 8;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(camerasF,gc);
		
		gc.gridy = 9;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(objectsL,gc);
				
		gc.gridy = 9;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(objectsF,gc);
		
		gc.gridy = 10;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(lightL,gc);
				
		gc.gridy = 10;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(lightF,gc);
		

		gc.gridy = 11;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(buttons,gc);

		

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	private SoftwareTool collectData() throws ParseException {
			
			SoftwareTool tool;
			tool = null;
			try {
				String name = nameF.getText();
				String animatioTools = animationToolsF.getText();
				String modificators = modificatorsF.getText();
				String fileFormat = fileFormatF.getText();
				
				String renderName = renderNameF.getText();
				String materials = materialsF.getText();
				String cameras = camerasF.getText();
				String objects = objectsF.getText();
				String light = lightF.getText();
				
				
				if(name.equals("") || animatioTools.equals("") || modificators.equals("") || 
						fileFormat.equals("") || renderName.equals("") || materials.equals("")
						|| cameras.equals("") || objects.equals("") || light.equals("") ||brushes.size() == 0) {
					System.out.println("Error input");
					return null;	
				}
				Render render = new Render();
				render.setName(renderName);
				render.setMaterials(materials);
				render.setCameras(cameras);
				render.setObjects(objects);
				render.setLight(light);
				
				tool = new SoftwareTool();
				tool.setName(name);
				tool.setAnimationTools(animatioTools);
				tool.setModificators(modificators);
				tool.setFileFormat(fileFormat);
				tool.setRender(render);
				tool.setBrushes(brushes);
					
			}catch (Exception e) {
				e.printStackTrace();
			}
			return tool;
		}
	
	 private  void openDialogAction() {
	      if (dialogAdd == null) {
	         Window win = SwingUtilities.getWindowAncestor(this);
	         if (win != null) {
	        	dialogAdd = new AddBrushDialog();
	         }
	      }
	      dialogAdd.setVisible(true);
	      if(dialogAdd.getBrush() != null) {
	    	  Brush newBrush = generateBrush();
	    	  brushes.add(newBrush);
	 	      for (Brush brush : brushes) {
	 	    	  System.out.println(brush.getName());
	 		  }
	      }
	      
	     
	 }
	 
	 private Brush generateBrush() {
		Brush b = new Brush();
		b.setName(dialogAdd.getBrush().getName());
		b.setUsage(dialogAdd.getBrush().getUsage());
		b.setColors(new ArrayList<Color>());
		for (Color c : dialogAdd.getBrush().getColors()) {
			b.getColors().add(c);
			System.out.println("add tool dialog 466:" + b.getColors().size() + " : " +b.getColors());
		}
		return b;
	}


	private void openEditBrushesDialogAction() {
		 if (dialogEdit == null) {
	         Window win = SwingUtilities.getWindowAncestor(this);
	         if (win != null) {
	        	dialogEdit = new EditBrushesForToolDialog(brushes);
	         }
	      }
	      	dialogEdit.setVisible(true);;
	      	brushes = dialogEdit.getBrushes();
	     for (Brush brush : brushes) {
	    	 System.out.println(brush.getName());
	     }
	 }
	 
	 public List<Brush> getBrushes() {
		return brushes;
		 
	 }
}
