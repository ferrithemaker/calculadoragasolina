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
	public static int NUM_MUJERES=0;
	public static int NUM_HOMBRES=0;
	public static int NUM_NINOS=0;
	public static int KM=0;
	public static int CC=0;
	public static int PESO=0;
	public static float PEAJES=0;
	public static float CONSUMO=0;
	public static float PRECIO_GASOLINA=0;
	public static String calculo() {
		int peso_pasajeros=(NUM_MUJERES*55)*(NUM_HOMBRES*80)+(NUM_NINOS*30);
		int num_pasajeros=NUM_MUJERES+NUM_HOMBRES+NUM_NINOS;
		int peso_total=peso_pasajeros+PESO;
		float coste=0;
		String cadena_resultado;
		if (CONSUMO>0) { // calculamos en relación al consumo si el valor existe
			coste=((float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA)/(NUM_MUJERES+NUM_HOMBRES)+PEAJES/(NUM_MUJERES+NUM_HOMBRES);
		}
		cadena_resultado="Se ha realizado un trayecto de "+KM+" km con un coste total en gasolina de "+((float)((float)KM/100)*CONSUMO*PRECIO_GASOLINA)+" euros.\n\nEl coste en peajes es de "+PEAJES+" euros.\n\nCada uno de los "+(NUM_MUJERES+NUM_HOMBRES)+" viajeros (excluidos niños) debe pagar "+coste+" euros.";
		return cadena_resultado;
	}

}
