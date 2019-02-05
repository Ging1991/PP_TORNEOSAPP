package com.caballero.torneos.vista.jugadores;

import java.util.List;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.Fichador;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.vista.PaginaPrincipal;
import com.caballero.torneos.vista.tablas.TablaJugadores;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class PaginaJugadorABM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaJugadorABM";
	private TablaJugadores tabla;
	private JugadorServicio jugadorServicio;
	
	public PaginaJugadorABM() {
		jugadorServicio = FabricaServicios.crearJugadorServicio();
		tabla = new TablaJugadores(jugadorServicio.traerTodo());
		addComponent(tabla);
		addComponent(crearBotones());
	}
		
	private HorizontalLayout crearBotones() {
		Button btnAgregar = new Button("Agregar");
		Button btnBorrar = new Button("Borrar");
		Button btnEditar = new Button("Editar");
		Button btnVolver = new Button("Volver");
		
		btnAgregar.addClickListener(e -> {
			agregar();
		});

		btnBorrar.addClickListener(e -> {
			borrar();
		});

		btnEditar.addClickListener(e -> {
			editar();
		});
		
		btnVolver.addClickListener(e -> {
			volver();
		});
		
		// ACOMODO
		HorizontalLayout botones = new HorizontalLayout();
		botones.addComponent(btnAgregar);
		botones.addComponent(btnEditar);
		botones.addComponent(btnBorrar);
		botones.addComponent(btnVolver);
		return botones;
	}

	private void borrar() {
		List<Jugador> jugadores = tabla.obtenerSeleccion();
		
		if (jugadores.size() == 0)
			Notification.show("No habia ningun jugador seleccionado");
		else if (jugadores.size() > 1)
			Notification.show("Habia demasiados jugadores seleccionados");
		else {
			Jugador jugador = jugadores.get(0);
			Fichador.borrarJugador(jugador);
			tabla.recargar(jugadorServicio.traerTodo());
		}
	}

	private void agregar() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaJugadorAM.NOMBRE);
	}
	
	private void editar() {
		List<Jugador> jugadores = tabla.obtenerSeleccion();
		
		if (jugadores.size() == 0)
			Notification.show("No habia ningun jugador seleccionado");
		else if (jugadores.size() > 1)
			Notification.show("Habia demasiados jugadores seleccionados");
		else {
			AplicacionUI ui = AplicacionUI.getInstancia();
			Jugador jugador = jugadores.get(0);
			ui.setSesion("jugador", jugador);
			ui.irPagina(PaginaJugadorAM.NOMBRE);
		}		
	}
	
	private void volver() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaPrincipal.NOMBRE);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		tabla.recargar(jugadorServicio.traerTodo());
	}

}