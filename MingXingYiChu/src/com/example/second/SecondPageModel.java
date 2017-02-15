package com.example.second;

public class SecondPageModel {
private String category;
private String collectionCount;
private String title;
private String day;
private String id;
private String picUrl;
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getCollectionCount() {
	return collectionCount;
}
public void setCollectionCount(String collectionCount) {
	this.collectionCount = collectionCount;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPicUrl() {
	return picUrl;
}
public void setPicUrl(String picUrl) {
	this.picUrl = picUrl;
}
@Override
public String toString() {
	return "SecondPageModel [category=" + category + ", collectionCount="
			+ collectionCount + ", title=" + title + ", day=" + day + ", id=" + id + ", picUrl="
			+ picUrl + "]";
}
public SecondPageModel(String category, String collectionCount, String title,
		String year, String month, String day, String id, String picUrl) {
	super();
	this.category = category;
	this.collectionCount = collectionCount;
	this.title = title;
	this.day = day;
	this.id = id;
	this.picUrl = picUrl;
}
public SecondPageModel() {
	super();
	// TODO Auto-generated constructor stub
}

}
