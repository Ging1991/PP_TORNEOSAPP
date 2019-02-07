package com.caballero.torneos.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.negocios.interfaces.ServicioPartido;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.entidades.Torneo;

class ServicioPartidoTest {
	private static ServicioPartido servicioPartido;
	private static ServicioTorneo servicioTorneo;
	private static ServicioParticipante servicioParticipante;
	
	@BeforeAll
	static void setup() {
		servicioPartido = FabricaServiciosTest.crearServicioPartido();
		servicioTorneo = FabricaServiciosTest.crearServicioTorneo();
		servicioParticipante = FabricaServiciosTest.crearServicioParticipante();
	}
	
	@Test
	void eliminar_Existe_RetornaTrue() {
		Partido partido = servicioPartido.traerUltimo();
		assertTrue(servicioPartido.eliminarPartido(partido));
	}

	@Test
	void traerUltimo_ExisteAlMenosUno_RetornaPartido() {
		Partido partido = servicioPartido.traerUltimo();
		assertNotNull(partido);
	}

	@Test
	void traerPartidosPendientes_TorneoEnCurso_RetornaListaDe3() {
		Torneo torneo = servicioTorneo.traerUltimo();
		List<Partido> partidos = servicioPartido.traerPartidosPendientes(torneo);
		assertTrue(partidos.size() == 3);
	}

	@Test
	void eliminarPendientes_TorneoEnCurso_RetornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertTrue(servicioPartido.eliminarPartidosPendientes(torneo));
	}

	@Test
	void eliminarPartidos_TorneoEnCurso_RetornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertTrue(servicioPartido.eliminarPartidos(torneo));
	}

	@Test
	void agregar_TorneoEnCurso_RetornaTrue() {
		Torneo torneo = servicioTorneo.traerUltimo();
		List<Participante> participantes = servicioParticipante.traer(torneo);
		Participante p1 = participantes.get(0);
		Participante p2 = participantes.get(1);
		assertTrue(servicioPartido.agregar(torneo, p1, p2));
	}
		
}