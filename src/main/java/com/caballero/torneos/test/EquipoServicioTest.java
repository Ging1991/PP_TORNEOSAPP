package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.test.repositorio.FabricaServiciosTest;

class EquipoServicioTest {
	private static ServicioEquipo servicio;
	
	@BeforeAll
	static void iniciar() {
		servicio = FabricaServiciosTest.crearEquipoServicio();
	}
	
	@Test
	void agregarEquipo_NombreMasDe3CaracteresNoRepetido_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "Racing");
		assertTrue(servicio.agregar(equipo));
	}
	
	@Test
	void agregarEquipo_NombreMasDe3CaracteresRepetido_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "Boca");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.agregar(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.agregar(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.agregar(equipo);	
		});
	}

	@Test
	void modificarEquipo_NombreMasDe3Caracteres_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(1, "equipo");
		assertTrue(servicio.modificar(equipo));
	}

	@Test
	void modificarEquipo_NombreRepetido_lanzaExcepcion() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(1, "Boca");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.modificar(equipo);	
		});
	}

	@Test()
	void modificarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.modificar(equipo);	
		});
	}

	@Test()
	void modificarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.modificar(equipo);	
		});
	}
	
	@Test()
	void traerUltimoAgregado_ExisteAlMenosUno_retornaUltimoEquipo() {
		Equipo equipo = servicio.traerUltimoAgregado();
		assertNotNull(equipo);
	}

}