package com.caballero.torneos.negocios.interfaces;

import java.util.List;

import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface ServicioParticipante {
	
	public boolean agregar(Torneo torneo, Jugador jugador);
	
	public boolean eliminarParticipantes(Torneo torneo);

	public List<Participante> traer(Torneo torneo);

	public List<Participante> traerPorDerrotas(Torneo torneo, int derrotas);
		
}