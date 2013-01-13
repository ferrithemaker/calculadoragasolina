package com.app.calculadoragasolina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MotionEvent;

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
			personas_edit.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		        	personas_edit.setText("");
		            return false; // return is important...
		        }
		    });
			/*personas_edit.addTextChangedListener(new TextWatcher() {
                    public void  afterTextChanged (Editable s){ 
                            //Log.d("seachScreen", "afterTextChanged");
                    	if (personas_edit.getText().toString().trim().equals("")==false) {
                        	Engine.NUM_PASAJEROS=Integer.parseInt(personas_edit.getText().toString());  
     		    		} else {
     		    			personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
     		    		}
                    } 
                    public void  beforeTextChanged  (CharSequence s, int start, int count, int after)
                    { 
                            //Log.d("seachScreen", "beforeTextChanged"); 
                    } 
                    public void  onTextChanged  (CharSequence s, int start, int before,  int count) 
                    { 
                            //Log.d("seachScreen", s.toString());
                    
                    }
			}); */
			extras_edit.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		        	extras_edit.setText("");
		            return false; // return is important...
		        }
		    });
			return view; 
			
	}
	
	

}
