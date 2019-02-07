package com.caballero.torneos.negocios.interfaces;

import java.util.List;

import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface ServicioPartido {

	public boolean eliminarPartido(Partido partido);
	
	public Partido traerUltimo();
	
	public boolean eliminarPartidosPendientes(Torneo torneo);
	
	public List<Partido> traerPartidosPendientes(Torneo torneo);
	
	public boolean eliminarPartidos(Torneo torneo);
	
	public boolean agregar(Torneo torneo, Participante p1, Participante p2);
	
	public boolean agregarResultado(Partido partido);
	
}