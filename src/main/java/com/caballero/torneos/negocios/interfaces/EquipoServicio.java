package com.caballero.torneos.negocios.interfaces;

import com.caballero.torneos.negocios.excepciones.NombreEquipoInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Equipo;

public interface EquipoServicio {
	
	public boolean agregarEquipo(Equipo equipo) throws NombreEquipoInvalidoExcepcion;
	
	public boolean modificarEquipo(Equipo equipo) throws NombreEquipoInvalidoExcepcion;

}