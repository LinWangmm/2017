package com.example.mxyc.model;

public class Actions {
	private String id;
	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Actions(String actionType, String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Actions() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Actions [ id=" + id + ", title=" + title + "]";
	}

}
