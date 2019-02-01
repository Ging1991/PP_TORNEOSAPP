package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.excepciones.NombreEquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.persistencia.entidades.Equipo;

class EquipoServicioTest {
	private static EquipoServicio servicio;
	
	@BeforeAll
	static void setup() {
		servicio = FabricaServicios.crearEquipoServicio();
	}
	
	@Test
	void agregarEquipo_NombreMasDe3Caracteres_retornaTrue() throws NombreEquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "equipo");
		assertTrue(servicio.agregarEquipo(equipo));
	}

	@Test()
	void agregarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, "eq");
		assertThrows(NombreEquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(NombreEquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

	@Test
	void modificarEquipo_NombreMasDe3Caracteres_retornaTrue() throws NombreEquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(1, "equipo");
		assertTrue(servicio.modificarEquipo(equipo));
	}

	@Test()
	void modificarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(1, "eq");
		assertThrows(NombreEquipoInvalidoExcepcion.class, () -> {
			servicio.modificarEquipo(equipo);	
		});
	}

	@Test()
	void modificarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(NombreEquipoInvalidoExcepcion.class, () -> {
			servicio.modificarEquipo(equipo);	
		});
	}

}