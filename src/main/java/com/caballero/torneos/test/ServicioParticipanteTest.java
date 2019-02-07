package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;

class ServicioParticipanteTest {
	private static ServicioParticipante servicioParticipante;
	private static ServicioTorneo servicioTorneo;
	private static ServicioJugador servicioJugador;
	
	@BeforeAll
	static void setup() {
		servicioParticipante = FabricaServiciosTest.crearServicioParticipante();
		servicioTorneo = FabricaServiciosTest.crearServicioTorneo();
		servicioJugador = FabricaServiciosTest.crearJugadorServicio();
	}
	
	@Test
	void agregar_TorneoJugadorExistente_retornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		Jugador jugador = servicioJugador.traerUltimo();
		assertTrue(servicioParticipante.agregar(torneo, jugador));
	}

	@Test
	void eliminarParticipantes_TorneoExistente_RetornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertTrue(servicioParticipante.eliminarParticipantes(torneo));
	}

	@Test
	void traer_TorneoExistente_RetornaListaDe3() {
		Torneo torneo = servicioTorneo.traerUltimo();
		List<Participante> participantes = servicioParticipante.traer(torneo);
		assertTrue(participantes.size() == 3);
	}
	
	@Test
	void traerPorDerrotas_TorneoExistente_RetornaListaDe3() {
		Torneo torneo = servicioTorneo.traerUltimo();
		List<Participante> participantes = servicioParticipante.traerPorDerrotas(torneo, 0);
		assertTrue(participantes.size() == 3);
	}
	
}