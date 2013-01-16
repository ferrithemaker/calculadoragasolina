package com.app.calculadoragasolina;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Carfragment extends Fragment {
	
	View view = null;
	Button coche_update;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.car, null);
			Spinner spinner_coche = (Spinner) view.findViewById(R.id.tipo_coche);
			//coche_update= (Button) view.findViewById(R.id.coche_update);
	        Spinner spinner_combustible = (Spinner) view.findViewById(R.id.tipo_combustible);
	        ArrayAdapter<CharSequence> adapter_coche = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.tipos_de_coche, android.R.layout.simple_spinner_item);
	        ArrayAdapter<CharSequence> adapter_combustible = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.tipos_de_combustible, android.R.layout.simple_spinner_item);
	        // Specify the layout to use when the list of choices appears
	        adapter_coche.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        adapter_combustible.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        // Apply the adapter to the spinner
	        spinner_coche.setAdapter(adapter_coche);
	        spinner_combustible.setAdapter(adapter_combustible);
	        /*coche_update.setOnClickListener(new Button.OnClickListener() {
		       	   public void onClick(View v) {
		       		   // nada que hacer
		       		  
		       	   }
		          }); */
	        spinner_coche.setOnItemSelectedListener(new OnItemSelectedListener() {

	        	public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	                Engine.TIPO_COCHE= parentView.getSelectedItem().toString();
	                //your code here
	            }

	            public void onNothingSelected(AdapterView<?> parentView) {
	                //selectedyear = 0;
	                //return;
	            }
	        });
	        spinner_combustible.setOnItemSelectedListener(new OnItemSelectedListener() {

	            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	                Engine.TIPO_COMBUSTIBLE= parentView.getSelectedItem().toString();
	                //your code here
	            }

	            public void onNothingSelected(AdapterView<?> parentView) {
	                //selectedyear = 0;
	                //return;
	            }
	        });
			return view;
			
			
			
	}

}
