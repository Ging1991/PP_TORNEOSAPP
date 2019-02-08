package com.caballero.torneos.test.DAOTest;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.negocios.Almanaque;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class TorneoDAOtest implements TorneoDAO {
	private Torneo torneo1, torneo2, torneo3;

	public TorneoDAOtest() {
		torneo1 = new Torneo(1, "Torneo1", Almanaque.hoy(), EstadoTorneo.CURSO);
		torneo2 = new Torneo(2, "Torneo2", Almanaque.hoy(), EstadoTorneo.CURSO);
		torneo3 = new Torneo(3, "Torneo3", Almanaque.hoy(), EstadoTorneo.CURSO);
	}
	
	@Override
	public void insert(Torneo t) {}

	@Override
	public void update(Torneo t) {}

	@Override
	public void delete(Torneo t) {}

	@Override
	public List<Torneo> select() {
		List<Torneo> torneos = new ArrayList<>();
		torneos.add(torneo1);
		torneos.add(torneo2);
		torneos.add(torneo3);
		return torneos;
	}

	@Override
	public Torneo selectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Torneo selectUltimo() {
		return torneo3;
	}

}
