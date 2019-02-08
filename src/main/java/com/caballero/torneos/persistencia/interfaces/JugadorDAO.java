package com.caballero.torneos.persistencia.interfaces;

import java.util.List;

import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;

public interface JugadorDAO extends CRUD<Jugador> {
	
	public Jugador selectByNombre(String nombre);

	public List<Jugador> selectByEquipo(Equipo equipo);
	
}