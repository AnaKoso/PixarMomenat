package model;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class Brush implements Serializable{

	private String name;
	private List<Color> colors;
	private String usage;
	
	
	public Brush() {
		super();

	}
	public Brush(String name, List<Color> colors, String usage) {
		super();
		this.name = name;
		this.colors = colors;
		this.usage = usage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public List<Color> getColors() {
		return colors;
	}
	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	@Override
	public String toString() {
		return "Brush [name=" + name + ", colors=" + colors + ", usage=" + usage + "]";
	}
	
	
	
}

