package com.example.xiangyao;

import java.util.ArrayList;
import java.util.List;

public class ThirdModel {
private String userName;
private String userAvatar;
private String description_main;
private String picUrl_main;
private String userId;
private String commentCount;	
private String collectionCount;	
private String dateTime;
private String category;

private String height;
private String width;
private String text;
private String picUrl;
private String description_item;
private String component_text;

private List<String> origUrl;
private ArrayList<String> webUrl;
//û��
private String color;
private String title;

public String getUserName() {
	return userName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
private String id;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserAvatar() {
	return userAvatar;
}
public void setUserAvatar(String userAvatar) {
	this.userAvatar = userAvatar;
}
public String getDescription_main() {
	return description_main;
}
public void setDescription_main(String description_main) {
	this.description_main = description_main;
}
public String getPicUrl_main() {
	return picUrl_main;
}
public void setPicUrl_main(String picUrl_main) {
	this.picUrl_main = picUrl_main;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getCommentCount() {
	return commentCount;
}
public void setCommentCount(String commentCount) {
	this.commentCount = commentCount;
}
public String getCollectionCount() {
	return collectionCount;
}
public void setCollectionCount(String collectionCount) {
	this.collectionCount = collectionCount;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}
public String getHeight() {
	return height;
}
public void setHeight(String height) {
	this.height = height;
}
public String getWidth() {
	return width;
}
public void setWidth(String width) {
	this.width = width;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getPicUrl() {
	return picUrl;
}
public void setPicUrl(String picUrl) {
	this.picUrl = picUrl;
}
public String getDescription_item() {
	return description_item;
}
public void setDescription_item(String description_item) {
	this.description_item = description_item;
}
public String getComponent_text() {
	return component_text;
}
public void setComponent_text(String component_text) {
	this.component_text = component_text;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getTitle() {
	return title;
}
public List<String> getOrigUrl() {
	return origUrl;
}
public void setOrigUrl(List<String> origUrl) {
	this.origUrl = origUrl;
}
public ArrayList<String> getWebUrl() {
	return webUrl;
}
public void setWebUrl(ArrayList<String> webUrl) {
	this.webUrl = webUrl;
}
public void setTitle(String title) {
	this.title = title;
}

public ThirdModel() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ThirdModel [userName=" + userName + ", userAvatar=" + userAvatar
			+ ", description_main=" + description_main + ", picUrl_main="
			+ picUrl_main + ", userId=" + userId + ", commentCount="
			+ commentCount + ", collectionCount=" + collectionCount
			+ ", dateTime=" + dateTime + ", category=" + category + ", height="
			+ height + ", width=" + width + ", text=" + text + ", picUrl="
			+ picUrl + ", description_item=" + description_item
			+ ", component_text=" + component_text + ", origUrl=" + origUrl
			+ ", webUrl=" + webUrl + ", color=" + color + ", title=" + title
			+ ", id=" + id + "]";
}
public ThirdModel(String userName, String userAvatar, String description_main,
		String picUrl_main, String userId, String commentCount,
		String collectionCount, String dateTime, String category,
		String height, String width, String text, String picUrl,
		String description_item, String component_text, List<String> origUrl,
		ArrayList<String> webUrl, String color, String title, String id) {
	super();
	this.userName = userName;
	this.userAvatar = userAvatar;
	this.description_main = description_main;
	this.picUrl_main = picUrl_main;
	this.userId = userId;
	this.commentCount = commentCount;
	this.collectionCount = collectionCount;
	this.dateTime = dateTime;
	this.category = category;
	this.height = height;
	this.width = width;
	this.text = text;
	this.picUrl = picUrl;
	this.description_item = description_item;
	this.component_text = component_text;
	this.origUrl = origUrl;
	this.webUrl = webUrl;
	this.color = color;
	this.title = title;
	this.id = id;
}


}
