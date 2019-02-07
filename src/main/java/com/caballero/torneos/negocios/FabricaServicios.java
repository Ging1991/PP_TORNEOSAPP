package com.caballero.torneos.negocios;

import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.servicios.ServicioEquipoImpl;
import com.caballero.torneos.negocios.servicios.ServicioJugadorImpl;
import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class FabricaServicios {
	
	public static ServicioEquipo crearEquipoServicio() {
		EquipoDAO obd = FabricaDAO.crearEquipoOBD();
		return new ServicioEquipoImpl(obd);
	}
	
	public static ServicioJugador crearJugadorServicio() {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		EquipoDAO dao = FabricaDAO.crearEquipoOBD();
		return new ServicioJugadorImpl(obd, dao);
	}

}