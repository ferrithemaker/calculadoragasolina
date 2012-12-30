/*
    Copyright (C) 2012  Ferran Fàbregas

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.app.calculadoragasolina;



import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class Calculadora extends Activity {
	TabHost tabs;
	EditText km_edit,peso_edit,personas_edit,mujeres_edit,ninos_edit,cc_edit,consumo_edit,peajes_edit,preciogasolina_edit;
	TextView resultado,total;
	Button coche_update,personas_update,ruta_update;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora);
		Resources res = getResources();
		// tab setup
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup(); 
        TabHost.TabSpec spec=tabs.newTabSpec("mytab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Resultados",res.getDrawable(android.R.drawable.ic_menu_gallery));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Vehículo",res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Vía",res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Pasajeros",res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("Ayuda",res.getDrawable(android.R.drawable.ic_menu_help));
        tabs.addTab(spec);
        // setup width and height of tabs
        //tabs.getTabWidget().getChildAt(0).setLayoutParams(new LinearLayout.LayoutParams(100, 100));
        tabs.setCurrentTab(4); // begin with help tab
        // begin setup UI layout
        coche_update = (Button) findViewById(R.id.coche_update);
        personas_update = (Button) findViewById(R.id.personas_update);
        ruta_update = (Button) findViewById(R.id.ruta_update);
        km_edit = (EditText)findViewById(R.id.kilometros_edit);
        personas_edit = (EditText)findViewById(R.id.personas_edit);
        peajes_edit = (EditText)findViewById(R.id.peajes_edit);
        preciogasolina_edit = (EditText)findViewById(R.id.preciogasolina_edit);
        km_edit.setText(Integer.toString(Engine.KM));
        personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
        peajes_edit.setText(Float.toString(Engine.PEAJES));
        preciogasolina_edit.setText(Float.toString(Engine.PRECIO_GASOLINA));
        resultado=(TextView) findViewById(R.id.resultado);
        total=(TextView) findViewById(R.id.total);
        Spinner spinner_coche = (Spinner) findViewById(R.id.tipo_coche);
        Spinner spinner_ruta = (Spinner) findViewById(R.id.tipo_ruta);
        Spinner spinner_combustible = (Spinner) findViewById(R.id.tipo_combustible);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_coche = ArrayAdapter.createFromResource(this,R.array.tipos_de_coche, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_ruta = ArrayAdapter.createFromResource(this,R.array.tipos_de_ruta, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_combustible = ArrayAdapter.createFromResource(this,R.array.tipos_de_combustible, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_coche.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_ruta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_combustible.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_coche.setAdapter(adapter_coche);
        spinner_ruta.setAdapter(adapter_ruta);
        spinner_combustible.setAdapter(adapter_combustible);
       

        coche_update.setOnClickListener(new Button.OnClickListener() {
     	   public void onClick(View v) {
     		  
     	   }
        });
        
        personas_update.setOnClickListener(new Button.OnClickListener() {
      	   public void onClick(View v) {
      		 if (personas_edit.getText().toString().trim().equals("")==false) {
    			   Engine.NUM_PASAJEROS=Integer.parseInt(personas_edit.getText().toString());
    		  } else {
    			  personas_edit.setText(Integer.toString(Engine.NUM_PASAJEROS));
    		  }
      	   }
         });
        
        ruta_update.setOnClickListener(new Button.OnClickListener() {
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
         });
        
        
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
        
        tabs.setOnTabChangedListener(new OnTabChangeListener() {

    		@Override
    		public void onTabChanged(String tabId) {

    		//int i = getTabHost().getCurrentTab();
    		if (tabId.equals("mytab1")) {
    			String result,valortotal;
       		   	result=Engine.show_resultado();
       		   	valortotal=Engine.show_total();
       		   	resultado.setText(result);
       		   	total.setText(valortotal);
    		}

    		 
    		}
    	});
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculadora, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menu_exit:
	        	finish();
	            break;
	    }
	    return true;
	}

}
