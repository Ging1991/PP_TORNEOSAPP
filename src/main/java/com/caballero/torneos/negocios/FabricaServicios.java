package com.caballero.torneos.negocios;

import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.negocios.servicios.EquipoServicioImpl;
import com.caballero.torneos.persistencia.Factory;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;

public class FabricaServicios {
	
	public static EquipoServicio crearEquipoServicio() {
		EquipoOBD obd = Factory.crearEquipoOBD();
		return new EquipoServicioImpl(obd);
	}

}