package com.caballero.torneos.negocios.servicios;

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
	public boolean agregarJugador(Jugador jugador) throws JugadorInvalidoExcepcion {
		verificarNombre(jugador.getNombre());
		
		if (traerPorNombre(jugador.getNombre()) != null)
			throw new JugadorInvalidoExcepcion("Ya existe un jugador registrado bajo el nombre: "+jugador.getNombre());

		if (equipoDAO.selectByID(jugador.getEquipo()) == null)
			throw new JugadorInvalidoExcepcion("No existe un equipo con el ID: "+jugador.getEquipo());
			
		dao.insert(jugador);
		return true;
	}

	@Override
	public boolean modificarJugador(Jugador jugador) throws JugadorInvalidoExcepcion {
		// TODO Auto-generated method stub
		return false;
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
		
}