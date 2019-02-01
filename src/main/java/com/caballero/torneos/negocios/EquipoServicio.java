package com.caballero.torneos.negocios;

import com.caballero.torneos.persistencia.entidades.Equipo;

public interface EquipoServicio {
	
	public boolean agregarEquipo(Equipo equipo) throws NombreEquipoInvalidoExcepcion;
	
	public boolean modificarEquipo(Equipo equipo) throws NombreEquipoInvalidoExcepcion;

}