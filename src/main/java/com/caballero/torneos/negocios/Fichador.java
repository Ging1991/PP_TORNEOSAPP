package com.caballero.torneos.negocios;

import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class Fichador {

	public static void borrarEquipo(Equipo equipo) {
		EquipoDAO obd = FabricaDAO.crearEquipoOBD();
		obd.delete(equipo);
	}

	public static void borrarJugador(Jugador jugador) {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		obd.delete(jugador);
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