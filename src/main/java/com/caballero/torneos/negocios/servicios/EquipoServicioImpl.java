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
		verificarNombre(equipo.getNombre());
		if (traerPorNombre(equipo.getNombre()) != null)
			throw new EquipoInvalidoExcepcion("Ya existe un equipo creado con el nombre: "+equipo.getNombre());
		
		obd.insert(equipo);
		return true;
	}

	@Override
	public boolean modificarEquipo(Equipo equipo) throws EquipoInvalidoExcepcion {
		verificarNombre(equipo.getNombre());
		obd.update(equipo);
		return true;
	}

	@Override
	public Equipo traerUltimoAgregado() {
		return obd.selectUltimo();
	}

	@Override
	public Equipo traerPorNombre(String nombre) throws EquipoInvalidoExcepcion {
		verificarNombre(nombre);
		return obd.selectByNombre(nombre);
	}

	private void verificarNombre(String nombre) throws EquipoInvalidoExcepcion {
		if (nombre == null)
			throw new EquipoInvalidoExcepcion("El nombre del equipo no puede estar vacio.");
		
		if (nombre.length() < 3)
			throw new EquipoInvalidoExcepcion("El nombre del equipo no puede tener menos de  caracteres.");
	}

}