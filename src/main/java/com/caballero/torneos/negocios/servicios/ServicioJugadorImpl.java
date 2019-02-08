package com.caballero.torneos.negocios.servicios;

import java.util.List;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class ServicioJugadorImpl implements ServicioJugador {
	private JugadorDAO jugadorDAO;
	private EquipoDAO equipoDAO;
	private ServicioParticipante servicioParticipante;
	
	public ServicioJugadorImpl(JugadorDAO jugadorDAO, EquipoDAO equipoDAO,
			ServicioParticipante servicioParticipante) {
		this.jugadorDAO = jugadorDAO;
		this.equipoDAO = equipoDAO;
		this.servicioParticipante = servicioParticipante;
	}

	@Override
	public boolean agregar(Jugador jugador) throws JugadorInvalidoExcepcion {
		verificarNombre(jugador.getNombre());
		
		if (traerPorNombre(jugador.getNombre()) != null)
			throw new JugadorInvalidoExcepcion("Ya existe un jugador registrado bajo el nombre: "+jugador.getNombre());

		if (equipoDAO.selectByID(jugador.getEquipo()) == null)
			throw new JugadorInvalidoExcepcion("No existe un equipo con el ID: "+jugador.getEquipo());
			
		jugadorDAO.insert(jugador);
		return true;
	}

	@Override
	public boolean modificar(Jugador jugador) throws JugadorInvalidoExcepcion {
		verificarNombre(jugador.getNombre());
		
		Jugador jugadorBD = traerPorNombre(jugador.getNombre());
		if (jugadorBD != null && jugadorBD.getID() != jugador.getID())
			throw new JugadorInvalidoExcepcion("Ya existe un jugador con el nombre: "+jugador.getNombre());
		
		jugadorDAO.update(jugador);
		return true;
	}

	@Override
	public Jugador traerPorNombre(String nombre) {
		return jugadorDAO.selectByNombre(nombre);
	}
	
	private void verificarNombre(String nombre) throws JugadorInvalidoExcepcion {
		if (nombre == null)
			throw new JugadorInvalidoExcepcion("El nombre no puede estar vacio.");
	
		if (nombre.length() < 3)
			throw new JugadorInvalidoExcepcion("El nombre no puede tener menos de 3 caracterres.");
		
	}

	@Override
	public List<Jugador> traerTodo() {
		return jugadorDAO.select();
	}

	@Override
	public Jugador traerUltimo() {
		return jugadorDAO.selectUltimo();
	}

	@Override
	public Jugador traerPorID(Integer ID) {
		return jugadorDAO.selectByID(ID);
	}

	@Override
	public List<Jugador> traerPorEquipo(Equipo equipo) {
		return jugadorDAO.selectByEquipo(equipo);
	}

	@Override
	public boolean eliminar(Jugador jugador) throws JugadorInvalidoExcepcion {
		List<Participante> participantes = servicioParticipante.traerPorJugador(jugador);
		if (participantes.size()>0)
			throw new JugadorInvalidoExcepcion("No se puede borrar el jugador porque actualmente esta particiapndo de algun torneo.");

		jugadorDAO.delete(jugador);	
		return true;
	}	
		
}