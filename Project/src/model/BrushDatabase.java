package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BrushDatabase {
	
	private static BrushDatabase instance=null;
	
	public static BrushDatabase getInstance() {
		if(instance==null) {
			instance= new BrushDatabase();
		}
		return instance;
	}
	
	private ArrayList<Brush> brushes;
	private ArrayList<Object> columns;
	
	private BrushDatabase() {
		this.brushes = new ArrayList<Brush>();
		this.columns=new ArrayList<Object>();
		this.columns.add("NAZIV");
		this.columns.add("NAMENA");
	
	}

	public ArrayList<Brush> getBrushes() {
		return brushes;
	}

	public void setBrushes(ArrayList<Brush> brushes) {
		this.brushes = brushes;
	}

	public ArrayList<Object> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<Object> columns) {
		this.columns = columns;
	}
	public int getColumnCount() {
		return columns.size(); 
	}
	
	public Object getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Brush getRow(int index) {
		return this.brushes.get(index);
	}
	
	public Object getValueAt(int row, int column) {
		Brush brush = this.brushes.get(row);
		
		switch(column) {
		case 0:
			return brush.getName();
		case 1:
			return brush.getUsage();
		default:
				return  null;
		}
	}
	
	public JPanel getColorPanel(List<Color> colors) {
		FlowLayout colorsLayout = new FlowLayout();
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(colorsLayout);
		colorPanel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		for (Color color : colors) {
			JPanel c = new JPanel();
			colorPanel.add(c);
			c.setBackground(color);
		}
		
		return colorPanel;
	}

}
