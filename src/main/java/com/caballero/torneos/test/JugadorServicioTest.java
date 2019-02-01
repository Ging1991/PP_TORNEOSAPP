package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.persistencia.entidades.Equipo;

class JugadorServicioTest {
	private static JugadorServicio servicio;
	
	@BeforeAll
	static void setup() {
		servicio = FabricaServicios.crearJugadorServicio();
	}
	
	@Test
	void agregarJugador_NombreMasDe3CaracteresEquipoExistente_retornaTrue() throws EquipoInvalidoExcepcion {
		Equipo equipo = new Equipo(-1, "equipo");
		//assertTrue(servicio.agregarEquipo(equipo));
	}

	@Test()
	void agregarEquipo_NombreMenosDe3Caracteres_retornaExcepcion() {
		Equipo equipo = new Equipo(-1, "eq");
		assertThrows(EquipoInvalidoExcepcion.class, () -> {
			//servicio.agregarEquipo(equipo);	
		});
	}

}