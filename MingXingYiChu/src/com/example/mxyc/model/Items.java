package com.example.mxyc.model;

import java.util.List;

public class Items {
	private String itemsCount;
	private String description;
	private String componentType;
	private String picUrl;
	private Actionsitem action;
	private String id;
	private String collectionCount;

	public String getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(String itemsCount) {
		this.itemsCount = itemsCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public Actionsitem getAction() {
		return action;
	}

	public void setAction(Actionsitem action) {
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollectionCount() {
		return collectionCount;
	}

	public void setCollectionCount(String collectionCount) {
		this.collectionCount = collectionCount;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(String itemsCount, String description, String componentType,
			String picUrl, Actionsitem action, String id, String collectionCount) {
		super();
		this.itemsCount = itemsCount;
		this.description = description;
		this.componentType = componentType;
		this.picUrl = picUrl;
		this.action = action;
		this.id = id;
		this.collectionCount = collectionCount;
	}

	@Override
	public String toString() {
		return "Items [itemsCount=" + itemsCount + ", description="
				+ description + ", componentType=" + componentType
				+ ", picUrl=" + picUrl + ", action=" + action + ", id=" + id
				+ ", collectionCount=" + collectionCount + "]";
	}

}
