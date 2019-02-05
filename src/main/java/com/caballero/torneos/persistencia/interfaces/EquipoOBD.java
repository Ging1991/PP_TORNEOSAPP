package com.caballero.torneos.persistencia.interfaces;

import com.caballero.torneos.persistencia.entidades.Equipo;

public interface EquipoOBD extends CRUD<Equipo> {
	
	public Equipo selectByNombre(String nombre);
	
}