package com.caballero.torneos.negocios;

import java.util.List;

import com.caballero.torneos.persistencia.Factory;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;
import com.caballero.torneos.persistencia.interfaces.JugadorOBD;

public class Fichador {

	public static void crearJugador(String nombre, Equipo equipo) {
		Jugador jugador = new Jugador(-1, equipo.getID(), nombre);
		JugadorOBD obd = Factory.crearJugadorOBD();
		obd.insert(jugador);
	}
	
	public static List<Equipo> traerEquipos() {
		EquipoOBD obd = Factory.crearEquipoOBD();
		return obd.select();
	}

	public static void borrarEquipo(Equipo equipo) {
		EquipoOBD obd = Factory.crearEquipoOBD();
		obd.delete(equipo);
	}

	public static List<Jugador> traerJugadores() {
		JugadorOBD obd = Factory.crearJugadorOBD();
		return obd.select();
	}

	public static void borrarJugador(Jugador jugador) {
		JugadorOBD obd = Factory.crearJugadorOBD();
		obd.delete(jugador);
	}

	public static void actualizarJugador(Jugador jugador) {
		JugadorOBD obd = Factory.crearJugadorOBD();
		obd.update(jugador);
	}

	public static Equipo traerEquipoSegunID(Integer id) {
		EquipoOBD obd = Factory.crearEquipoOBD();
		return obd.selectByID(id);
	}
	
	public static Jugador traerJugadorSegunID(Integer id) {
		JugadorOBD obd = Factory.crearJugadorOBD();
		return obd.selectByID(id);
	}
	
}