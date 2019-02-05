package com.caballero.torneos.persistencia;

import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;
import com.caballero.torneos.persistencia.mysql.EquipoDAOMySQL;
import com.caballero.torneos.persistencia.mysql.JugadorDAOMySQL;
import com.caballero.torneos.persistencia.mysql.ParticipanteDAOMySQL;
import com.caballero.torneos.persistencia.mysql.PartidoDAOMySQL;
import com.caballero.torneos.persistencia.mysql.TorneoDAOMySQL;

public class FabricaDAO {

	public static EquipoDAO	crearEquipoOBD() {
		return new EquipoDAOMySQL();
	}

	public static TorneoDAO	crearTorneoOBD() {
		return new TorneoDAOMySQL();
	}
	
	public static JugadorDAO crearJugadorOBD() {
		return new JugadorDAOMySQL();
	}

	public static ParticipanteDAO crearParticipanteOBD() {
		return new ParticipanteDAOMySQL();
	}
	
	public static PartidoDAO crearPartidoOBD() {
		return new PartidoDAOMySQL();
	}
	
}