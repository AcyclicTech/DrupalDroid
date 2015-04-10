package com.acyclictech.drupaldroid;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

import android.app.Activity;
import android.content.res.AssetManager;

public class PropertyManager {

	private static PropertyManager instance = null;
	private Properties props;
	private TreeMap<String, String> tabs;

	public static PropertyManager getInstance(Activity activity){
		if(instance == null){
			instance = new PropertyManager(activity);
		}
		return instance;
	}
	
	private PropertyManager(Activity activity){
		AssetManager mgr = activity.getResources().getAssets();
		try {
			InputStream input = mgr.open("config.txt");
			props = new Properties();
			props.load(input);
			input.close();
			String url = (String) props.get("base.url");
			tabs = new TreeMap<String, String>();
			for(Entry<Object, Object> e: props.entrySet()){
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				if(key.startsWith("section")){
					tabs.put(key, value);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl(){
		return (String) props.get("base.url");
	}
	
	public String[] getSections(){
		List<String> sections = new ArrayList<String>();
		for(Entry<String, String> e: tabs.entrySet()){
			sections.add(e.getValue());
		}
		return sections.toArray(new String[tabs.entrySet().size()]);
	}
	
	public String getSection(int id){
		for(Entry<String, String> e: tabs.entrySet()){
			if(e.getKey().contains(Integer.toString(id))){
				return e.getValue();
			}
		}
		return "not found";
	}
}
