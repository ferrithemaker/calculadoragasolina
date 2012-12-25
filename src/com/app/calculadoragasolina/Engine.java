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

public class Engine {
	public static int NUM_PASAJEROS=0;
	public static int KM=0;
	//public static int CC=0;
	//public static int PESO=0;
	public static float PEAJES=0;
	private static float CONSUMO=0;
	public static float PRECIO_GASOLINA=0;
	public static String TIPO_COCHE;
	public static String TIPO_RUTA;
	public static String TIPO_COMBUSTIBLE;
	public static String calculo() {
		//int peso_pasajeros=(NUM_MUJERES*55)*(NUM_HOMBRES*80)+(NUM_NINOS*30);
		//int num_pasajeros=NUM_PASAJEROS;
		//int peso_total=peso_pasajeros+PESO;
		float coste=0;
		String cadena_resultado;
		// definimos el tipo de coche
		if (TIPO_COCHE.equals("Utilitario")) {
			CONSUMO=(float)5.5;
		}
		if (TIPO_COCHE.equals("Turismo")) {
			CONSUMO=(float)6.5;
		}
		if (TIPO_COCHE.equals("Unifamiliar / Monovolumen")) {
			CONSUMO=(float)11;
		}
		if (TIPO_COCHE.equals("Berlina")) {
			CONSUMO=(float)7;
		}
		if (TIPO_COCHE.equals("Sedan")) {
			CONSUMO=(float)7.5;
		}
		if (TIPO_COCHE.equals("Deportivo")) {
			CONSUMO=(float)12;
		}
		if (TIPO_COCHE.equals("Todoterreno")) {
			CONSUMO=(float)12;
		}
		if (TIPO_COCHE.equals("Lujo")) {
			CONSUMO=(float)14;
		}
		
		// definimos el modificador en relacion al tipo de combustible
		if (TIPO_COMBUSTIBLE.equals("Gasolina")) {
			CONSUMO=CONSUMO*(float)1.1;
		}
		if (TIPO_COMBUSTIBLE.equals("Hibrido")) {
			CONSUMO=CONSUMO*(float)0.8;
		}
		// definimos el modificador en relacion al tipo de carretera
		if (TIPO_RUTA.equals("Urbana")) {
			CONSUMO=CONSUMO*(float)1.1;
		}
		if (TIPO_RUTA.equals("Interurbana")) {
			CONSUMO=CONSUMO*(float)0.9;
		}
		if (TIPO_RUTA.equals("Autopista")) {
			CONSUMO=CONSUMO*(float)0.85;
		}
		if (TIPO_RUTA.equals("Monta�a")) {
			CONSUMO=CONSUMO*(float)1.5;
		}
		if (TIPO_RUTA.equals("Mixta")) {
			CONSUMO=CONSUMO*(float)1;
		}
		// calculamos el consumo
		if (CONSUMO>0 && NUM_PASAJEROS>0) { // calculamos en relaci�n al consumo si el valor existe
			coste=((float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA)/(NUM_PASAJEROS)+PEAJES/(NUM_PASAJEROS);
		}
		cadena_resultado="Se ha realizado un trayecto de "+KM+" km por el tipo de ruta selccionada con un coste total en combustible de "+((float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA)+" euros.\n\nEl coste en peajes es de "+PEAJES+" euros.\n\nCada uno de los "+(NUM_PASAJEROS)+" viajeros debe pagar en total "+coste+" euros.";
		return cadena_resultado;
	}

}
