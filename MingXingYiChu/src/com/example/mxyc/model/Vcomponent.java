package com.example.mxyc.model;

public class Vcomponent {
	private String componentType;
	private String picUrl;
	private Vaction vaction;

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Vaction getVaction() {
		return vaction;
	}

	public void setVaction(Vaction vaction) {
		this.vaction = vaction;
	}

	public Vcomponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vcomponent(String componentType, String picUrl, Vaction vaction) {
		super();
		this.componentType = componentType;
		this.picUrl = picUrl;
		this.vaction = vaction;
	}

	@Override
	public String toString() {
		return "Vcomponent [componentType=" + componentType + ", picUrl="
				+ picUrl + ", vaction=" + vaction + "]";
	}

}
