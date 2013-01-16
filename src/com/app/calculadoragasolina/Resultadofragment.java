package com.app.calculadoragasolina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Resultadofragment extends Fragment {
	
	View view = null;
	String result,valortotal;
	Button calculfinal;
	TextView resultado,total;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.resultado, null);
			resultado=(TextView) view.findViewById(R.id.resultado);
			total=(TextView) view.findViewById(R.id.total);
			calculfinal=(Button) view.findViewById(R.id.calcular_resultado);
   		   	result=Engine.show_resultado();
   		   	valortotal=Engine.show_total();
   		   	resultado.setText(result);
   		   	total.setText(valortotal);
   		 calculfinal.setOnClickListener(new Button.OnClickListener() {
	       	   public void onClick(View v) {
	       		String result,valortotal;
       		   	result=Engine.show_resultado();
       		   	valortotal=Engine.show_total();
       		   	resultado.setText(result);
       		   	total.setText(valortotal);
	       	   }
	          });
			return view; 
	}
	
	

}
