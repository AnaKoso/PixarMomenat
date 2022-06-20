package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.SoftwareToolController;
import model.Brush;
import model.Render;
import model.SoftwareTool;
import pop.dialogs.AddBrushDialog;

public class SoftwareToolInfo extends JPanel{

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
	//za render
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
	//private AddToolDialog addToolDialog = new AddToolDialog();
	private AddBrushDialog dialog;
	
	public SoftwareToolInfo(SoftwareTool tool) {
			
		nameL = new JLabel("Naziv alata *");
		brushesL = new JLabel("Cetkice *");
		modificatorsL = new JLabel("Modifikatori *");
		fileFormatL = new JLabel("Format fajla *");
		animationToolsL = new JLabel("Alati za animaciju *");
		//labele za render
		renderL = new JLabel("RENDER");
		renderNameL = new JLabel("Naziv rendera *");
		lightL = new JLabel("Svetlo *");
		materialsL = new JLabel("Materijali *");
		objectsL = new JLabel("Objekti *");
		camerasL = new JLabel("Kamere *");
		
		nameF = new JTextField(15);
		nameF.setName("Naziv alata*");
		
		fileFormatF = new JTextField(15);
		fileFormatF.setName("Format fajla*");
		
		modificatorsF = new JTextField(15);
		modificatorsF.setName("Modifikatori*");
		
		animationToolsF = new JTextField(15);
		animationToolsF.setName("Alati za animaciju*");
		
		JButton brushesF = new JButton("Dodaj cetkicu");
		
		//render
		renderNameF = new JTextField(15);
		renderNameF.setName("Naziv rendera*");
		
		camerasF = new JTextField(15);
		camerasF.setName("Kamere *");
		
		materialsF = new JTextField(15);
		materialsF.setName("Materijali*");
		
		objectsF = new JTextField(15);
		objectsF.setName("Objekti*");
		
		lightF = new JTextField(15);
		lightF.setName("Svetlo*");
		
		JButton okButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Odustani");
		
		brushesF.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 openDialogAction();
	         }
	      });
		
		setLayout(okButton,cancelButton, brushesF);
		
		
	}
	
	
	private void setLayout(JButton okButton, JButton cancelButton, JButton addBrush) {
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
		//--------------------
		gc.weightx=0.01;
		gc.weighty=0.01;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(20, 20, 0, 0);
		gc.anchor=GridBagConstraints.LINE_START;
		add(brushesL,gc);
		

		gc.gridy = 1;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(addBrush,gc);
		//----------------
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
		//---------------
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
		
		//PROVERITI
		gc.gridy = 4;
		gc.gridx = 0;
		gc.anchor=GridBagConstraints.LINE_START;
		add(modificatorsL,gc);
				
		gc.gridy = 4;
		gc.gridx = 1;
		gc.anchor=GridBagConstraints.LINE_START;
		add(modificatorsF,gc);
		
		//RENDER
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
		//---------------
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
		
		//PROVERITI
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
		add(okButton,gc);
				
		gc.gridy = 11;
		gc.gridx = 2;
		gc.anchor=GridBagConstraints.LINE_START;
		add(cancelButton,gc);
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
	      if (dialog == null) {
	         Window win = SwingUtilities.getWindowAncestor(this);
	         if (win != null) {
	        	dialog = new AddBrushDialog();
	         }
	      }
	      dialog.setVisible(true);;
	      brushes.add(dialog.getBrush());
	     for (Brush brush : brushes) {
	    	 System.out.println(brush.getName());
		}
	     
	   }
}
