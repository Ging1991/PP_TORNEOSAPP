package com.caballero.torneos.negocios.servicios;

import java.util.List;

import com.caballero.torneos.negocios.Almanaque;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.negocios.interfaces.ServicioPartido;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class ServicioTorneoImpl implements ServicioTorneo {
	private TorneoDAO torneoDAO;
	private ServicioParticipante servicioParticipante;
	private ServicioPartido servicioPartido;
	
	public ServicioTorneoImpl(TorneoDAO torneoDAO, ServicioParticipante servicioParticipante,
			ServicioPartido servicioPartido) {
		this.torneoDAO = torneoDAO;
		this.servicioParticipante = servicioParticipante;
		this.servicioPartido = servicioPartido;
	}

	@Override
	public Torneo traerUltimo() {
		return torneoDAO.selectUltimo();
	}

	@Override
	public Boolean agregar(String nombre, List<Jugador> lista) {
		Torneo torneo = new Torneo(-1, nombre, Almanaque.hoy(), EstadoTorneo.CURSO);
		torneoDAO.insert(torneo);
		
		torneo = traerUltimo();
		for (Jugador jugador : lista)
			servicioParticipante.agregar(torneo, jugador);
		
		return true;
	}

	@Override
	public boolean cancelar(Torneo torneo) {
		servicioPartido.eliminarPartidos(torneo);
		servicioParticipante.eliminarParticipantes(torneo);
		torneoDAO.delete(torneo);
		return true;
	}

	@Override
	public boolean generarFixture(Torneo torneo) {
		servicioPartido.eliminarPartidosPendientes(torneo);
		List<Participante> derrotas0 = servicioParticipante.traerPorDerrotas(torneo, 0);
		List<Participante> derrotas1 = servicioParticipante.traerPorDerrotas(torneo, 1);
		
		if (derrotas1.size()> 1) {
			for (int i = 0; i < derrotas1.size()/2; i = i+2) {
				Participante p1 = derrotas1.get(i);
				Participante p2 = derrotas1.get(i+1);
				servicioPartido.agregar(torneo, p1, p2);
			}
		}
		
		// si es impar, el ultimo no creo su partido, se lo agrego a los de 0 derrotas
		if (derrotas1.size()/2 > 1)
			derrotas0.add(derrotas1.get(derrotas1.size()-1));
		
		if (derrotas0.size()> 1) {
			for (int i = 0; i < derrotas0.size()/2; i = i+2) {
				Participante p1 = derrotas0.get(i);
				Participante p2 = derrotas0.get(i+1);
				servicioPartido.agregar(torneo, p1, p2);
			}
		}
		
		return true;
	}

	@Override
	public List<Torneo> traerTodo() {
		return torneoDAO.select();
	}

	@Override
	public boolean modificar(Torneo torneo) {
		torneoDAO.update(torneo);
		return true;
	}

}