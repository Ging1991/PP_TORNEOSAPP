package com.caballero.torneos.negocios;

import java.util.List;

import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class Fichador {

	public static void crearJugador(String nombre, Equipo equipo) {
		Jugador jugador = new Jugador(-1, equipo.getID(), nombre);
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		obd.insert(jugador);
	}
	
	public static List<Equipo> traerEquipos() {
		EquipoDAO obd = FabricaDAO.crearEquipoOBD();
		return obd.select();
	}

	public static void borrarEquipo(Equipo equipo) {
		EquipoDAO obd = FabricaDAO.crearEquipoOBD();
		obd.delete(equipo);
	}

	public static List<Jugador> traerJugadores() {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		return obd.select();
	}

	public static void borrarJugador(Jugador jugador) {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		obd.delete(jugador);
	}

	public static void actualizarJugador(Jugador jugador) {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		obd.update(jugador);
	}

	public static Equipo traerEquipoSegunID(Integer id) {
		EquipoDAO obd = FabricaDAO.crearEquipoOBD();
		return obd.selectByID(id);
	}
	
	public static Jugador traerJugadorSegunID(Integer id) {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		return obd.selectByID(id);
	}
	
}