package com.caballero.torneos.negocios;

import java.util.List;

import com.caballero.torneos.persistencia.FabricaOBD;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;
import com.caballero.torneos.persistencia.interfaces.JugadorOBD;

public class Fichador {

	public static void crearJugador(String nombre, Equipo equipo) {
		Jugador jugador = new Jugador(-1, equipo.getID(), nombre);
		JugadorOBD obd = FabricaOBD.crearJugadorOBD();
		obd.insert(jugador);
	}
	
	public static List<Equipo> traerEquipos() {
		EquipoOBD obd = FabricaOBD.crearEquipoOBD();
		return obd.select();
	}

	public static void borrarEquipo(Equipo equipo) {
		EquipoOBD obd = FabricaOBD.crearEquipoOBD();
		obd.delete(equipo);
	}

	public static List<Jugador> traerJugadores() {
		JugadorOBD obd = FabricaOBD.crearJugadorOBD();
		return obd.select();
	}

	public static void borrarJugador(Jugador jugador) {
		JugadorOBD obd = FabricaOBD.crearJugadorOBD();
		obd.delete(jugador);
	}

	public static void actualizarJugador(Jugador jugador) {
		JugadorOBD obd = FabricaOBD.crearJugadorOBD();
		obd.update(jugador);
	}

	public static Equipo traerEquipoSegunID(Integer id) {
		EquipoOBD obd = FabricaOBD.crearEquipoOBD();
		return obd.selectByID(id);
	}
	
	public static Jugador traerJugadorSegunID(Integer id) {
		JugadorOBD obd = FabricaOBD.crearJugadorOBD();
		return obd.selectByID(id);
	}
	
}