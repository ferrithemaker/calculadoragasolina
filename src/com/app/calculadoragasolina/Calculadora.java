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
import android.widget.HorizontalScrollView;
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
	MyFragmentsAdapter adapter;
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
		
		final HorizontalScrollView mHorizontalScrollView;
	    float scale = getResources().getDisplayMetrics().density;
	    final double tabWidth = (int) (150 * scale + 0.5f);

	    
		
		//tab setup
        
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabInfo tabInfo = null;
        if (Engine.idioma.equals("es")) {
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab1").setIndicator("    Resultados    "), ( tabInfo = new TabInfo("Tab1", Resultadofragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab2").setIndicator("    Vehículo    "), ( tabInfo = new TabInfo("Tab2", Carfragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab3").setIndicator("    Trayecto    "), ( tabInfo = new TabInfo("Tab3", Routefragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab4").setIndicator("    Pasajeros    "), ( tabInfo = new TabInfo("Tab4", Peoplefragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab5").setIndicator("Ayuda"), ( tabInfo = new TabInfo("Tab5", Helpfragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        } else {
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab1").setIndicator("    Results    "), ( tabInfo = new TabInfo("Tab1", Resultadofragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab2").setIndicator("    Vehicle    "), ( tabInfo = new TabInfo("Tab2", Carfragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab3").setIndicator("    Route    "), ( tabInfo = new TabInfo("Tab3", Routefragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab4").setIndicator("    Passengers    "), ( tabInfo = new TabInfo("Tab4", Peoplefragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        	Calculadora.AddTab(this, tabs, this.tabs.newTabSpec("Tab5").setIndicator("Help"), ( tabInfo = new TabInfo("Tab5", Helpfragment.class, savedInstanceState)));
        	this.mapTabInfo.put(tabInfo.tag, tabInfo);
        }
        // amb aixo ens preparem per centrar els tabs
        for (int i = 0; i < tabs.getTabWidget().getTabCount(); i++) {
	        tabs.getTabWidget().getChildTabViewAt(i).getLayoutParams().width = (int) tabWidth;
	    }

	    final double screenWidth = getWindowManager().getDefaultDisplay().getWidth();
	    mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.hscroll);

        
		// pager setup
		pager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new MyFragmentsAdapter(getSupportFragmentManager());
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
        //adapter.notifyDataSetChanged();
        
        //pager.setCurrentItem(4);
        //tabs.setCurrentTab(4); // begin with help tab

        
        
        pager.setOnPageChangeListener(new OnPageChangeListener() {
        	@Override
            public void onPageSelected(int position)
            {
        		//adapter.notifyDataSetChanged();
        		//Engine.calculo();
        		tabs.setCurrentTab(position);
            }

        	@Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
        		//adapter.notifyDataSetChanged();
        		//Engine.calculo();
        	}
            @Override
            public void onPageScrollStateChanged(int arg0) {
            	//adapter.notifyDataSetChanged();
            	//Engine.calculo();
            }
         });
   
         
        tabs.setOnTabChangedListener(new OnTabChangeListener() {

    		@Override
    		public void onTabChanged(String tabId) {

    		//int i = getTabHost().getCurrentTab();
    		/*if (tabId.equals("Tab1")) {
    			String result,valortotal;
       		   	result=Engine.show_resultado();
       		   	valortotal=Engine.show_total();
       		   	resultado.setText(result);
       		   	total.setText(valortotal);
    		} */
    		int pos=tabs.getCurrentTab();
    		pager.setCurrentItem(pos);
    		int nrOfShownCompleteTabs = ((int) (Math.floor(screenWidth / tabWidth) - 1) / 2) * 2;
            int remainingSpace = (int) ((screenWidth - tabWidth - (tabWidth * nrOfShownCompleteTabs)) / 2);
            int a = (int) (tabs.getCurrentTab() * tabWidth);
            int b = (int) ((int) (nrOfShownCompleteTabs / 2) * tabWidth);
            int offset = (a - b) - remainingSpace;
            mHorizontalScrollView.scrollTo(offset, 0);
            //Engine.calculo();
            //adapter.notifyDataSetChanged();
    		 
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
