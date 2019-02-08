package com.caballero.torneos.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;

/**
 * @author Carlos
 * Nombre valido: El nombre del jugador es valido cuando no es NULL y tiene 3 o mas caracteres.
 * Equipo valido: El equipo es valido cuando existe.
 */
class ServicioJugadorTest {
	private static ServicioJugador servicioJugador;
	private static ServicioEquipo servicioEquipo;
	
	@BeforeAll
	static void setup() {
		servicioJugador = FabricaServiciosTest.crearJugadorServicio();
		servicioEquipo = FabricaServiciosTest.crearEquipoServicio();
	}
	
	@Test
	void traerPorNombre_NombreExistente_retornaJugadorConEseNombre() throws JugadorInvalidoExcepcion {
		String nombre = "Carlos";
		Jugador jugador = servicioJugador.traerPorNombre(nombre);
		assertTrue(jugador.getNombre().equals(nombre));
	}
	
	@Test
	void traerPorNombre_NombreInexistente_retornaNull() throws JugadorInvalidoExcepcion {
		String nombre = "Carlos1991";
		Jugador jugador = servicioJugador.traerPorNombre(nombre);
		assertNull(jugador);
	}

	@Test
	void agregarJugador_NombreNoRepetidoMasDe3CaracteresEquipoExistente_retornaTrue() throws JugadorInvalidoExcepcion {
		Equipo equipo = servicioEquipo.traerUltimoAgregado();
		Jugador jugador = new Jugador(-1, equipo.getID(), "Carlos1991");
		assertTrue(servicioJugador.agregar(jugador));
	}
		
	@Test
	void agregarJugador_NombreRepetidoMasDe3CaracteresEquipoExistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Equipo equipo = servicioEquipo.traerUltimoAgregado();
		Jugador jugador = new Jugador(-1, equipo.getID(), "Carlos");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.agregar(jugador);	
		});
	}
	
	@Test
	void agregarJugador_NombreNoRepetidoMasDe3CaracteresEquipoInexistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, -1, "Carlos1991");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.agregar(jugador);
		});
	}

	@Test
	void agregarJugador_NombreNoRepetidoMenosDe3CaracteresEquipoExistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, "Ca");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.agregar(jugador);
		});
	}

	@Test
	void agregarJugador_NombreNull_EquipoExistente_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, null);
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.agregar(jugador);
		});
	}

	@Test
	void modificar_NombreValido_EquipoValido_retornaTrue() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(1, 1, "Carlos1991");
		assertTrue(servicioJugador.modificar(jugador));
	}

	@Test
	void modificar_NombreMenosDe3Caracteres_EquipoValido_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, "Ca");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.modificar(jugador);
		});
	}

	@Test
	void modificar_NombreNull_EquipoValido_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, null);
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.modificar(jugador);
		});
	}
	
	@Test
	void modificar_NombreRepetido_EquipoValido_lanzaExcepcion() throws JugadorInvalidoExcepcion {
		Jugador jugador = new Jugador(-1, 1, "Carlos");
		assertThrows(JugadorInvalidoExcepcion.class, () -> {
			servicioJugador.modificar(jugador);
		});
	}

	@Test
	void traerUltimo_ExisteAlMenosUno_retornaJugador() {
		Jugador jugador = servicioJugador.traerUltimo();
		assertNotNull(jugador);
	}

	@Test
	void traerPorID_JugadorExistente_retornaJugadorConEseID() {
		Integer ID = 1;
		Jugador jugador = servicioJugador.traerPorID(ID);
		assertTrue(jugador.getID() == ID);
	}

	@Test
	void traerPorID_JugadorInexistente_retornaJugadorConEseID() {
		Integer ID = -1;
		Jugador jugador = servicioJugador.traerPorID(ID);
		assertNull(jugador);
	}

	@Test
	void traerPorEquipo_JugadorExistente_retornaJugadoresConEseEquipo() {
		Equipo equipo = servicioEquipo.traerPorID(1);
		List<Jugador> jugadores = servicioJugador.traerPorEquipo(equipo); 
		assertTrue(jugadores.size() == 3);
	}

	@Test
	void borrarJugador_JugadorLibre_RetornaTrue() throws JugadorInvalidoExcepcion {
		Jugador jugador = servicioJugador.traerUltimo();
		assertTrue(servicioJugador.eliminar(jugador));
	}

}