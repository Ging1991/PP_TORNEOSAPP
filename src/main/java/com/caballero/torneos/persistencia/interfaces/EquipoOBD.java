package com.caballero.torneos.persistencia.interfaces;

import java.util.List;
import com.caballero.torneos.persistencia.entidades.Equipo;

public interface EquipoOBD {
	
	public void insert(Equipo equipo);
	
	public void update(Equipo equipo);
	
	public void delete(Equipo equipo);
	
	public List<Equipo> select();
	
	public Equipo selectByID(Integer id);

}