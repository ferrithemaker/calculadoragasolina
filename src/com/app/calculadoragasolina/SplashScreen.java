/*
    Copyright (C) 2012  Ferran F�bregas

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


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*display the splash screen image*/
		setContentView(R.layout.splash);
		/*start up the splash screen and main menu in a time delayed thread*/
		new Handler().postDelayed(new Thread() {
			@Override
			public void run() {
				Intent sim= new Intent(SplashScreen.this,Calculadora.class);
				SplashScreen.this.startActivity(sim);
				SplashScreen.this.finish();
			}
			}, 2500);
}
}