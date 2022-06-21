package controller;

import gui.MainFrame;
import model.Brush;
import model.SoftwareTool;
import model.SoftwareToolDatabase;
import model.StaffDatabase;

public class SoftwareToolController {
	
	private static SoftwareToolController instance = null;
	
	public static SoftwareToolController getInstance() {
		if(instance == null) {
			instance = new SoftwareToolController();
		}
		return instance;
	}
	
	private SoftwareToolController() {}

	public void deleteTool(SoftwareTool t) {
		SoftwareToolDatabase.getInstance().deleteTool(t.getName());
		MainFrame.getInstance().updateToolTable("OBRISAN ALAT", -1);
		System.out.println("USAO U KONTROLER delete tool");
		
	}

	public void addBrushToTool(Brush brush) {
		// TODO Auto-generated method stub
		
	}

	public boolean uniqueToolName(SoftwareTool tool) {
		return SoftwareToolDatabase.getInstance().uniqueToolName(tool.getName());
	}

	public void addTool(SoftwareTool tool) {
		SoftwareToolDatabase.getInstance().addTool(tool);
		System.out.println("USAO U KONTROLER");
		MainFrame.getInstance().updateToolTable("TOOL ADDED", -1);
		
	}
	
	public void editTool(SoftwareTool tool) {
		SoftwareToolDatabase.getInstance().editTool(tool);
		MainFrame.getInstance().updateToolTable(null, -1);
	}
}
