package com.caballero.torneos.persistencia;

import com.caballero.torneos.persistencia.interfaces.EquipoOBD;
import com.caballero.torneos.persistencia.interfaces.JugadorOBD;
import com.caballero.torneos.persistencia.interfaces.ParticipanteOBD;
import com.caballero.torneos.persistencia.interfaces.PartidoOBD;
import com.caballero.torneos.persistencia.interfaces.TorneoOBD;
import com.caballero.torneos.persistencia.mysql.EquipoODBMySQL;
import com.caballero.torneos.persistencia.mysql.JugadorODBMySQL;
import com.caballero.torneos.persistencia.mysql.ParticipanteODBMySQL;
import com.caballero.torneos.persistencia.mysql.PartidoODBMySQL;
import com.caballero.torneos.persistencia.mysql.TorneoOBDMySQL;

public class FabricaOBD {

	public static EquipoOBD	crearEquipoOBD() {
		return new EquipoODBMySQL();
	}

	public static TorneoOBD	crearTorneoOBD() {
		return new TorneoOBDMySQL();
	}
	
	public static JugadorOBD crearJugadorOBD() {
		return new JugadorODBMySQL();
	}

	public static ParticipanteOBD crearParticipanteOBD() {
		return new ParticipanteODBMySQL();
	}
	
	public static PartidoOBD crearPartidoOBD() {
		return new PartidoODBMySQL();
	}
	
}