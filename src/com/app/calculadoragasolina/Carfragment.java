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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Carfragment extends Fragment {
	
	View view = null;
	Button coche_update;
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.car, container, false);
			Spinner spinner_coche = (Spinner) view.findViewById(R.id.tipo_coche);
			Resources res = getResources();
	        Spinner spinner_combustible = (Spinner) view.findViewById(R.id.tipo_combustible);
	        ArrayAdapter<CharSequence> adapter_coche = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.tipos_de_coche, android.R.layout.simple_spinner_item);
	        ArrayAdapter<CharSequence> adapter_combustible = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.tipos_de_combustible, android.R.layout.simple_spinner_item);
	        // Specify the layout to use when the list of choices appears
	        adapter_coche.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        adapter_combustible.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        // Apply the adapter to the spinner
	        spinner_coche.setAdapter(adapter_coche);
	        spinner_combustible.setAdapter(adapter_combustible);
			return view;
			
	}

}
