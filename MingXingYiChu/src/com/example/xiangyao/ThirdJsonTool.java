package com.example.xiangyao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdJsonTool {
	public static List<ThirdModel>  getItemsData(byte[] b){
		if(b.length>0){
		String str=new String(b);
		List<ThirdModel> list=new ArrayList<ThirdModel>();
		ThirdModel tm;
		try {
			JSONObject mainJson=new JSONObject(str);
			String data=mainJson.getString("data");
			
			JSONObject dataJson=new JSONObject(data);
			String items=dataJson.getString("items");
			JSONArray itemJson=new JSONArray(items);
			for(int i=0;i<itemJson.length();i++){
				tm=new ThirdModel();
				JSONObject jsonObject=itemJson.getJSONObject(i);
				
//				tm.setWidth(jsonObject.getString("with"));
//				tm.setHeight(jsonObject.getString("height"));
				
				String component=jsonObject.getString("component");
				JSONObject componentJson=new JSONObject(component);
				
				tm.setUserName(componentJson.getString("userName"));
				tm.setCategory(componentJson.getString("category"));
				tm.setDescription_main(componentJson.getString("description"));
				tm.setUserId(componentJson.getString("userId"));
				tm.setUserAvatar(componentJson.getString("userAvatar"));
				tm.setPicUrl_main(componentJson.getString("picUrl"));
				tm.setId(componentJson.getString("id"));
				tm.setCollectionCount(componentJson.getString("collectionCount"));
				tm.setCommentCount(componentJson.getString("commentCount"));
				tm.setDateTime(componentJson.getString("dateTime"));
				
				String actions=componentJson.getString("actions");
				JSONArray actionsJson=new JSONArray(actions);
					JSONObject actionsJsonObject=actionsJson.getJSONObject(1);
					tm.setWidth(actionsJsonObject.getString("width"));
					tm.setHeight(actionsJsonObject.getString("height"));
					tm.setPicUrl(actionsJsonObject.getString("normalPicUrl"));
					String actions_description=actionsJsonObject.getString("description");
					
				List<String> lwebUrl=new ArrayList<String>();
				List<String> lorigUrl=new ArrayList<String>();
				StringBuffer sb=new StringBuffer(); 
				
				JSONArray actions_descriptionJSON=new JSONArray(actions_description);
				for(int j=0;j<actions_descriptionJSON.length();j++){
					String[] text=new String[j]; 
					
					JSONObject actions_descriptionObject=actions_descriptionJSON.getJSONObject(j);
					String description_component=actions_descriptionObject.getString("component");
					JSONObject description_componentObject=new JSONObject(description_component);
					
//					text[j]=description_componentObject.optString("text");
					sb.append(description_componentObject.optString("text"));
					String action=description_componentObject.optString("action");
//					System.out.println("1111--"+action);
					if(action.length()>10){
						JSONObject actionObject=new JSONObject(action);
						String webUrl=actionObject.getString("webUrl");
						String origUrl="url";
						lwebUrl.add(webUrl);
						lorigUrl.add(origUrl);
					}
				}
				tm.setText(sb.toString());
				list.add(tm);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
		return null;
	}
}
