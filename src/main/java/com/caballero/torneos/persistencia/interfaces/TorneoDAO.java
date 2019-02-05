package com.caballero.torneos.persistencia.interfaces;

import java.util.List;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface TorneoDAO {

	public void insert(Torneo torneo);
	
	public void update(Torneo torneo);
	
	public void delete(Torneo torneo);
	
	public List<Torneo> select();
	
	public Integer selectUltimoID();
	
	public Torneo selectByID(Integer ID);

}