package com.example.mxyc.model;

import java.util.List;

public class Actionsitem {
	private String name;
	private String normalPicUrl;
	private String description;
	private String userId;
	private String actionType;
	private List<String> itemPicUrlList;
	private String userPicUrl;
	private String dateTime;
	private String id;
	private String collectionCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNormalPicUrl() {
		return normalPicUrl;
	}

	public void setNormalPicUrl(String normalPicUrl) {
		this.normalPicUrl = normalPicUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public List<String> getItemPicUrlList() {
		return itemPicUrlList;
	}

	public void setItemPicUrlList(List<String> itemPicUrlList) {
		this.itemPicUrlList = itemPicUrlList;
	}

	public String getUserPicUrl() {
		return userPicUrl;
	}

	public void setUserPicUrl(String userPicUrl) {
		this.userPicUrl = userPicUrl;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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

	public Actionsitem(String name, String normalPicUrl, String description,
			String userId, String actionType, List<String> itemPicUrlList,
			String userPicUrl, String dateTime, String id,
			String collectionCount) {
		super();
		this.name = name;
		this.normalPicUrl = normalPicUrl;
		this.description = description;
		this.userId = userId;
		this.actionType = actionType;
		this.itemPicUrlList = itemPicUrlList;
		this.userPicUrl = userPicUrl;
		this.dateTime = dateTime;
		this.id = id;
		this.collectionCount = collectionCount;
	}

	public Actionsitem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Actionsitem [name=" + name + ", normalPicUrl=" + normalPicUrl
				+ ", description=" + description + ", userId=" + userId
				+ ", actionType=" + actionType + ", itemPicUrlList="
				+ itemPicUrlList + ", userPicUrl=" + userPicUrl + ", dateTime="
				+ dateTime + ", id=" + id + ", collectionCount="
				+ collectionCount + "]";
	}

}
