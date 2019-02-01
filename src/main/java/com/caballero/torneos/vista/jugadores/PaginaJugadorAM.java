package com.caballero.torneos.vista.jugadores;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.Fichador;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PaginaJugadorAM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaJugadorAM";
	private TextField inNombre;
	private ComboBox<Equipo> inEquipo;
	private Jugador jugador;
	
	public PaginaJugadorAM() {}
	
	private HorizontalLayout crearBotones() {
		Button btnAceptar = new Button("Aceptar");
		Button btnVolver = new Button("Volver");

		btnAceptar.addClickListener(e -> {
			aceptar();
		});

		btnVolver.addClickListener(e -> {
			volver();
		});
		
		HorizontalLayout ret = new HorizontalLayout();
		ret.addComponent(btnAceptar);
		ret.addComponent(btnVolver);
		return ret;
	}
	
	private void volver() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.setSesion("jugador", null);
		ui.irPagina(PaginaJugadorABM.NOMBRE);
	}

	private void aceptar() {
		String nombre = inNombre.getValue();
		Equipo equipo = inEquipo.getValue();
		
		if (jugador == null)
			Fichador.crearJugador(nombre, equipo);
		else {
			jugador.setNombre(nombre);
			jugador.setEquipo(equipo.getEquipoID());
			Fichador.actualizarJugador(jugador);
		}
		jugador = null;
		volver();	
	}

	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();

		inNombre = new TextField("Nombre");
		inNombre.setValue("");
		
		inEquipo = new ComboBox<Equipo>("Equipo");
		ListDataProvider<Equipo> data = new ListDataProvider<Equipo>(Fichador.traerEquipos());
		inEquipo.setDataProvider(data);
		
		AplicacionUI ui = AplicacionUI.getInstancia();
		jugador = (Jugador) ui.getSesion("jugador");
		if (jugador != null) {
			inNombre.setValue(jugador.getNombre());
			Equipo equipo = Fichador.traerEquipoSegunID(jugador.getEquipo());
			inEquipo.setSelectedItem(equipo);
		}
		
		addComponent(inEquipo);
		addComponent(inNombre);
		addComponent(inEquipo);		
		addComponent(crearBotones());
	}

}