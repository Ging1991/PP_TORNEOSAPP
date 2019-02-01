package com.caballero.torneos.negocios.servicios;

import com.caballero.torneos.negocios.EquipoServicio;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;

public class EquipoServicioImpl implements EquipoServicio {
	private EquipoOBD obd;
	
	public EquipoServicioImpl(EquipoOBD obd) {
		this.obd = obd;
	}

	@Override
	public boolean agregarEquipo(Equipo equipo) {
		obd.insert(equipo);
		return true;
	}

}