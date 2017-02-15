package com.example.mxyc.model;

public class Sy {
	private String message;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Sy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sy(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Sy [message=" + message + ", data=" + data + "]";
	}
	
}
