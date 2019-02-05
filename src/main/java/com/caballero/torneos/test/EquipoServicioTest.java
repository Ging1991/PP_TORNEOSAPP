package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.test.repositorio.FabricaServiciosTest;

class EquipoServicioTest {
	private static EquipoServicio servicio;
	
	@BeforeAll
	static void iniciar() {
		servicio = FabricaServiciosTest.crearEquipoServicio();
	}
	
	@Test
	void agregarEquipo_NombreMasDe3CaracteresNoRepetido_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "Racing");
		assertTrue(servicio.agregarEquipo(equipo));
	}
	
	@Test
	void agregarEquipo_NombreMasDe3CaracteresRepetido_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "Boca");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.agregarEquipo(equipo);	
		});
	}

	@Test
	void modificarEquipo_NombreMasDe3Caracteres_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(1, "equipo");
		assertTrue(servicio.modificarEquipo(equipo));
	}

	@Test()
	void modificarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.modificarEquipo(equipo);	
		});
	}

	@Test()
	void modificarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.modificarEquipo(equipo);	
		});
	}
	
	@Test()
	void traerUltimoAgregado_ExisteAlMenosUno_retornaUltimoEquipo() {
		Equipo equipo = new Equipo(-1, "");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicio.modificarEquipo(equipo);	
		});
	}

}