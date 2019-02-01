package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.EquipoServicio;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.NombreEquipoInvalidoExcepcion;
import com.caballero.torneos.persistencia.entidades.Equipo;

class EquipoServicioTest {

	@Test
	void agregarEquipo_NombreSinRepetirMasDe3Caracteres_retornaTrue() throws NombreEquipoInvalidoExcepcion {
		EquipoServicio servicio = FabricaServicios.crearEquipoServicio();
		Equipo equipo = new Equipo(-1, "equipo");
		assertTrue(servicio.agregarEquipo(equipo));
	}

	@Test()
	void agregarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		EquipoServicio servicio = FabricaServicios.crearEquipoServicio();
		Equipo equipo = new Equipo(-1, "eq");
		assertThrows(NombreEquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreNull_retornaExcepcion() {
		EquipoServicio servicio = FabricaServicios.crearEquipoServicio();
		Equipo equipo = new Equipo(-1, null);
		assertThrows(NombreEquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

}