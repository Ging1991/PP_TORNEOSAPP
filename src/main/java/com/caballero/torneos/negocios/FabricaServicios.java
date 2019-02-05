package com.caballero.torneos.negocios;

import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.negocios.servicios.EquipoServicioImpl;
import com.caballero.torneos.negocios.servicios.JugadorServicioImpl;
import com.caballero.torneos.persistencia.FabricaOBD;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;
import com.caballero.torneos.persistencia.interfaces.JugadorOBD;

public class FabricaServicios {
	
	public static EquipoServicio crearEquipoServicio() {
		EquipoOBD obd = FabricaOBD.crearEquipoOBD();
		return new EquipoServicioImpl(obd);
	}
	
	public static JugadorServicio crearJugadorServicio() {
		JugadorOBD obd = FabricaOBD.crearJugadorOBD();
		return new JugadorServicioImpl(obd);
	}

}