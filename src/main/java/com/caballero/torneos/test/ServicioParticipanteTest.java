package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
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
	
}