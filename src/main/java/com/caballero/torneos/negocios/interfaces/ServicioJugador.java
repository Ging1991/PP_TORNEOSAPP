package com.caballero.torneos.negocios.interfaces;

import java.util.List;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;

public interface ServicioJugador {
	
	public boolean agregar(Jugador jugador) throws JugadorInvalidoExcepcion;
	
	public boolean modificar(Jugador jugador) throws JugadorInvalidoExcepcion;

	public Jugador traerPorNombre(String nombre);
	
	public List<Jugador> traerTodo();
	
	public Jugador traerUltimo();

	public Jugador traerPorID(Integer iD);

	public List<Jugador> traerPorEquipo(Equipo equipo);

	public boolean eliminar(Jugador jugador) throws JugadorInvalidoExcepcion;
	
}