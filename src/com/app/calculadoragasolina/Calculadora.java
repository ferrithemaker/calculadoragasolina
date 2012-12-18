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

import com.example.calculadoragasolina.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Calculadora extends Activity {
	TabHost tabs;
	EditText km_edit,peso_edit,hombres_edit,mujeres_edit,ninos_edit,cc_edit,consumo_edit,peajes_edit;
	TextView km_txt,peso_txt,hombres_txt,mujeres_txt,ninos_txt,cc_txt,consumo_txt,peajes_txt;
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculadora, menu);
		return true;
	}

}
