package model;

import java.io.Serializable;

public class Render implements Serializable{

	private String name;

	private String materials;
	private String cameras;
	private String objects;
	private String light;
	
	public Render() {
		super();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getCameras() {
		return cameras;
	}
	public void setCameras(String cameras) {
		this.cameras = cameras;
	}
	public String getObjects() {
		return objects;
	}
	public void setObjects(String objects) {
		this.objects = objects;
	}
	public String getLight() {
		return light;
	}
	public void setLight(String light) {
		this.light = light;
	}
	public Render(String name, String materials, String cameras, String objects, String light) {
		super();
		this.name = name;
		this.materials = materials;
		this.cameras = cameras;
		this.objects = objects;
		this.light = light;
	}
	
	@Override
	public String toString() {
		return "Render [name=" + name + ", materials=" + materials + ", cameras=" + cameras + ", objects=" + objects
				+ ", light=" + light + "]";
	}
	

	
}
