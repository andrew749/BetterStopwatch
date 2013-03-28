package com.andrew749.stopwatch;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.andrew749.stopwatch.*;
public class SpecialAdapter extends BaseAdapter {
	static String[] arrayToWorkWith;
	static int numberOfOptions;
	private LayoutInflater inflater = null;
	private TextView time, position;

	public SpecialAdapter(Context context, String[] list) {
		 arrayToWorkWith=list;
		 numberOfOptions=arrayToWorkWith.length;
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
	// a method to run through the array and delete all the values
	public void clear(){
		for (int i=0;i<numberOfOptions;i++){
			arrayToWorkWith[i]="";
		}
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1=inflater.inflate(R.layout.listitem,arg2, false);
		time=(TextView)arg1.findViewById(R.id.listitemtext);
		time.setText((String)arrayToWorkWith[arg0]);
		return arg1;
	}

}
