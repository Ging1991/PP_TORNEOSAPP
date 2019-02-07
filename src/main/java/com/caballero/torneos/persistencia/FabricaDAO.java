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

	public static EquipoDAO	crearEquipoDAO() {
		return new EquipoDAOMySQL();
	}

	public static TorneoDAO	crearTorneoDAO() {
		return new TorneoDAOMySQL();
	}
	
	public static JugadorDAO crearJugadorDAO() {
		return new JugadorDAOMySQL();
	}

	public static ParticipanteDAO crearParticipanteDAO() {
		return new ParticipanteDAOMySQL();
	}
	
	public static PartidoDAO crearPartidoDAO() {
		return new PartidoDAOMySQL();
	}
	
}