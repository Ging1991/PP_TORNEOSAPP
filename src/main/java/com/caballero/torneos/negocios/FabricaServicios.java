package com.caballero.torneos.negocios;

import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.negocios.servicios.EquipoServicioImpl;
import com.caballero.torneos.negocios.servicios.JugadorServicioImpl;
import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class FabricaServicios {
	
	public static EquipoServicio crearEquipoServicio() {
		EquipoDAO obd = FabricaDAO.crearEquipoOBD();
		return new EquipoServicioImpl(obd);
	}
	
	public static JugadorServicio crearJugadorServicio() {
		JugadorDAO obd = FabricaDAO.crearJugadorOBD();
		EquipoDAO dao = FabricaDAO.crearEquipoOBD();
		return new JugadorServicioImpl(obd, dao);
	}

}