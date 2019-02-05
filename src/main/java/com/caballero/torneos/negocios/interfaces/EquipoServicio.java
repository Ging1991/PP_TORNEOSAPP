package com.caballero.torneos.negocios.interfaces;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Equipo;

public interface EquipoServicio {
	
	public boolean agregarEquipo(Equipo equipo) throws EquipoInvalidoExcepcion;
	
	public boolean modificarEquipo(Equipo equipo) throws EquipoInvalidoExcepcion;

	public Equipo traerUltimoAgregado();

	public Equipo traerPorNombre(String nombre) throws EquipoInvalidoExcepcion;

}