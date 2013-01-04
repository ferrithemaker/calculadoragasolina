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



import java.util.HashMap;
import java.util.Locale;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;


public class Calculadora extends FragmentActivity {
	TabHost tabs;
	EditText km_edit,peso_edit,personas_edit,mujeres_edit,ninos_edit,cc_edit,consumo_edit,peajes_edit,preciogasolina_edit;
	TextView resultado,total;
	Button coche_update,personas_update,ruta_update;
	private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, Calculadora.TabInfo>();
	ViewPager pager;
	Resultadofragment Rf;
	Carfragment Cf;
	Routefragment Routf;
	Peoplefragment Pf;
	Helpfragment Hf;

	private class TabInfo {
		private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;
        TabInfo(String tag, Class<?> clazz, Bundle args) {
       	 this.tag = tag;
       	 this.clss = clazz;
       	 this.args = args;
        }

	}
	/**
	 * A simple factory that returns dummy views to the Tabhost
	 * @author mwho
	 */
	class TabFactory implements TabContentFactory {

		private final Context mContext;

	    /**
	     * @param context
	     */
	    public TabFactory(Context context) {
	        mContext = context;
	    }

	    /** (non-Javadoc)
	     * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
	     */
	    public View createTabContent(String tag) {
	        View v = new View(mContext);
	        v.setMinimumWidth(0);
	        v.setMinimumHeight(0);
	        return v;
	    }

	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora);
		Resources res = getResources();
		// configuracion del idioma
		Engine.idioma=Locale.getDefault().getLanguage();
		//tab setup
        
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabInfo tabInfo = null;
        Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab1").setIndicator("Resultados"), ( tabInfo = new TabInfo("Tab1", Resultadofragment.class, savedInstanceState)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab2").setIndicator("Vehiculo"), ( tabInfo = new TabInfo("Tab2", Carfragment.class, savedInstanceState)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab3").setIndicator("Trayecto"), ( tabInfo = new TabInfo("Tab3", Routefragment.class, savedInstanceState)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab4").setIndicator("Pasajeros"), ( tabInfo = new TabInfo("Tab4", Peoplefragment.class, savedInstanceState)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab5").setIndicator("Ayuda"), ( tabInfo = new TabInfo("Tab5", Helpfragment.class, savedInstanceState)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        //tabs.setOnTabChangedListener(this);

        //TabHost.TabSpec spec=tabs.newTabSpec("mytab1");
		// pager setup
		pager = (ViewPager) findViewById(R.id.viewpager);
        MyFragmentsAdapter adapter = new MyFragmentsAdapter(getSupportFragmentManager());
        Rf= new Resultadofragment();
        Cf = new Carfragment();
        Routf =  new Routefragment();
        Pf =  new Peoplefragment();
        Hf = new Helpfragment();
        adapter.addFragment(Rf);
        adapter.addFragment(Cf);
        adapter.addFragment(Routf);
        adapter.addFragment(Pf);
        adapter.addFragment(Hf);
        pager.setAdapter(adapter);
        
        // action bar setup
		//tab setup
        
        //tabs=(TabHost)findViewById(android.R.id.tabhost);
        //tabs.setup(); 
        //TabHost.TabSpec spec=tabs.newTabSpec("mytab1");
        //spec.setContent(R.layout.resultado);
        //if (Engine.idioma.equals("es")) {
        //	spec.setIndicator("   Resultado   ",res.getDrawable(android.R.drawable.ic_menu_gallery));
        //} else {
        //	spec.setIndicator("   Results   ",res.getDrawable(android.R.drawable.ic_menu_gallery));
        //}
        //tabs.addTab(spec);
        /*
        spec=tabs.newTabSpec("mytab2");
        spec.setContent(R.layout.car);
        if (Engine.idioma.equals("es")) {
        	spec.setIndicator("   Vehículo   ",res.getDrawable(android.R.drawable.ic_menu_edit));
        } else {
        	spec.setIndicator("   Vehicle   ",res.getDrawable(android.R.drawable.ic_menu_edit));
        }
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab3");
        spec.setContent(R.layout.route);
        if (Engine.idioma.equals("es")) {
        	spec.setIndicator("   Trayecto   ",res.getDrawable(android.R.drawable.ic_menu_edit));
        } else {
        	spec.setIndicator("   Route   ",res.getDrawable(android.R.drawable.ic_menu_edit));
        }
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab4");
        spec.setContent(R.layout.people);
        if (Engine.idioma.equals("es")) {
        	spec.setIndicator("   Pasajeros   ",res.getDrawable(android.R.drawable.ic_menu_edit));
        } else {
        	spec.setIndicator("   Passengers   ",res.getDrawable(android.R.drawable.ic_menu_edit));
        }
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mytab5");
        spec.setContent(R.layout.help);
        if (Engine.idioma.equals("es")) {
        	spec.setIndicator("Ayuda",res.getDrawable(android.R.drawable.ic_menu_help));
        } else {
        	spec.setIndicator("Help",res.getDrawable(android.R.drawable.ic_menu_help));
        }
        tabs.addTab(spec);
        */
        //tabs.setCurrentTab(4); // begin with help tab

        // begin setup UI layout
        
        pager.setOnPageChangeListener(new OnPageChangeListener() {
        	@Override
            public void onPageSelected(int position)
            {
        		tabs.setCurrentTab(position);
            }

        	@Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageScrollStateChanged(int arg0) {}
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
    		int pos=tabs.getCurrentTab();
    		pager.setCurrentItem(pos);

    		 
    		}
    	});
	
	}
	
	private static void AddTab(Calculadora activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
		// Attach a Tab view factory to the spec
		tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
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
