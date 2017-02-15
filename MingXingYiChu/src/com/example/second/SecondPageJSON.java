package com.example.second;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondPageJSON {
public static List<SecondPageModel> getSecondPageJSONData(String str){
	List<SecondPageModel> list=new ArrayList<SecondPageModel>();
	SecondPageModel spm;
	try {
		JSONObject strJson=new JSONObject(str);
		String data=strJson.getString("data");
		JSONObject dataJson=new JSONObject(data);
		String items=dataJson.getString("items");
		JSONArray itemsArray=new JSONArray(items);
		for(int i=0;i<itemsArray.length();i++){
			spm=new SecondPageModel();
			JSONObject componentJson=itemsArray.getJSONObject(i);
			String component=componentJson.getString("component");
			JSONObject cj=new JSONObject(component);
			spm.setCategory(cj.getString("category"));
			spm.setCollectionCount(cj.getString("collectionCount"));
			spm.setId(cj.getString("id"));
			spm.setPicUrl(cj.getString("picUrl"));
			spm.setTitle(cj.getString("title"));
			spm.setDay(cj.getString("year")+"-"+cj.getString("month")+"-"+cj.getString("day"));
			list.add(spm);
		}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;	
}
public static SecondSecondModel secondSecondJSON(String str){
	SecondSecondModel ssm=new SecondSecondModel();
	List<SecondSecondModelCell> list=new ArrayList<SecondSecondModelCell>();
	try {
		JSONObject firstJson=new JSONObject(str);
		String dataJson=firstJson.getString("data");
		JSONObject dj=new JSONObject(dataJson);
		ssm.setTitle(dj.getString("title"));
		ssm.setNextId(dj.getString("nextId"));
		ssm.setDateTime(dj.getString("dateTime"));
		ssm.setCollectionCount(dj.getString("collectionCount"));
		ssm.setCommentCount(dj.getString("commentCount"));
		ssm.setNextId(dj.getString("nextId"));
		
		String items=dj.getString("items");
		JSONObject itemJson=new JSONObject(items);
		String cells=itemJson.getString("cells");
		JSONArray cellsArray=new JSONArray(cells);
		for(int i=0;i<cellsArray.length();i++){
			JSONObject ij=cellsArray.getJSONObject(i);
			SecondSecondModelCell cell=new SecondSecondModelCell();
			cell.setHeight(ij.getString("height"));
			cell.setWidth(ij.getString("width"));
			String component=ij.getString("component");
			JSONObject cj=new JSONObject(component);
			String componentType=cj.getString("componentType");
			
			cell.setComponentType(componentType);
			if(componentType.equals("word")){
				cell.setAlign(cj.getString("align"));
				cell.setContent(cj.getString(component));
			}else if(componentType.equals("cell")){
				cell.setPicUrl(cj.getString("picUrl"));
			}
			list.add(cell);
		}
		ssm.setItems(list);
		return ssm;
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}
}
