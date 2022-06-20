package popDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.StaffController;
import model.Address;
import model.Staff;
import model.Staff.Workplace;

public class EditStaffDialog extends JDialog{

	
	private static final long serialVersionUID = 1L;
	
	private JPanel Info; 
	private JPanel Software;
	private JTabbedPane tabbedPane;
	
	
	static JLabel nameL;
	static JLabel surnameL;
	static JLabel jmbgL;
	static JLabel dateOfBirthL;
	static JLabel emailL;
	static JLabel streetL;
	static JLabel cityL;
	static JLabel streetNumL;
	static JLabel workplaceL;
	
	static JTextField nameF;
	static JTextField surnameF;
	static JTextField jmbgF;
	static JTextField dateOfBirthF;
	static JTextField emailF;
	static JTextField streetF;
	static JTextField cityF;
	static JTextField streetNumF;
	
	
	static JComboBox<String> workplaceBox;
		
	public EditStaffDialog(Staff staff) {
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		nameL=new JLabel("Ime* ");
		surnameL= new JLabel("Prezime *");
		jmbgL=new JLabel("Jmbg * ");
		dateOfBirthL=new JLabel("Datum rodjenja * ");
	    streetL=new JLabel("Ulica * ");
	    streetNumL=new JLabel("Broj * ");
	    cityL=new JLabel("Grad * ");
		emailL= new JLabel("E-mail adresa * ");
		workplaceL= new JLabel("Radno mesto * ");
		
		workplaceBox=new JComboBox();
		
		DefaultComboBoxModel workplaceModel=new DefaultComboBoxModel();
		workplaceModel.addElement("MODELATOR");
		workplaceModel.addElement("RIGER");
		workplaceModel.addElement("ANIMATOR");
		workplaceModel.addElement("ILUSTRATOR");
		workplaceBox.setModel(workplaceModel);
		workplaceBox.setSelectedIndex(0);
		workplaceBox.setEditable(true);
		
		nameF=new JTextField(15);
		nameF.setName("nameTxt");
		nameF.setText(staff.getFirstName());
		
		
		surnameF = new JTextField(15);
		surnameF.setName("surnameTxt");
		surnameF.setText(staff.getLastName());
		
		jmbgF = new JTextField(15);
		jmbgF.setName("jmbgTxt");
		jmbgF.setText(staff.getJmbg());
		jmbgF.setEditable(false);
		
		dateOfBirthF = new JTextField(15);
		dateOfBirthF.setName("dateTxt");
		dateOfBirthF.setText(toMyDateString(staff.getDateOfBirth()));
		
		streetF = new JTextField(15);
		streetF.setName("streetTxt");
		streetF.setText(staff.getAddress().getStreet());
		
		streetNumF = new JTextField(15);
		streetNumF.setName("streetNumTxt");
		streetNumF.setText(staff.getAddress().getNumber());

		cityF = new JTextField(15);
		cityF.setName("cityTxt");
		cityF.setText(staff.getAddress().getCity());
		
		emailF = new JTextField(15);
		emailF.setName("emailTxt");
		emailF.setText(staff.getEmail());

		
JButton okButton= new JButton("Potvrdi");
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Staff staff;
				staff = collectInfo();
				if(staff == null) {
					System.out.println("NoSucces!");
					okButton.setToolTipText("Polja nisu popunjena!");
					JOptionPane.showMessageDialog(parent,"Polja nisu popunjena!");
				}else {
					System.out.println("Succes!");
					StaffController.getInstance().editStaff(staff);
					dispose();
				}
			}
		});
		
		
		
		
		JButton cancelButton = new JButton("Odustani");
		 cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 dispose();
				}
			});
		
		
		createTabbedPane(staff);
		setLayoutInfo(okButton, cancelButton);
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Editovanje Predmeta");
		setSize(new Dimension(500,500));
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());	
		setModal(true);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
       
		 setResizable(true);
		 setVisible(true);
	}
	
	
	private void createTabbedPane(Staff staff) {
		tabbedPane = new JTabbedPane();
		Info =  new JPanel();
		Software = new JPanel();
		tabbedPane.addTab("Info", Info);
		tabbedPane.addTab("Softveri", Software);
		this.setLocationRelativeTo(rootPane);
		add(tabbedPane,BorderLayout.CENTER);
		
	}
	
	private Staff collectInfo() {

		String name= nameF.getText();
		String surname= surnameF.getText();
		Date dateOfBirth= stringToDate(dateOfBirthF.getText());
		
		String street = streetF.getText();
		String streetNum = streetNumF.getText();
		String city = cityF.getText();
		String jmbg = jmbgF.getText();
		String email =emailF.getText();
	   
		int work = workplaceBox.getSelectedIndex();
		
		Workplace workplace = Workplace.MODELATOR;
		if(work == 0 ) {
			workplace = Workplace.MODELATOR;
		}else if (work == 1 ){
			workplace = Workplace.RIGGER;
		}else if (work == 2 ){
			workplace = Workplace.ANIMATOR;
		}else if (work == 3 ){
			workplace = Workplace.ILLUSTRATOR;
		}
		
		if(name.equals("") || surname.equals("") || street.equals("") || streetNum==null|| city.equals("")
				|| email.equals("") || jmbg.equals("") || dateOfBirth.equals(null)  ) {
			System.out.println("ERROR:Pogresno unijeta vrijednost u polja!");
			return null;
		}
		
		Staff staff= new Staff(surname,name,dateOfBirth,new Address(street,streetNum, city),jmbg,email,workplace);
			
		return staff;
	}
	
	private void setLayoutInfo(JButton okButton, JButton cancelButton) {
		GridBagLayout infoLayout  = new GridBagLayout();
		GridBagConstraints gbc= new GridBagConstraints();
		Info.setLayout(infoLayout);
		setLayout(new FlowLayout());
		
		
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(nameL, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(nameF, gbc);
		
		//--------------------
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_START;
		Info.add(surnameL,gbc);
		

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		Info.add(surnameF, gbc);
		
		
		
		//----------------
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(jmbgL,gbc);
				

		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(jmbgF,gbc);
				
				
		//----------------
		
		
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(dateOfBirthL,gbc);
		

		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(dateOfBirthF,gbc);
		
	
		//------------------
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(streetL,gbc);
		

		gbc.gridy = 4;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(streetF,gbc);
		
		
		//----------------
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(streetNumL,gbc);
		

		gbc.gridy = 5;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(streetNumF,gbc);
		

		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(cityL,gbc);
		
		gbc.gridy = 6;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(cityF,gbc);
		//-----------------------
		
		
		//-----------------
		//e mail addresa
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 7;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(emailL,gbc);
		

		gbc.gridy = 7;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(emailF,gbc);
		
		//---------------------
	

		
		gbc.weightx=0.01;
		gbc.weighty=0.01;
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(workplaceL,gbc);
		
		gbc.gridy = 8;
		gbc.gridx = 1;	
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(workplaceBox,gbc);
		
		

		gbc.gridy = 9;
		gbc.gridx = 1;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(okButton,gbc);
				
		gbc.gridy = 9;
		gbc.gridx = 2;
		gbc.anchor=GridBagConstraints.LINE_START;
		Info.add(cancelButton,gbc);
		
		
		
	}
	private Date stringToDate(String text) {
		
		String sDate=text;
		Date date = null;
		try {
			date = new SimpleDateFormat("dd.MM.yyyy.").parse(sDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		} 
		return date;
	}  
	
	private String toMyDateString(Date dateOfBirth) {
		String date = "";
		var day = dateOfBirth.getDate();
		var month = dateOfBirth.getMonth() + 1;
		var year = dateOfBirth.getYear() + 1900;
		date = day + "." + month + "." + year + ".";
		System.out.println("edit staff 430:" + date);
		return date;
	}

	
	

}

