package com.caballero.torneos.negocios;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class Organizador {
	
	public static void crearTorneo(String nombre, List<Jugador> jugadores) {
		TorneoDAO obd = FabricaDAO.crearTorneoOBD();
		Torneo torneo = new Torneo(-1, nombre, Almanaque.hoy(), EstadoTorneo.CURSO);
		obd.insert(torneo);
		//Integer torneoBDID = obd.selectUltimoID();
		//Torneo torneoDB = obd.selectByID(torneoBDID);
		//guardarParticipantes(torneoDB, jugadores);
	}
	
	public static void guardarParticipantes(Torneo torneo, List<Jugador> jugadores) {
		ParticipanteDAO obd = FabricaDAO.crearParticipanteOBD();
		for (Jugador jugador : jugadores)	
			obd.insert(new Participante(-1, torneo.getID(), jugador.getID(), 0));
	}
	
	public static List<Torneo> traerTorneos() {
		TorneoDAO obd = FabricaDAO.crearTorneoOBD();
		return obd.select();
	}

	public static void borrarTorneo(Torneo torneo) {
		TorneoDAO obd = FabricaDAO.crearTorneoOBD();
		obd.delete(torneo);
	}

	public static void actualizarTorneo(Torneo torneo, List<Jugador> jugadores) {
		TorneoDAO obd = FabricaDAO.crearTorneoOBD();
		obd.update(torneo);;
	}

	public static List<Participante> traerParticipantes(Torneo torneo) {
		ParticipanteDAO obd = FabricaDAO.crearParticipanteOBD();
		return obd.selectByTorneo(torneo);
	}
	
	public static List<Jugador> traerJugadoresParticipantes(Torneo torneo) {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for (Participante participante : traerParticipantes(torneo))
			jugadores.add(Fichador.traerJugadorSegunID(participante.getJugador()));
		return jugadores;
	}
	
}