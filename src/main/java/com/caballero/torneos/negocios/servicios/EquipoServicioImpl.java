package com.caballero.torneos.negocios.servicios;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;

public class EquipoServicioImpl implements EquipoServicio {
	private EquipoOBD obd;
	
	public EquipoServicioImpl(EquipoOBD obd) {
		this.obd = obd;
	}

	@Override
	public boolean agregarEquipo(Equipo equipo) throws EquipoInvalidoExcepcion {
		verificarEquipo(equipo);
		obd.insert(equipo);
		return true;
	}

	@Override
	public boolean modificarEquipo(Equipo equipo) throws EquipoInvalidoExcepcion {
		verificarEquipo(equipo);
		obd.update(equipo);
		return true;
	}

	private void verificarEquipo(Equipo equipo) throws EquipoInvalidoExcepcion {
		if (equipo.getNombre() == null)
			throw new EquipoInvalidoExcepcion("El nombre del equipo no puede estar vacio.");
		
		if (equipo.getNombre().length() < 3)
			throw new EquipoInvalidoExcepcion("El nombre del equipo no puede tener menos de  caracteres.");
	}
	
}