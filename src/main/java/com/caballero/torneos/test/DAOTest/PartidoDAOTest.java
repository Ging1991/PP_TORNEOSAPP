package com.caballero.torneos.test.DAOTest;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.definidos.EstadoPartido;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;

public class PartidoDAOTest implements PartidoDAO {
	private Partido partido1, partido2 ,partido3;
	
	public PartidoDAOTest() {
		partido1 = new Partido(1, 1, 1, 2, 0, 0, EstadoPartido.PENDIENTE);
		partido2 = new Partido(2, 1, 1, 2, 0, 0, EstadoPartido.PENDIENTE);
		partido3 = new Partido(3, 1, 1, 2, 0, 0, EstadoPartido.PENDIENTE);
	}

	@Override
	public void insert(Partido t) {}

	@Override
	public void update(Partido t) {}

	@Override
	public void delete(Partido t) {}

	@Override
	public List<Partido> select() {
		List<Partido> partidos = new ArrayList<>();
		partidos.add(partido1);
		partidos.add(partido2);
		partidos.add(partido3);
		return partidos;
	}

	@Override
	public Partido selectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partido selectUltimo() {
		return partido3;
	}

	@Override
	public List<Partido> selectByTorneoEstado(Torneo torneo, EstadoPartido estado) {
		return select();
	}

	@Override
	public List<Partido> selectByTorneo(Torneo torneo) {
		return select();
	}

}