package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.test.repositorio.FabricaServiciosTest;

/**
 * @author Carlos
 * Nombre valido: El nombre del jugador es valido cuando no es NULL y tiene 3 o mas caracteres.
 * Equipo valido: El equipo es valido cuando existe.
 */
class JugadorServicioTest {
	private static JugadorServicio jugadorServicio;
	private static EquipoServicio equipoServicio;
	
	@BeforeAll
	static void setup() {
		jugadorServicio = FabricaServiciosTest.crearJugadorServicio();
		equipoServicio = FabricaServiciosTest.crearEquipoServicio();
	}
	
	@Test
	void traerPorNombre_NombreExistente_retornaJugadorConEseNombre() throws JugadorInvalidoExcepcion {
		String nombre = "Carlos";
		Jugador jugador = jugadorServicio.traerPorNombre(nombre);
		assertTrue(jugador.getNombre().equals(nombre));
	}
	
	@Test
	void traerPorNombre_NombreInexistente_retornaNull() throws JugadorInvalidoExcepcion {
		String nombre = "Carlos1991";
		Jugador jugador = jugadorServicio.traerPorNombre(nombre);
		assertNull(jugador);
	}

	@Test
	void agregarJugador_NombreNoRepetidoMasDe3CaracteresEquipoExistente_retornaTrue() throws JugadorInvalidoExcepcion {
		Equipo equipo = equipoServicio.traerUltimoAgregado();
		Jugador jugador = new Jugador(-1, equipo.getID(), "Carlos1991");
		assertTrue(jugadorServicio.agregar(jugador));
	}
		
	@Test
	void agregarJugador_NombreRepetidoMasDe3CaracteresEquipoExistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Equipo equipo = equipoServicio.traerUltimoAgregado();
		Jugador jugador = new Jugador(-1, equipo.getID(), "Carlos");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.agregar(jugador);	
		});
	}
	
	@Test
	void agregarJugador_NombreNoRepetidoMasDe3CaracteresEquipoInexistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, -1, "Carlos1991");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.agregar(jugador);
		});
	}

	@Test
	void agregarJugador_NombreNoRepetidoMenosDe3CaracteresEquipoExistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, "Ca");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.agregar(jugador);
		});
	}

	@Test
	void agregarJugador_NombreNull_EquipoExistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, null);
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.agregar(jugador);
		});
	}

	@Test
	void modificar_NombreValido_EquipoValido_retornaTrue() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(1, 1, "Carlos1991");
		assertTrue(jugadorServicio.modificar(jugador));
	}

	@Test
	void modificar_NombreMenosDe3Caracteres_EquipoValido_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, "Ca");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.modificar(jugador);
		});
	}

	@Test
	void modificar_NombreNull_EquipoValido_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, null);
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.modificar(jugador);
		});
	}
	
	@Test
	void modificar_NombreRepetido_EquipoValido_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, "Carlos");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			jugadorServicio.modificar(jugador);
		});
	}
	
	
}