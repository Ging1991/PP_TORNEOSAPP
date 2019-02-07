package com.caballero.torneos.negocios;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class Organizador {
	
	public static void crearTorneo(String nombre, List<Jugador> jugadores) {
		TorneoDAO obd = FabricaDAO.crearTorneoDAO();
		Torneo torneo = new Torneo(-1, nombre, Almanaque.hoy(), EstadoTorneo.CURSO);
		obd.insert(torneo);
		//Integer torneoBDID = obd.selectUltimoID();
		//Torneo torneoDB = obd.selectByID(torneoBDID);
		//guardarParticipantes(torneoDB, jugadores);
	}
	
	public static void guardarParticipantes(Torneo torneo, List<Jugador> jugadores) {
		ParticipanteDAO obd = FabricaDAO.crearParticipanteDAO();
		for (Jugador jugador : jugadores)	
			obd.insert(new Participante(-1, torneo.getID(), jugador.getID(), 0));
	}
	
	public static List<Torneo> traerTorneos() {
		TorneoDAO obd = FabricaDAO.crearTorneoDAO();
		return obd.select();
	}

	public static void actualizarTorneo(Torneo torneo, List<Jugador> jugadores) {
		TorneoDAO obd = FabricaDAO.crearTorneoDAO();
		obd.update(torneo);;
	}

	public static List<Jugador> traerJugadoresParticipantes(Torneo torneo) {
		ServicioJugador sj = FabricaServicios.crearJugadorServicio();
		ServicioParticipante sp = FabricaServicios.crearServicioParticipante();
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for (Participante participante : sp.traer(torneo))
			jugadores.add(sj.traerPorID(participante.getJugador()));
		return jugadores;
	}
	
}