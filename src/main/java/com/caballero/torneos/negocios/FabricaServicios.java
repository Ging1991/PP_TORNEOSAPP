package com.caballero.torneos.negocios;

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
import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class FabricaServicios {
	
	public static ServicioEquipo crearEquipoServicio() {
		EquipoDAO obd = FabricaDAO.crearEquipoDAO();
		ServicioJugador sj = crearJugadorServicio();
		return new ServicioEquipoImpl(obd, sj);
	}

	public static ServicioPartido crearServicioPartido() {
		PartidoDAO dao = FabricaDAO.crearPartidoDAO();
		return new ServicioPartidoImpl(dao);
	}

	public static ServicioParticipante crearServicioParticipante() {
		ParticipanteDAO dao = FabricaDAO.crearParticipanteDAO();
		return new ServicioParticipanteImpl(dao);
	}

	public static ServicioTorneo crearServicioTorneo() {
		TorneoDAO torneoDAO = FabricaDAO.crearTorneoDAO();
		ServicioParticipante sp = crearServicioParticipante();
		ServicioPartido spa = crearServicioPartido();
		return new ServicioTorneoImpl(torneoDAO, sp, spa);
	}
	
	public static ServicioJugador crearJugadorServicio() {
		JugadorDAO obd = FabricaDAO.crearJugadorDAO();
		EquipoDAO dao = FabricaDAO.crearEquipoDAO();
		ServicioParticipante sp = crearServicioParticipante();
		return new ServicioJugadorImpl(obd, dao, sp);
	}

}