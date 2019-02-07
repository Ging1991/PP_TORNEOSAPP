package com.caballero.torneos.negocios.interfaces;

import java.util.List;

import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface ServicioTorneo {
	
	public Torneo traerUltimo();

	public Boolean agregar(String nombre, List<Jugador> lista);
	
	public boolean cancelar(Torneo torneo);
	
	public boolean generarFixture(Torneo torneo);
	
}