package controller;

import gui.MainFrame;
import model.SoftwareToolDatabase;
import model.Staff;
import model.StaffDatabase;

public class StaffController {

	private static StaffController instance = null;
	
	public static StaffController getInstance() {
		if(instance == null) {
			instance = new StaffController();
		}
		return instance;
	}
	
	private StaffController() {}

	public boolean uniqueJmbg(Staff staff) {
		return StaffDatabase.getInstance().uniqueJMBG(staff.getJmbg());
	}

	public void addStaff(Staff staff) {
		StaffDatabase.getInstance().addStaff(staff);
		System.out.println("USAO U KONTROLER add staff");
		MainFrame.getInstance().updateStaffTable("STAFF ADDED", -1);
		
	}

	public void deleteStaff(Staff s) {
		StaffDatabase.getInstance().deleteStaff(s.getJmbg());
		MainFrame.getInstance().updateStaffTable("OBRISAN ZAPOSLENI", -1);
		System.out.println("USAO U KONTROLER delete stff");
		
	}

	public void editStaff(Staff staff) {
		StaffDatabase.getInstance().editStaff(staff.getFirstName(), staff.getLastName(),
				staff.getDateOfBirth(), staff.getAddress().getStreet(), staff.getAddress().getNumber(),
				staff.getAddress().getCity(), staff.getJmbg(), staff.getEmail(), staff.getWorkplace()); 
		MainFrame.getInstance().updateStaffTable(null, -1);
	}
	
	//endpoints
}
