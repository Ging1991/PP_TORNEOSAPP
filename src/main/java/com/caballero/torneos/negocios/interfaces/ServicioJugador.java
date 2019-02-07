package com.caballero.torneos.negocios.interfaces;

import java.util.List;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Jugador;

public interface ServicioJugador {
	
	public boolean agregar(Jugador jugador) throws JugadorInvalidoExcepcion;
	
	public boolean modificar(Jugador jugador) throws JugadorInvalidoExcepcion;

	public Jugador traerPorNombre(String nombre);
	
	public List<Jugador> traerTodo();
	
}