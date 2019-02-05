package com.caballero.torneos.negocios.servicios;

import java.util.List;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class JugadorServicioImpl implements JugadorServicio {
	private JugadorDAO dao;
	private EquipoDAO equipoDAO;
	
	public JugadorServicioImpl(JugadorDAO dao, EquipoDAO equipoDAO) {
		this.dao = dao;
		this.equipoDAO = equipoDAO;
	}

	@Override
	public boolean agregar(Jugador jugador) throws JugadorInvalidoExcepcion {
		verificarNombre(jugador.getNombre());
		
		if (traerPorNombre(jugador.getNombre()) != null)
			throw new JugadorInvalidoExcepcion("Ya existe un jugador registrado bajo el nombre: "+jugador.getNombre());

		if (equipoDAO.selectByID(jugador.getEquipo()) == null)
			throw new JugadorInvalidoExcepcion("No existe un equipo con el ID: "+jugador.getEquipo());
			
		dao.insert(jugador);
		return true;
	}

	@Override
	public boolean modificar(Jugador jugador) throws JugadorInvalidoExcepcion {
		verificarNombre(jugador.getNombre());
		
		Jugador jugadorBD = traerPorNombre(jugador.getNombre());
		if (jugadorBD != null && jugadorBD.getID() != jugador.getID())
			throw new JugadorInvalidoExcepcion("Ya existe un jugador con el nombre: "+jugador.getNombre());
		
		dao.update(jugador);
		return true;
	}

	@Override
	public Jugador traerPorNombre(String nombre) {
		return dao.selectByNombre(nombre);
	}
	
	private void verificarNombre(String nombre) throws JugadorInvalidoExcepcion {
		if (nombre == null)
			throw new JugadorInvalidoExcepcion("El nombre no puede estar vacio.");
	
		if (nombre.length() < 3)
			throw new JugadorInvalidoExcepcion("El nombre no puede tener menos de 3 caracterres.");
		
	}

	@Override
	public List<Jugador> traerTodo() {
		return dao.select();
	}	
		
}