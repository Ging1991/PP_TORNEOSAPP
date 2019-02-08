package com.caballero.torneos.test.DAOTest;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;

public class ParticipanteDAOTest implements ParticipanteDAO {
	private Participante participante1, participante2, participante3;
	
	public ParticipanteDAOTest() {
		participante1 = new Participante(1, 1, 1, 0);
		participante2 = new Participante(2, 1, 1, 0);
		participante3 = new Participante(3, 1, 1, 0);
	}

	@Override
	public void insert(Participante t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Participante t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Participante t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Participante> select() {
		List<Participante> participantes = new ArrayList<>();
		participantes.add(participante1);
		participantes.add(participante2);
		participantes.add(participante3);
		return participantes;
	}

	@Override
	public Participante selectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participante selectUltimo() {
		return participante3;
	}

	@Override
	public List<Participante> selectByTorneo(Torneo torneo) {
		return select();
	}

	@Override
	public List<Participante> selectByTorneoDerrotas(Torneo torneo, int derrotas) {
		return select();
	}

	@Override
	public List<Participante> selectByJugador(Jugador jugador) {
		if (jugador.getID() == 1)
			return select();
		else
			return new ArrayList<>();
	}

}