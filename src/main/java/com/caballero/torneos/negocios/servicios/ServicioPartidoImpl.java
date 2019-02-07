package com.caballero.torneos.negocios.servicios;

import java.util.List;

import com.caballero.torneos.negocios.interfaces.ServicioPartido;
import com.caballero.torneos.persistencia.definidos.EstadoPartido;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;

public class ServicioPartidoImpl implements ServicioPartido {
	private PartidoDAO dao;
	
	public ServicioPartidoImpl(PartidoDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean eliminarPartido(Partido partido) {
		dao.delete(partido);
		return true;
	}

	@Override
	public Partido traerUltimo() {
		return dao.selectUltimo();
	}

	@Override
	public boolean eliminarPartidosPendientes(Torneo torneo) {
		List<Partido> partidos = traerPartidosPendientes(torneo);
		for (Partido partido : partidos)
			eliminarPartido(partido);
		
		return true;
	}

	@Override
	public List<Partido> traerPartidosPendientes(Torneo torneo) {
		return dao.selectByTorneoEstado(torneo, EstadoPartido.PENDIENTE);
	}

	@Override
	public boolean eliminarPartidos(Torneo torneo) {
		List<Partido> partidos = dao.selectByTorneo(torneo);
		for (Partido partido : partidos)
			eliminarPartido(partido);
		
		return true;
	}

	@Override
	public boolean agregar(Torneo torneo, Participante p1, Participante p2) {
		Partido partido = new Partido(-1, torneo.getID(), p1.getID(), p2.getID(), -1, -1, EstadoPartido.PENDIENTE);
		dao.insert(partido);
		return true;
	}

}