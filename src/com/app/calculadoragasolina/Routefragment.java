package com.app.calculadoragasolina;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Routefragment extends Fragment {
	
	View view = null;
	EditText km_edit,peajes_edit,preciogasolina_edit;
	LinearLayout pestanya;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.route, null);
			km_edit = (EditText) view.findViewById(R.id.kilometros_edit);
			peajes_edit = (EditText)view.findViewById(R.id.peajes_edit);
			preciogasolina_edit = (EditText)view.findViewById(R.id.preciogasolina_edit);
			Spinner spinner_ruta = (Spinner) view.findViewById(R.id.tipo_ruta);
			Spinner spinner_unidades = (Spinner) view.findViewById(R.id.units);
			km_edit.setText(Integer.toString(Engine.KM));
			peajes_edit.setText(Float.toString(Engine.PEAJES));
			preciogasolina_edit.setText(Float.toString(Engine.PRECIO_GASOLINA));
	        ArrayAdapter<CharSequence> adapter_ruta = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.tipos_de_ruta, android.R.layout.simple_spinner_item);
	        ArrayAdapter<CharSequence> adapter_unidades = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.unidades, android.R.layout.simple_spinner_item);
	        adapter_ruta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        adapter_unidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
	        spinner_ruta.setAdapter(adapter_ruta);
	        spinner_unidades.setAdapter(adapter_unidades);
	        //Button ruta_update = (Button) view.findViewById(R.id.ruta_update);
	        
	        
	        /*ruta_update.setOnClickListener(new Button.OnClickListener() {
	       	   public void onClick(View v) {
	       		 if (km_edit.getText().toString().trim().equals("")==false) {
	       			 Engine.KM=Integer.parseInt(km_edit.getText().toString());
	       		 } else {
	       			km_edit.setText(Integer.toString(Engine.KM));
	       		 }
	       		 if (peajes_edit.getText().toString().trim().equals("")==false) {
	       			 Engine.PEAJES=Float.parseFloat(peajes_edit.getText().toString());
	       		 } else {
	       			peajes_edit.setText(Float.toString(Engine.PEAJES));
	       		 }
	       		if (preciogasolina_edit.getText().toString().trim().equals("")==false) {
	      			 Engine.PRECIO_GASOLINA=Float.parseFloat(preciogasolina_edit.getText().toString());
	      		 } else {
	      			preciogasolina_edit.setText(Float.toString(Engine.PRECIO_GASOLINA));
	      		 }
	       		  
	       	   }
	          }); */
	        spinner_ruta.setOnItemSelectedListener(new OnItemSelectedListener() {

	            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	                Engine.TIPO_RUTA= parentView.getSelectedItem().toString();
	                //your code here
	            }

	            public void onNothingSelected(AdapterView<?> parentView) {
	                //selectedyear = 0;
	                //return;
	            }
	        });
	        spinner_unidades.setOnItemSelectedListener(new OnItemSelectedListener() {

	            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	                Engine.unidades= parentView.getSelectedItem().toString();
	                //your code here
	            }

	            public void onNothingSelected(AdapterView<?> parentView) {
	                //selectedyear = 0;
	                //return;
	            }
	        });
	        km_edit.addTextChangedListener(new TextWatcher() {
                public void  afterTextChanged (Editable s){ 
                        //Log.d("seachScreen", "afterTextChanged");
                	if (km_edit.getText().toString().trim().equals("")==false) {
                    	Engine.KM=Integer.parseInt(km_edit.getText().toString());
                    	//personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
 		    		} else {
 		    			Engine.KM=0;
 		    			//personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
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
	        });
	        peajes_edit.addTextChangedListener(new TextWatcher() {
                public void  afterTextChanged (Editable s){ 
                        //Log.d("seachScreen", "afterTextChanged");
                	if (peajes_edit.getText().toString().trim().equals("")==false) {
                    	Engine.PEAJES=Float.parseFloat(peajes_edit.getText().toString());
                    	//personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
 		    		} else {
 		    			Engine.PEAJES=(float)0;
 		    			//personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
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
	        });
	        preciogasolina_edit.addTextChangedListener(new TextWatcher() {
                public void  afterTextChanged (Editable s){ 
                        //Log.d("seachScreen", "afterTextChanged");
                	if (preciogasolina_edit.getText().toString().trim().equals("")==false) {
                    	Engine.PRECIO_GASOLINA=Float.parseFloat(preciogasolina_edit.getText().toString());
                    	//personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
 		    		} else {
 		    			Engine.PRECIO_GASOLINA=(float)0;
 		    			//personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
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
	        });
	        
	        /*km_edit.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		        	km_edit.setText("");
		            return false; // return is important...
		        }
		    });
	        peajes_edit.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		        	peajes_edit.setText("");
		            return false; // return is important...
		        }
		    });
	        preciogasolina_edit.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		        	preciogasolina_edit.setText("");
		            return false; // return is important...
		        }
		    }); */
			return view; 
	}
}
