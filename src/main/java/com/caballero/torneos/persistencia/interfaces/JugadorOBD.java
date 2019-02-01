package com.caballero.torneos.persistencia.interfaces;

import java.util.List;
import com.caballero.torneos.persistencia.entidades.Jugador;

public interface JugadorOBD {
	
	public void insert(Jugador jugador);
	
	public void update(Jugador jugador);
	
	public void delete(Jugador jugador);
	
	public List<Jugador> select();
	
	public Jugador selectByID(Integer id);

}