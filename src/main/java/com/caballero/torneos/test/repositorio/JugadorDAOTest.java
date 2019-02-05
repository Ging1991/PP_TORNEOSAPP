package com.caballero.torneos.test.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class JugadorDAOTest implements JugadorDAO {
	private static Jugador jugador1, jugador2, jugador3;
	
	public JugadorDAOTest() {
		jugador1 = new Jugador(1, 1, "Carlos");
		jugador2 = new Jugador(2, 2, "Jorge");
		jugador3 = new Jugador(3, 3, "Chiqui");
	}
	
	@Override
	public void insert(Jugador t) {}
	
	@Override
	public void delete(Jugador t) {}

	@Override
	public void update(Jugador t) {}
	
	@Override
	public Jugador selectUltimo() {
		return jugador3;
	}

	@Override
	public Jugador selectByID(int id) {
		if (id == 1) return jugador1;
		if (id == 2) return jugador2;
		if (id == 3) return jugador3;
		return null;
	}
	
	@Override
	public List<Jugador> select() {
		List<Jugador> lista = new ArrayList<>();
		lista.add(jugador1);
		lista.add(jugador2);
		lista.add(jugador3);
		return lista;
	}
	
	@Override
	public Jugador selectByNombre(String nombre) {
		if (nombre.equals("Carlos")) return jugador1;
		if (nombre.equals("Jorge")) return jugador2;
		if (nombre.equals("Chiqui")) return jugador3;
		return null;
	}
	
}