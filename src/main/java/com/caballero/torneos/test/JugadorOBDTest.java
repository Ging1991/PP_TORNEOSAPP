package com.caballero.torneos.test;

import java.util.List;

import com.caballero.torneos.persistencia.Factory;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.JugadorOBD;

public class JugadorOBDTest {
	
	public static void insertTest(String nombre, Equipo equipo) {
		System.out.println("___ Insert Test: "+nombre);
		JugadorOBD obd = Factory.crearJugadorOBD();
		obd.insert(new Jugador(-1, equipo.getID(), nombre));
	}
	
	public static void selectTest() {
		System.out.println("___ Select test");
		JugadorOBD obd = Factory.crearJugadorOBD();
		List<Jugador> jugadores = obd.select();
		System.out.println("Cantidad: "+jugadores.size());
		for (Jugador jugador: jugadores)
			System.out.println(jugador.getNombre());
	}
	
	public static void main(String[] args) {
		Equipo equipo = new Equipo(1, "Equipo");
		insertTest("Jorge", equipo);
		selectTest();
	}

}