package com.example.mxyc.model;

public class Vaction {
	private String actionType;
	private String id;
	private String title;
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
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
	public Vaction(String actionType, String id, String title) {
		super();
		this.actionType = actionType;
		this.id = id;
		this.title = title;
	}
	public Vaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vaction [actionType=" + actionType + ", id=" + id + ", title="
				+ title + "]";
	}
	

}
