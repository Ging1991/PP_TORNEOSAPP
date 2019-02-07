package com.caballero.torneos.test.DAOTest;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;

public class EquipoDAOTest implements EquipoDAO {
	private static Equipo equipo1, equipo2, equipo3;
	
	public EquipoDAOTest() {
		equipo1 = new Equipo(1, "Velez"); 
		equipo2 = new Equipo(2, "Boca"); 
		equipo3 = new Equipo(3, "River"); 
	}
	
	@Override
	public void insert(Equipo t) {}
	
	@Override
	public void delete(Equipo t) {}

	@Override
	public void update(Equipo t) {}
	
	@Override
	public Equipo selectUltimo() {
		return equipo3;
	}

	@Override
	public Equipo selectByID(int id) {
		if (id == 1) return equipo1;
		if (id == 2) return equipo2;
		if (id == 3) return equipo3;
		return null;
	}
	
	@Override
	public List<Equipo> select() {
		List<Equipo> lista = new ArrayList<>();
		lista.add(equipo1);
		lista.add(equipo2);
		lista.add(equipo3);
		return lista;
	}
	
	@Override
	public Equipo selectByNombre(String nombre) {
		if (nombre.equals("Velez")) return equipo1;
		if (nombre.equals("Boca")) return equipo2;
		if (nombre.equals("River")) return equipo3;
		return null;
	}

}