package com.app.calculadoragasolina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Peoplefragment extends Fragment {
	
	View view = null;
	EditText personas_edit,extras_edit;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.people, null);
			personas_edit = (EditText)view.findViewById(R.id.personas_edit);
			extras_edit = (EditText)view.findViewById(R.id.extras_edit);
			Button personas_update = (Button) view.findViewById(R.id.personas_update);
			personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
			extras_edit.setText(Float.toString(Engine.EXTRAS));
			personas_update.setOnClickListener(new Button.OnClickListener() {
		      	   public void onClick(View v) {
		      		 if (personas_edit.getText().toString().trim().equals("")==false) {
		    			   Engine.NUM_PASAJEROS=Integer.parseInt(personas_edit.getText().toString());  
		    		  } else {
		    			  personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
		    		  }
		      		if (extras_edit.getText().toString().trim().equals("")==false) {
		    			   Engine.EXTRAS=Float.parseFloat(extras_edit.getText().toString());
		    		  } else {
		    			  extras_edit.setText(Float.toString(Engine.EXTRAS));
		    		  }
		      		 
		      		
		      	   }
		         });
			return view; 
			
	}
	
	

}
