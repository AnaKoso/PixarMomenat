package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Staff.Workplace;

public class Staff implements Serializable{
	
	public enum Workplace{ ILLUSTRATOR, ANIMATOR, MODELATOR, RIGGER};

	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private Address address;
	private String jmbg; 
	private String email;
	private Workplace workplace;
	private List<SoftwareTool> tools;
	public Staff() {
		super();

	}
	public Staff(String lastName, String firstName, Date dateOfBirth, Address address, String jmbg, String email,
			Workplace workplace, List<SoftwareTool> tools) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.jmbg = jmbg;
		this.email = email;
		this.workplace = workplace;
		this.tools = tools;
	}
	public Staff(String lastName, String firstName, Date dateOfBirth, Address address, String jmbg, String email,
			Workplace workplace) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.jmbg = jmbg;
		this.email = email;
		this.workplace = workplace;
		this.tools = new ArrayList<SoftwareTool>();
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Workplace getWorkplace() {
		return workplace;
	}
	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}
	public List<SoftwareTool> getTools() {
		return tools;
	}
	public void setTools(List<SoftwareTool> tools) {
		this.tools = tools;
	}
	@Override
	public String toString() {
		return "Staff [lastName=" + lastName + ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", jmbg=" + jmbg + ", email=" + email + ", workplace=" + workplace
				+ ", tools=" + tools + "]";
	}
	
	
}
