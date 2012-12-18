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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Calculadora extends Activity {
	TabHost tabs;
	EditText km_edit,peso_edit,hombres_edit,mujeres_edit,ninos_edit,cc_edit,consumo_edit,peajes_edit,preciogasolina_edit;
	TextView resultado;
	Button coche_update,personas_update,ruta_update,calcular;
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
        spec.setIndicator("Coche",res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Ruta",res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Personas",res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("Ayuda",res.getDrawable(android.R.drawable.ic_menu_help));
        tabs.addTab(spec);
        // setup width and height of tabs
        //tabs.getTabWidget().getChildAt(0).setLayoutParams(new LinearLayout.LayoutParams(100, 100));
        tabs.setCurrentTab(5); // begin with help tab
        // begin setup UI layout
        coche_update = (Button) findViewById(R.id.coche_update);
        personas_update = (Button) findViewById(R.id.personas_update);
        ruta_update = (Button) findViewById(R.id.ruta_update);
        calcular = (Button) findViewById(R.id.boton_calcular);
        km_edit = (EditText)findViewById(R.id.kilometros_edit);
        peso_edit = (EditText)findViewById(R.id.coche_peso_edit);
        cc_edit = (EditText)findViewById(R.id.coche_consumo_edit);
        hombres_edit = (EditText)findViewById(R.id.hombres_edit);
        mujeres_edit = (EditText)findViewById(R.id.mujeres_edit);
        ninos_edit = (EditText)findViewById(R.id.ninos_edit);
        consumo_edit = (EditText)findViewById(R.id.coche_consumo_edit);
        peajes_edit = (EditText)findViewById(R.id.peajes_edit);
        preciogasolina_edit = (EditText)findViewById(R.id.preciogasolina_edit);
        km_edit.setText(Integer.toString(Engine.KM));
        peso_edit.setText(Integer.toString(Engine.PESO));
        cc_edit.setText(Integer.toString(Engine.CC));
        hombres_edit.setText(Integer.toString(Engine.NUM_HOMBRES));
        mujeres_edit.setText(Integer.toString(Engine.NUM_MUJERES));
        ninos_edit.setText(Integer.toString(Engine.NUM_NINOS));
        consumo_edit.setText(Integer.toString(Engine.CONSUMO));
        peajes_edit.setText(Integer.toString(Engine.PEAJES));
        preciogasolina_edit.setText(Integer.toString(Engine.PRECIO_GASOLINA));
        resultado=(TextView) findViewById(R.id.resultado);
        
	
        coche_update.setOnClickListener(new Button.OnClickListener() {
     	   public void onClick(View v) {
     		  if (cc_edit.getText().toString().trim().equals("")==false) {
      			   Engine.CC=Integer.parseInt(cc_edit.getText().toString());
      		  } else {
      			cc_edit.setText(Integer.toString(Engine.CC));
      		  }
      		  if (peso_edit.getText().toString().trim().equals("")==false) {
      			  Engine.PESO=Integer.parseInt(peso_edit.getText().toString());
      		  } else {
      			peso_edit.setText(Integer.toString(Engine.PESO));
      		  }
      		  if (consumo_edit.getText().toString().trim().equals("")==false) {
      			  Engine.CONSUMO=Integer.parseInt(consumo_edit.getText().toString());
      		  } else {
      			consumo_edit.setText(Integer.toString(Engine.CONSUMO));
      		  }
     	   }
        });
        
        personas_update.setOnClickListener(new Button.OnClickListener() {
      	   public void onClick(View v) {
      		 if (hombres_edit.getText().toString().trim().equals("")==false) {
    			   Engine.NUM_HOMBRES=Integer.parseInt(hombres_edit.getText().toString());
    		  } else {
    			  hombres_edit.setText(Integer.toString(Engine.NUM_MUJERES));
    		  }
    		  if (mujeres_edit.getText().toString().trim().equals("")==false) {
    			  Engine.NUM_MUJERES=Integer.parseInt(mujeres_edit.getText().toString());
    		  } else {
    			  mujeres_edit.setText(Integer.toString(Engine.PESO));
    		  }
    		  if (ninos_edit.getText().toString().trim().equals("")==false) {
    			  Engine.NUM_NINOS=Integer.parseInt(ninos_edit.getText().toString());
    		  } else {
    			  ninos_edit.setText(Integer.toString(Engine.NUM_NINOS));
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
      			 Engine.PEAJES=Integer.parseInt(peajes_edit.getText().toString());
      		 } else {
      			peajes_edit.setText(Integer.toString(Engine.PEAJES));
      		 }
      		if (preciogasolina_edit.getText().toString().trim().equals("")==false) {
     			 Engine.PRECIO_GASOLINA=Integer.parseInt(preciogasolina_edit.getText().toString());
     		 } else {
     			preciogasolina_edit.setText(Integer.toString(Engine.PRECIO_GASOLINA));
     		 }
      		  
      	   }
         });
        
        calcular.setOnClickListener(new Button.OnClickListener() {
      	   public void onClick(View v) {
      		   int valor;
      		   valor=Engine.calculo();
      		   resultado.setText("Cada pasajero debe pagar: "+valor+" euros.");
      	   }
         });
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculadora, menu);
		return true;
	}

}
