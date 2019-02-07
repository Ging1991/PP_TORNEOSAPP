package com.caballero.torneos.test;

import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.negocios.interfaces.ServicioPartido;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.negocios.servicios.ServicioEquipoImpl;
import com.caballero.torneos.negocios.servicios.ServicioJugadorImpl;
import com.caballero.torneos.negocios.servicios.ServicioParticipanteImpl;
import com.caballero.torneos.negocios.servicios.ServicioPartidoImpl;
import com.caballero.torneos.negocios.servicios.ServicioTorneoImpl;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;
import com.caballero.torneos.test.DAOTest.EquipoDAOTest;
import com.caballero.torneos.test.DAOTest.JugadorDAOTest;
import com.caballero.torneos.test.DAOTest.ParticipanteDAOTest;
import com.caballero.torneos.test.DAOTest.PartidoDAOTest;
import com.caballero.torneos.test.DAOTest.TorneoDAOtest;

public class FabricaServiciosTest {
	
	public static ServicioEquipo crearEquipoServicio() {
		EquipoDAO obd = new EquipoDAOTest();
		return new ServicioEquipoImpl(obd);
	}
	
	public static ServicioPartido crearServicioPartido() {
		PartidoDAO dao = new PartidoDAOTest();
		return new ServicioPartidoImpl(dao);
	}

	public static ServicioParticipante crearServicioParticipante() {
		ParticipanteDAO dao = new ParticipanteDAOTest();
		return new ServicioParticipanteImpl(dao);
	}
	
	public static ServicioTorneo crearServicioTorneo() {
		TorneoDAO dao = new TorneoDAOtest();
		ServicioParticipante sp = crearServicioParticipante();
		ServicioPartido spa = crearServicioPartido();
		return new ServicioTorneoImpl(dao, sp, spa);
	}
	
	public static ServicioJugador crearJugadorServicio() {
		JugadorDAO obd = new JugadorDAOTest();
		EquipoDAO dao = new EquipoDAOTest();
		return new ServicioJugadorImpl(obd, dao);
	}

}