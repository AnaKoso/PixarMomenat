package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gui.MainFrame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Staff.Workplace;

public class StaffDatabase {

	private static StaffDatabase instance=null;
	
	public static StaffDatabase getInstance() {
		if(instance==null) {
			instance= new StaffDatabase();
		}
		return instance;
	}
	
	private ArrayList<Staff> staff;
	private ArrayList<String> columns;
	
	
	private StaffDatabase() {
		
		this.staff = new ArrayList<Staff>();
		this.columns=new ArrayList<String>();
		this.columns.add("IME");
		this.columns.add("PREZIME");
		this.columns.add("JMBG");
		this.columns.add("DATUM RODJENJA");
		this.columns.add("EMAIL");
		this.columns.add("ADRESA");
	
	}
	
	private void initStaff() {
		
		try {
			Date date1=new SimpleDateFormat("dd.MM.yyyy").parse("11.12.1999");
			addStaff("jelena","stajic", date1, "ulica" , "1" , "ns", "123123123", "mymail@email.com", Workplace.ANIMATOR); //da popunimo nekin podacima 
			
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}

	public ArrayList<String> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}
	
	public int getColumnCount() {
		return columns.size(); 
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Staff getRow(int index) {
		return this.staff.get(index);
	}
	
	public String getValueAt(int row, int column) {
		Staff staff = this.staff.get(row);
		
		switch(column) {
		case 0:
			return staff.getFirstName();
		case 1:
			return staff.getLastName();
		case 2:
			return staff.getJmbg();
		case 3:
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			String strDate = dateFormat.format(staff.getDateOfBirth());
			return strDate;
		case 4:
			return staff.getEmail();
		case 5:
			return staff.getAddress().getStreet() + " " + staff.getAddress().getNumber() + ", " + staff.getAddress().getCity() + "";
		
		default:
				return  null;
		}
	}
	
	public Boolean uniqueJMBG(String jmbg) {
		
		for(Staff s: staff) {
			if(s.getJmbg().equals(jmbg)) {
				return false;
			}
		}
		return true;
	}
	
	public void addStaff (String firstName, String lastName, Date dateOfBirth, String street, String streetNumber, String city,
			String jmbg, String email, Workplace workplace ) {
		//ne moze se dodati staff sa istim jmbg
		if(uniqueJMBG(jmbg)) { 
		this.staff.add(new Staff(lastName, firstName, dateOfBirth, new Address(street, streetNumber, city), jmbg, email, workplace ));
		}
	}
	
	public void deleteStaff(String jmbg) {
		for(Staff s: staff) {
			if(s.getJmbg().equals(jmbg)) { 
				staff.remove(s);
				break;
			}
		}
	}
	public void editStaff(String firstName, String lastName, Date dateOfBirth, String street, String streetNumber, String city,
			String jmbg, String email, Workplace workplace) {
		for (Staff s: staff) {
			if(s.getJmbg().equals(jmbg)) {
				//uz pretpostavku da se jmbg ne menja
				s.setLastName(lastName);
				s.setFirstName(firstName);
				s.setDateOfBirth(dateOfBirth);
				s.getAddress().setStreet(street);
				s.getAddress().setNumber(streetNumber);
				s.getAddress().setCity(city);
				s.setEmail(email);
				s.setWorkplace(workplace);
			}
		}
		
	}

	public void addStaff(Staff entity) {
		
		if(uniqueJMBG(entity.getJmbg())) { 
			this.staff.add(entity);		
		}
	}

	public void serializeStaff() {
		try {
			FileOutputStream fosStaff = new FileOutputStream("staff.ser");
			ObjectOutputStream outStaff = new ObjectOutputStream(fosStaff);
			outStaff.writeObject(StaffDatabase.getInstance().getStaff());

			outStaff.close();
			fosStaff.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void deserializeStaff() {
		try{
			System.out.println("\n\n");
			FileInputStream foutStaff = new FileInputStream("staff.ser");
			ObjectInputStream staffIn= new ObjectInputStream(foutStaff);
			@SuppressWarnings("unchecked")
			ArrayList<Staff> staff = (ArrayList<Staff>) staffIn.readObject();
			StaffDatabase.getInstance().setStaff(staff);
			MainFrame.getInstance().updateStaffTable(null, -1);

			foutStaff.close();
			staffIn.close();
		}catch(IOException exp) {
			exp.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		
	}

}
