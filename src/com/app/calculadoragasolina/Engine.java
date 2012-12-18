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
	public static int PEAJES=0;
	public static int CONSUMO=0;
	public static int PRECIO_GASOLINA=0;
	public static int calculo() {
		int peso_pasajeros=(NUM_MUJERES*55)*(NUM_HOMBRES*80)+(NUM_NINOS*30);
		int num_pasajeros=NUM_MUJERES+NUM_HOMBRES+NUM_NINOS;
		int peso_total=peso_pasajeros+PESO;
		int coste=((KM/100)*CONSUMO*PRECIO_GASOLINA)/(NUM_MUJERES+NUM_HOMBRES)+PEAJES/(NUM_MUJERES+NUM_HOMBRES);
		return coste;
	}

}
