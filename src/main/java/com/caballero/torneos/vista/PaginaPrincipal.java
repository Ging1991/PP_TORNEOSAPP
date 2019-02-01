package com.caballero.torneos.vista;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.vista.equipos.PaginaEquipoABM;
import com.caballero.torneos.vista.jugadores.PaginaJugadorABM;
import com.caballero.torneos.vista.torneos.PaginaTorneoABM;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class PaginaPrincipal extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaPrincipal";
	
	public PaginaPrincipal() {		
		Button btnTorneos = new Button("Gestionar torneos");
		Button btnJugadores = new Button("Gestionar jugadores");
		Button btnEquipos = new Button("Gestionar equipos");
		
		btnEquipos.addClickListener(e -> {
			AplicacionUI ui = AplicacionUI.getInstancia();
			ui.irPagina(PaginaEquipoABM.NOMBRE);
		});
		
		btnJugadores.addClickListener(e -> {
			AplicacionUI ui = AplicacionUI.getInstancia();
			ui.irPagina(PaginaJugadorABM.NOMBRE);
		});
		
		btnTorneos.addClickListener(e -> {
			AplicacionUI ui = AplicacionUI.getInstancia();
			ui.irPagina(PaginaTorneoABM.NOMBRE);
		});
		
		addComponent(btnTorneos);
		addComponent(btnJugadores);
		addComponent(btnEquipos);
		
	}
		
		
	@Override
	public void enter(ViewChangeEvent event) {}

}