package com.caballero.torneos.persistencia.interfaces;

import java.util.List;
import com.caballero.torneos.persistencia.entidades.Partido;

public interface PartidoOBD {
	
	public void insert(Partido partido);
	
	public List<Partido> select();

}