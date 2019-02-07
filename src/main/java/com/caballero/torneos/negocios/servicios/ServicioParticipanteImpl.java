package com.caballero.torneos.negocios.servicios;

import java.util.List;

import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;

public class ServicioParticipanteImpl implements ServicioParticipante {
	private ParticipanteDAO participanteDAO;
	
	public ServicioParticipanteImpl(ParticipanteDAO participanteDAO) {
		this.participanteDAO = participanteDAO;
	}

	@Override
	public boolean agregar(Torneo torneo, Jugador jugador) {
		Participante participante = new Participante(-1, torneo.getID(), jugador.getID(), 0);
		participanteDAO.insert(participante);
		return true;
	}

	@Override
	public boolean eliminarParticipantes(Torneo torneo) {
		List<Participante> participantes = traer(torneo);
		for (Participante participante : participantes)
			participanteDAO.delete(participante);
		
		return true;
	}

	@Override
	public List<Participante> traer(Torneo torneo) {
		return participanteDAO.selectByTorneo(torneo);
	}

	@Override
	public List<Participante> traerPorDerrotas(Torneo torneo, int derrotas) {
		return participanteDAO.selectByTorneoDerrotas(torneo, derrotas);
	}

}