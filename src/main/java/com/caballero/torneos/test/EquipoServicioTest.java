package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.EquipoServicio;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.persistencia.entidades.Equipo;

class EquipoServicioTest {

	@Test
	void agregarEquipo_NombreSinRepetirMasDe3Caracteres_retornaTrue() {
		EquipoServicio servicio = FabricaServicios.crearEquipoServicio();
		Equipo equipo = new Equipo(-1, "equipo");
		assertTrue(servicio.agregarEquipo(equipo));
	}

}