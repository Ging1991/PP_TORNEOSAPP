package com.caballero.torneos.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.persistencia.entidades.Equipo;

class EquipoServicioTest {
	private static ServicioEquipo servicioEquipo;
	
	@BeforeAll
	static void iniciar() {
		servicioEquipo = FabricaServiciosTest.crearEquipoServicio();
	}
	
	@Test
	void agregarEquipo_NombreMasDe3CaracteresNoRepetido_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "Racing");
		assertTrue(servicioEquipo.agregar(equipo));
	}

	@Test
	void eliminar_NoUsado_RetornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = servicioEquipo.traerUltimoAgregado();
		equipo.setID(3);
		assertTrue(servicioEquipo.eliminar(equipo));
	}

	@Test
	void eliminar_Usado_RetornaExcepcion() throws EquipoInvalidoExcepcion {
		Equipo equipo = servicioEquipo.traerUltimoAgregado();
		equipo.setID(1);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.eliminar(equipo);	
		});
	}
	
	@Test
	void agregarEquipo_NombreMasDe3CaracteresRepetido_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "Boca");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.agregar(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.agregar(equipo);	
		});
	}

	@Test()
	void agregarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.agregar(equipo);	
		});
	}

	@Test
	void modificarEquipo_NombreMasDe3Caracteres_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(1, "equipo");
		assertTrue(servicioEquipo.modificar(equipo));
	}

	@Test
	void modificarEquipo_NombreRepetido_lanzaExcepcion() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(1, "Boca");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.modificar(equipo);	
		});
	}

	@Test()
	void modificarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.modificar(equipo);	
		});
	}

	@Test()
	void modificarEquipo_NombreNull_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, null);
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			servicioEquipo.modificar(equipo);	
		});
	}
	
	@Test()
	void traerUltimoAgregado_ExisteAlMenosUno_retornaUltimoEquipo() {
		Equipo equipo = servicioEquipo.traerUltimoAgregado();
		assertNotNull(equipo);
	}
	
	@Test()
	void traerPorID_EquipoExistente_RetornaEseEquipo() {
		Integer ID = 1;
		Equipo equipo = servicioEquipo.traerPorID(ID);
		assertTrue(equipo.getID() == ID);
	}
	
	@Test()
	void traerPorID_EquipoInexistente_RetornaNull() {
		Integer ID = -1;
		Equipo equipo = servicioEquipo.traerPorID(ID);
		assertNull(equipo);
	}

}