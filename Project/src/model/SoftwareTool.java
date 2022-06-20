package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SoftwareTool implements Serializable {

	private String name; 
	private List<Brush> brushes;
	private String fileFormat;

	private String animationTools;
	private Render render;
	private String modificators;
	
	public SoftwareTool() {
		super();
	}
	
	public SoftwareTool(String name, List<Brush> brushes, String fileFormat, 
			String animationTools, String modificators, Render render) {
		super();
		this.name = name;
		this.brushes = brushes;
		this.fileFormat = fileFormat;
		this.animationTools = animationTools;
		this.render = render;
		this.modificators = modificators;
	}
	public SoftwareTool(String name,  String fileFormat, String animationTools,
			String modificators, Render render) {
		super();
		this.name = name;
		this.brushes = new ArrayList<Brush>();
		this.fileFormat = fileFormat;
		this.animationTools = animationTools;
		this.render = render;
		this.modificators = modificators;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Brush> getBrushes() {
		return brushes;
	}
	public void setBrushes(List<Brush> brushes) {
		this.brushes = brushes;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	public Render getRender() {
		return render;
	}
	public void setRender(Render render) {
		this.render = render;
	}
	
	public String getAnimationTools() {
		return animationTools;
	}
	public void setAnimationTools(String animationTools) {
		this.animationTools = animationTools;
	}
	public String getModificators() {
		return modificators;
	}
	public void setModificators(String modificators) {
		this.modificators = modificators;
	}
	public String getBrushesNames() {
		String brushNames = "";
		for(Brush b : this.brushes) {
			brushNames = brushNames + b.getName() + ", ";
		}
		return brushNames;
	}
	@Override
	public String toString() {
		return "SoftwareTool [name=" + name + ", brushes=" + brushes + ", fileFormat=" + fileFormat
				+ ", animationTools=" + animationTools + ", render=" + render + ", modificators=" + modificators + "]";
	}

	
}
