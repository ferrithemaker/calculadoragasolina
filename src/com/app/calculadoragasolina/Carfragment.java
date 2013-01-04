package com.app.calculadoragasolina;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Carfragment extends Fragment {
	
	View view = null;
	EditText km_edit;
	Button coche_update;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getActivity().setContentView(R.layout.car);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.car, container, false);
			
			return view;
			
	}
	
	public void update() {
		km_edit.setText(Integer.toString(Engine.KM));
	}
	
	public void onResume() { 
		  super.onResume(); 
		  km_edit = (EditText) view.findViewById(R.id.kilometros_edit);
			//coche_update = (Button) view.findViewById(R.id.coche_update);
			//coche_update.setOnClickListener((android.view.View.OnClickListener) update);
			//km_edit.setText(Integer.toString(Engine.KM));
		}
	
	
	

}
