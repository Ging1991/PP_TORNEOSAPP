package com.caballero.torneos.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Torneo;

class ServicioTorneoTest {
	private static ServicioTorneo servicioTorneo;;
	
	@BeforeAll
	static void setup() {
		servicioTorneo = FabricaServiciosTest.crearServicioTorneo();
	}
	
	@Test
	void traerUltimo_ExisteAlMenosUno_retornaUltimo() {
		Torneo torneo = servicioTorneo.traerUltimo();
		assertNotNull(torneo);
	}
	
}