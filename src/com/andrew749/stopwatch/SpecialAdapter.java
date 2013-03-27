package com.andrew749.stopwatch;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SpecialAdapter extends BaseAdapter {
	static ArrayList arrayToWorkWith;
	static int numberOfOptions;
	private LayoutInflater inflater = null;
	private TextView time, position;

	public SpecialAdapter(Context context, ArrayList list) {
		 arrayToWorkWith=list;
		 numberOfOptions=arrayToWorkWith.size();
		 inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return numberOfOptions;
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1=inflater.inflate(R.layout.listitem,arg2, false);
		time=(TextView)arg1.findViewById(R.id.listitemtext);
		return arg1;
	}

}
