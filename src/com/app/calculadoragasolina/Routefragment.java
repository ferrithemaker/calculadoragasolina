package com.app.calculadoragasolina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Routefragment extends Fragment {
	
	View view = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.route, null);
			EditText km_edit = (EditText) view.findViewById(R.id.kilometros_edit);
			km_edit.setText(Integer.toString(Engine.KM));
			return view; 
	}
	
	

}
