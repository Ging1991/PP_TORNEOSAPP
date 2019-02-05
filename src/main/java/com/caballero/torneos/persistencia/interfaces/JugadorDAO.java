package com.caballero.torneos.persistencia.interfaces;

import com.caballero.torneos.persistencia.entidades.Jugador;

public interface JugadorDAO extends CRUD<Jugador> {
	
	public Jugador selectByNombre(String nombre);
	
}