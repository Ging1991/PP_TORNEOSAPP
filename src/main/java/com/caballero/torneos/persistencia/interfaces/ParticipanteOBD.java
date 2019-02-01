package com.caballero.torneos.persistencia.interfaces;

import java.util.List;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;

public interface ParticipanteOBD {
	
	public void insert(Participante participante);
	
	public List<Participante> select();
	
	public List<Participante> selectByTorneo(Torneo torneo);

}