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

public class Engine {
	public static int NUM_PASAJEROS=1;
	public static int KM=0;
	public static float PEAJES=0;
	private static float CONSUMO=0;
	public static float PRECIO_GASOLINA=0;
	public static String TIPO_COCHE="Utilitario";
	public static String TIPO_RUTA="Urbana";
	public static String TIPO_COMBUSTIBLE="Gasolina";
	public static String calculo() {
		float coste=0;
		String cadena_resultado;
		// definimos el tipo de coche
		if (TIPO_COCHE.equals("Utilitario")) {
			CONSUMO=(float)5.5;
		}
		if (TIPO_COCHE.equals("Compacto")) {
			CONSUMO=(float)7.5;
		}
		if (TIPO_COCHE.equals("Unifamiliar / Monovolumen")) {
			CONSUMO=(float)11;
		}
		if (TIPO_COCHE.equals("Berlina")) {
			CONSUMO=(float)8.5;
		}
		if (TIPO_COCHE.equals("Sedan")) {
			CONSUMO=(float)10;
		}
		if (TIPO_COCHE.equals("Deportivo")) {
			CONSUMO=(float)13;
		}
		if (TIPO_COCHE.equals("Todoterreno")) {
			CONSUMO=(float)13;
		}
		if (TIPO_COCHE.equals("Lujo")) {
			CONSUMO=(float)15;
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
			CONSUMO=CONSUMO*(float)1.2;
		}
		if (TIPO_RUTA.equals("Interurbana")) {
			CONSUMO=CONSUMO*(float)0.9;
		}
		if (TIPO_RUTA.equals("Autopista")) {
			CONSUMO=CONSUMO*(float)0.85;
		}
		if (TIPO_RUTA.equals("Montaña")) {
			CONSUMO=CONSUMO*(float)1.5;
		}
		if (TIPO_RUTA.equals("Mixta")) {
			CONSUMO=CONSUMO*(float)1;
		}
		// calculamos el consumo
		if (CONSUMO>0 && NUM_PASAJEROS>0) { // calculamos en relación al consumo si el valor existe
			coste=(float)Math.round(100*(((float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA)/(NUM_PASAJEROS)+PEAJES/(NUM_PASAJEROS)))/100;
		}
		cadena_resultado="Se ha realizado un trayecto de "+KM+" km por el tipo de ruta selccionada con un coste total en combustible de "+(float)(Math.round(100*(float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA))/100+" euros.\n\nEl coste en peajes es de "+PEAJES+" euros.\n\nEl coste total del viaje es de "+(float)Math.round(100*(PEAJES+((float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA)))/100+" y cada uno de los "+(NUM_PASAJEROS)+" viajeros debe pagar en total "+(coste)+" euros.\n\nNOTA: Recuerde que estos valores son aproximados y solo se proporcionan a modo de orientación.";
		return cadena_resultado;
	}

}
