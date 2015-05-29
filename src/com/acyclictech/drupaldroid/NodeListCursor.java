package com.acyclictech.drupaldroid;

import java.util.List;

import android.database.AbstractCursor;

import com.acyclictech.drupaljava.services.json.objects.NodeJsonObject;

public class NodeListCursor extends AbstractCursor {

	private List<NodeJsonObject> list;
	private String[] names;
//test
	public NodeListCursor(List<NodeJsonObject> data){
		this.list = data;
		names = list.get(0).getNames().toArray(new String[0]);
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public String[] getColumnNames() {
		return names;
	}

	@Override
	public String getString(int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getShort(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFloat(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDouble(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNull(int column) {
		// TODO Auto-generated method stub
		return false;
	}

}
