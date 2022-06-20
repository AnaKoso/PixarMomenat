package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.tools.Tool;

import model.Staff.Workplace;

public class SoftwareToolDatabase {

	private static SoftwareToolDatabase instance=null;
	
	public static SoftwareToolDatabase getInstance() {
		if(instance==null) {
			instance= new SoftwareToolDatabase();
		}
		return instance;
	}
	
	private ArrayList<SoftwareTool> tools;
	private ArrayList<String> columns;
	
	
	
	public ArrayList<SoftwareTool> getTools() {
		return tools;
	}

	public void setTools(ArrayList<SoftwareTool> tools) {
		this.tools = tools;
	}

	public ArrayList<String> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}

	private SoftwareToolDatabase() {
	
		this.tools = new ArrayList<SoftwareTool>();
		this.columns=new ArrayList<String>();
		this.columns.add("NAZIV");
		this.columns.add("FAJL FORMAT");
		this.columns.add("NAZIV RENDERA");
		this.columns.add("MATERIJALI RENDERA");
		this.columns.add("KAMERE RENDERA");
		this.columns.add("OBJEKTI RENDERA");
		this.columns.add("CETKICE");
		this.columns.add("ALATI ZA ANIMACIJU");
	
	}
	
	public int getColumnCount() {
		return columns.size(); //8
	}
	private void initTools() {

		this.tools = new ArrayList<SoftwareTool>();
		try {
			var render = new Render("rendere name", "nesto","nesto","nesto","light");
			addTool("name", "format ", "ovdje treba lista", render, "modifikatori vrv", new ArrayList<Brush>());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public SoftwareTool getRow(int index) {
		return this.tools.get(index);
	}
	
	public String getValueAt(int row, int column) {
		SoftwareTool tool = this.tools.get(row);
		
		switch(column) {
		case 0:
			return tool.getName();
		case 1:
			return tool.getFileFormat();
		case 2:
			return tool.getRender().getName();
		case 3:
			return tool.getRender().getMaterials();
		case 4:
			return tool.getRender().getCameras();
		case 5:
			return tool.getRender().getObjects();
		case 6:
			return tool.getBrushesNames(); //treba doradiiti da prikazuje i boju 
		case 7:
			return tool.getAnimationTools();
		default:
				return  null;
		}
	}
	
	public Boolean uniqueToolName(String name) {
		
		for(SoftwareTool t: tools) {
			if(t.getName() .equals(name)) {
				return false;
			}
		}
		return true;
	}
	
	public void addTool (String name, String fileFormat, String animationTools, 
			Render render, String modificators, List<Brush> brushes 
			 ) {
		//ne moze se dodati staff sa istim jmbg
		if(uniqueToolName(name)) { 
		this.tools.add(new SoftwareTool(name,brushes,fileFormat,animationTools,modificators,render));
		}
	}
	public void addTool (SoftwareTool tool) {
		//ne moze se dodati staff sa istim jmbg
		if(uniqueToolName(tool.getName())) { 
		this.tools.add(tool);
		System.out.println("USAO U bazu");
		}
		System.out.println("Tools:");
		for (SoftwareTool t : tools) {
			System.out.println(t.getName());
		}
	}
	
	public void deleteTool(String name) {
		for(SoftwareTool t: tools) {
			if(t.getName().equals(name)) { 
				tools.remove(t);
				break;
			}
		}
	}
	public void editTool(String name, String fileFormat, String animationTools,
			Render render) {
		for (SoftwareTool t: tools) {
			if(t.getName().equals(name)) {
				//uz pretpostavku da se jmbg ne menja
				t.setFileFormat(fileFormat);
				t.setAnimationTools(animationTools);
				t.setRender(render);
			}
		}
		
	}
	
	public void editTool(SoftwareTool tool) {
		for (SoftwareTool t: tools) {
			if(t.getName().equals(tool.getName())) {
				//uz pretpostavku da se jmbg ne menja
				t.setFileFormat(tool.getFileFormat());
				t.setAnimationTools(tool.getAnimationTools());
				t.setRender(tool.getRender());
				t.setBrushes(tool.getBrushes());
				t.setModificators(tool.getModificators());
			}
		}
		
	}

	public void addStaff(SoftwareTool entity) {
		
		if(uniqueToolName(entity.getName())) { 
			this.tools.add(entity);		
		}
	}

	public void serializeSpftwareTools() {
		try {
			FileOutputStream fosTools = new FileOutputStream("tools.ser");
			ObjectOutputStream outTools = new ObjectOutputStream(fosTools);
			outTools.writeObject(SoftwareToolDatabase.getInstance().getTools());

			outTools.close();
			fosTools.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void deserializeTools() {
		try{
			System.out.println("\n\n");
			FileInputStream foutTools = new FileInputStream("tools.ser");
			ObjectInputStream toolsIn= new ObjectInputStream(foutTools);
			@SuppressWarnings("unchecked")
			ArrayList<SoftwareTool> tools = (ArrayList<SoftwareTool>) toolsIn.readObject();
			SoftwareToolDatabase.getInstance().setTools(tools);

			foutTools.close();
			toolsIn.close();
		}catch(IOException exp) {
			exp.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		
	}

}
