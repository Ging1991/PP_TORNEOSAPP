package com.caballero.torneos.negocios.interfaces;

import java.util.List;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Equipo;

public interface ServicioEquipo {
	
	public boolean agregar(Equipo equipo) throws EquipoInvalidoExcepcion;
	
	public boolean modificar(Equipo equipo) throws EquipoInvalidoExcepcion;

	public Equipo traerUltimoAgregado();

	public Equipo traerPorNombre(String nombre) throws EquipoInvalidoExcepcion;

	public List<Equipo> traerTodo();
	
}