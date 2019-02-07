package com.caballero.torneos.persistencia.interfaces;

import java.util.List;

import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface ParticipanteDAO  extends CRUD<Participante> {
	
	public List<Participante> selectByTorneo(Torneo torneo);

	public List<Participante> selectByTorneoDerrotas(Torneo torneo, int derrotas);

}