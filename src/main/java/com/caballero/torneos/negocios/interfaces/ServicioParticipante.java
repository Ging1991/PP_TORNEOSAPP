package com.caballero.torneos.negocios.interfaces;

import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface ServicioParticipante {
	
	public boolean agregar(Torneo torneo, Jugador jugador);
		
}