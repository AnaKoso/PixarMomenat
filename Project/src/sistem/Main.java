package sistem;

import gui.MainFrame;
import model.SoftwareToolDatabase;
import model.StaffDatabase;

public class Main {

	public static void main(String[] args) {

		System.out.println("public void main");
		StaffDatabase.getInstance().deserializeStaff();
		SoftwareToolDatabase.getInstance().deserializeTools();
		MainFrame.getInstance();
	}

}