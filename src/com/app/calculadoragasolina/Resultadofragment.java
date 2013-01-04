package com.app.calculadoragasolina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Resultadofragment extends Fragment {
	
	View view = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.resultado, null);
			TextView resultado=(TextView) view.findViewById(R.id.resultado);
			TextView total=(TextView) view.findViewById(R.id.total);
			String result,valortotal;
   		   	result=Engine.show_resultado();
   		   	valortotal=Engine.show_total();
   		   	resultado.setText(result);
   		   	total.setText(valortotal);			
			return view; 
	}
	
	

}
