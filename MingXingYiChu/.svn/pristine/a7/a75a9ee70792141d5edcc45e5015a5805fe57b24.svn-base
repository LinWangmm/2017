package com.example.mxyc.wangluo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.mxyc.model.Actions;
import com.example.mxyc.model.Actionsitem;
import com.example.mxyc.model.Items;
import com.example.mxyc.model.Itm;
import com.example.mxyc.model.Sy;
import com.example.mxyc.model.Tlt;
import com.example.mxyc.model.Vaction;
import com.example.mxyc.model.Vcomponent;



public class Jsonjx {
	public static Sy getJsonSy(String str) {
		Sy sy = new Sy();
		try {
			JSONObject ja = new JSONObject(str);
			sy.setMessage(ja.getString("message"));
			sy.setData(ja.getJSONObject("data"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sy;

	}

	public static List<Itm> getJsonItms(String str) {
		List<Itm> list = new ArrayList<Itm>();
		try {
			JSONObject items = new JSONObject(str);
			JSONArray items_arrArray = items.getJSONArray("items");
			for (int i = 0; i < items_arrArray.length(); i++) {
				JSONObject object = new JSONObject(items_arrArray.get(i)
						.toString());
				Itm itm = new Itm();
				if (!object.has("timestamp")) {
					itm.setTimestamp("标题");
					Tlt tltle_tlt = new Tlt();
					JSONObject tlt = new JSONObject(
							object.getString("component"));
					tltle_tlt.setMonthOnly(tlt.getString("monthOnly"));
					tltle_tlt.setShowTime(tlt.getString("showTime"));
					tltle_tlt.setMonth(tlt.getString("month"));
					tltle_tlt.setComponentType(tlt.getString("componentType"));
					tltle_tlt.setWeekDay(tlt.getString("weekDay"));
					tltle_tlt.setYear(tlt.getString("year"));
					tltle_tlt.setWeekDayBgUrl(tlt.getString("weekDayBgUrl"));
					tltle_tlt.setXingQi(tlt.getString("xingQi"));
					tltle_tlt.setDay(tlt.getString("day"));
					if (tlt.has("picUrl")) {
						tltle_tlt.setPicUrl(tlt.getString("picUrl"));
						JSONArray array = new JSONArray(
								tlt.getString("actions"));
						Actions actions = new Actions();
						JSONObject actionsObject = new JSONObject(array.get(1)
								.toString());
						actions.setId(actionsObject.getString("id"));
						actions.setTitle(actionsObject.getString("title"));
						tltle_tlt.setActions(actions);
					}else {
						tltle_tlt.setPicUrl("无");
					}
					itm.setComponent(tltle_tlt);
					list.add(itm);
				} else {
					itm.setWidth(object.getString("width"));
					itm.setHeight(object.getString("height"));
					itm.setTimestamp(object.getString("timestamp"));
					Items items2 = new Items();
					JSONObject itemsObject = new JSONObject(
							object.getString("component"));
					items2.setCollectionCount(itemsObject
							.getString("collectionCount"));
					items2.setComponentType(itemsObject
							.getString("componentType"));
					items2.setDescription(itemsObject.getString("description"));
					items2.setId(itemsObject.getString("id"));
					items2.setItemsCount(itemsObject.getString("itemsCount"));
					items2.setPicUrl(itemsObject.getString("picUrl"));
					JSONObject acObject = new JSONObject(
							itemsObject.getString("action"));
					Actionsitem am = new Actionsitem();
					am.setName(acObject.getString("userName"));
					am.setNormalPicUrl(acObject.getString("normalPicUrl"));
					am.setDescription(acObject.getString("description"));
					am.setActionType(acObject.getString("actionType"));
					am.setUserPicUrl(acObject.getString("userPicUrl"));
					am.setDateTime(acObject.getString("dateTime"));
					am.setId(acObject.getString("id"));
					am.setCollectionCount(acObject.getString("collectionCount"));
					JSONArray urlList = new JSONArray(
							acObject.getString("itemPicUrlList"));
					List<String> urList = new ArrayList<String>();
					for (int n = 0; n < urlList.length(); n++) {
						JSONObject joo = new JSONObject(urlList.get(n)
								.toString());
						String url = joo.toString();
						urList.add(url);
					}
					am.setItemPicUrlList(urList);
					items2.setAction(am);
					itm.setComponent(items2);
					list.add(itm);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public static List<Vcomponent> getVcomponent(String str) {
		List<Vcomponent> vList = new ArrayList<Vcomponent>();
		try {
			JSONObject jb = new JSONObject(str);
			JSONObject job = new JSONObject(jb.getString("data"));
			JSONArray ja = new JSONArray(job.getString("items"));
			for (int i = 0; i < ja.length(); i++) {
				Vcomponent vcomponent = new Vcomponent();
				JSONObject vc = new JSONObject(ja.get(i).toString()).getJSONObject("component");
				vcomponent.setComponentType(vc.getString("componentType"));
				vcomponent.setPicUrl(vc.getString("picUrl"));
				Vaction va = new Vaction();
				JSONObject acj = new JSONObject(vc.getString("action"));
				va.setActionType(acj.getString("actionType"));
				va.setId(acj.getString("id"));
				va.setTitle(acj.getString("title"));
				vcomponent.setVaction(va);
				vList.add(vcomponent);

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vList;

	}
}
