package com.caballero.torneos.negocios;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.FabricaOBD;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteOBD;
import com.caballero.torneos.persistencia.interfaces.TorneoOBD;

public class Organizador {
	
	public static void crearTorneo(String nombre, List<Jugador> jugadores) {
		TorneoOBD obd = FabricaOBD.crearTorneoOBD();
		Torneo torneo = new Torneo(-1, nombre, Almanaque.hoy(), EstadoTorneo.CREADO);
		obd.insert(torneo);
		Integer torneoBDID = obd.selectUltimoID();
		Torneo torneoDB = obd.selectByID(torneoBDID);
		guardarParticipantes(torneoDB, jugadores);
	}
	
	public static void guardarParticipantes(Torneo torneo, List<Jugador> jugadores) {
		ParticipanteOBD obd = FabricaOBD.crearParticipanteOBD();
		for (Jugador jugador : jugadores)	
			obd.insert(new Participante(-1, torneo.getID(), jugador.getID(), 0));
	}
	
	public static List<Torneo> traerTorneos() {
		TorneoOBD obd = FabricaOBD.crearTorneoOBD();
		return obd.select();
	}

	public static void borrarTorneo(Torneo torneo) {
		TorneoOBD obd = FabricaOBD.crearTorneoOBD();
		obd.delete(torneo);
	}

	public static void actualizarTorneo(Torneo torneo, List<Jugador> jugadores) {
		TorneoOBD obd = FabricaOBD.crearTorneoOBD();
		obd.update(torneo);;
	}

	public static List<Participante> traerParticipantes(Torneo torneo) {
		ParticipanteOBD obd = FabricaOBD.crearParticipanteOBD();
		return obd.selectByTorneo(torneo);
	}
	
	public static List<Jugador> traerJugadoresParticipantes(Torneo torneo) {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for (Participante participante : traerParticipantes(torneo))
			jugadores.add(Fichador.traerJugadorSegunID(participante.getJugador()));
		return jugadores;
	}
	
}