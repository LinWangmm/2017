package com.example.mxyc.model;

public class Itm {
	private String width;
	private Object component;
	private String height;
	private String timestamp;

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public Object getComponent() {
		return component;
	}

	public void setComponent(Object component) {
		this.component = component;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Itm(String width, Object component, String height, String timestamp) {
		super();
		this.width = width;
		this.component = component;
		this.height = height;
		this.timestamp = timestamp;
	}

	public Itm() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Itm [width=" + width + ", component=" + component + ", height="
				+ height + ", timestamp=" + timestamp + "]";
	}

}
