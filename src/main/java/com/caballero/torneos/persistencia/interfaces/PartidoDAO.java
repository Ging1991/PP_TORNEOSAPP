package com.caballero.torneos.persistencia.interfaces;

import java.util.List;

import com.caballero.torneos.persistencia.definidos.EstadoPartido;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface PartidoDAO  extends CRUD<Partido>{
	
	public List<Partido> selectByTorneoEstado(Torneo torneo, EstadoPartido estado);
	
	public List<Partido> selectByTorneo(Torneo torneo);
	
}