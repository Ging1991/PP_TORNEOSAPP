package com.caballero.torneos.vista.torneos;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.interfaces.ServicioParticipante;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.vista.tablas.TablaJugadores;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PaginaTorneoAM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaTorneoAM";
	private TextField inNombre;
	private Torneo torneo;
	private TablaJugadores tabla;
	private ServicioJugador jugadorServicio;
	private ServicioTorneo servicioTorneo;
	private ServicioParticipante servicioParticipante;
	private ServicioJugador servicioJugador;
	
	public PaginaTorneoAM() {
		jugadorServicio = FabricaServicios.crearJugadorServicio();
		servicioTorneo = FabricaServicios.crearServicioTorneo();
		servicioParticipante = FabricaServicios.crearServicioParticipante();
		servicioJugador = FabricaServicios.crearJugadorServicio();
		addComponent(inNombre = new TextField("Nombre"));
		addComponent(tabla = new TablaJugadores(jugadorServicio.traerTodo()));
		addComponent(crearBotones());
	}
	
	private HorizontalLayout crearBotones() {
		Button btnAceptar = new Button("Aceptar");
		btnAceptar.addClickListener(e -> {
			aceptar();
		});

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.addClickListener(e -> {
			volver();
		});
		
		HorizontalLayout ret = new HorizontalLayout();
		ret.addComponent(btnAceptar);
		ret.addComponent(btnCancelar);
		return ret;
	}
	
	private void aceptar() {
		String nombre = inNombre.getValue();
		List<Jugador> jugadores = tabla.obtenerSeleccion();
		if (torneo == null)
			servicioTorneo.agregar(nombre, jugadores);
		else {
			torneo.setNombre(nombre);
			servicioTorneo.modificar(torneo);
		}
		torneo = null;
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.setSesion("torneo", null);
		volver();	
	}
	
	private void volver() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaTorneoABM.NOMBRE);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		inNombre.setValue("");
		AplicacionUI ui = AplicacionUI.getInstancia();
		torneo = (Torneo) ui.getSesion("torneo");
		if (torneo != null) {
			inNombre.setValue(torneo.getNombre());
			tabla.recargar(jugadorServicio.traerTodo());
			List<Participante> participantes = servicioParticipante.traer(torneo);
			List<Jugador> jugadores = new ArrayList<>();
			for (Participante participante : participantes)
				jugadores.add(servicioJugador.traerPorID(participante.getJugador()));
				
			tabla.setSeleccion(jugadores);
		}
	}

}