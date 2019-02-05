package com.caballero.torneos.negocios.interfaces;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Jugador;

public interface JugadorServicio {
	
	public boolean agregarJugador(Jugador jugador) throws JugadorInvalidoExcepcion;
	
	public boolean modificarJugador(Jugador jugador) throws JugadorInvalidoExcepcion;

	public Jugador traerPorNombre(String nombre);
	
}