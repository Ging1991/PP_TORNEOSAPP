package com.caballero.torneos.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Torneo;

class ServicioTorneoTest {
	private static ServicioTorneo servicioTorneo;;
	private static ServicioJugador servicioJugador;
	
	@BeforeAll
	static void setup() {
		servicioTorneo = FabricaServiciosTest.crearServicioTorneo();
		servicioJugador = FabricaServiciosTest.crearJugadorServicio();
	}
	
	@Test
	void traerUltimo_ExisteAlMenosUno_retornaUltimo() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertNotNull(torneo);
	}

	@Test
	void agregar_NombreValidoCantidadParticipantesValida_retornaTrue() {
		String nombre = "Mi torneo de prueba";
		List<Jugador> lista = new ArrayList<>();
		lista.add(servicioJugador.traerPorID(1));
		lista.add(servicioJugador.traerPorID(2));
		lista.add(servicioJugador.traerPorID(3));
		assertTrue(servicioTorneo.agregar(nombre, lista));
	}

	@Test
	void cancelar_EnCurso_RetornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertTrue(servicioTorneo.cancelar(torneo));
	}

	@Test
	void generarFixture_EnCurso_RetornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertTrue(servicioTorneo.generarFixture(torneo));
	}
	
}