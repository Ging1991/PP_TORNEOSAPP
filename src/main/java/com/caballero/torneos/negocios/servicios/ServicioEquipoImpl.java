package com.caballero.torneos.negocios.servicios;

import java.util.List;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;

public class ServicioEquipoImpl implements ServicioEquipo {
	private EquipoDAO obd;
	private ServicioJugador servicioJugador;
	
	public ServicioEquipoImpl(EquipoDAO obd, ServicioJugador servicioJugador) {
		this.obd = obd;
		this.servicioJugador = servicioJugador;
	}

	@Override
	public boolean agregar(Equipo equipo) throws EquipoInvalidoExcepcion {
		verificarNombre(equipo.getNombre());
		if (traerPorNombre(equipo.getNombre()) != null)
			throw new EquipoInvalidoExcepcion("Ya existe un equipo creado con el nombre: "+equipo.getNombre());
		
		obd.insert(equipo);
		return true;
	}

	@Override
	public boolean modificar(Equipo equipo) throws EquipoInvalidoExcepcion {
		verificarNombre(equipo.getNombre());
		Equipo equipoBD = traerPorNombre(equipo.getNombre()); 
		
		if (equipoBD != null && equipoBD.getID() != equipo.getID())
			throw new EquipoInvalidoExcepcion("Ya existe otro equipo con el nombre: "+equipo.getNombre());
		
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

	@Override
	public List<Equipo> traerTodo() {
		return obd.select();
	}

	@Override
	public Equipo traerPorID(Integer ID) {
		return obd.selectByID(ID);
	}

	@Override
	public boolean eliminar(Equipo equipo) throws EquipoInvalidoExcepcion {
		List<Jugador> jugadores = servicioJugador.traerPorEquipo(equipo);
		
		if (jugadores.size() == 0)
			obd.delete(equipo);
		else
			throw new EquipoInvalidoExcepcion("No se puede eliminar el equipo seleccionado porque hay jugadores que dependen de él.");
		
		return true;
	}

}