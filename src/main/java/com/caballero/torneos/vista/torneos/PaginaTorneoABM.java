package com.caballero.torneos.vista.torneos;

import java.util.List;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.vista.PaginaPrincipal;
import com.caballero.torneos.vista.tablas.TablaTorneos;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class PaginaTorneoABM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaTorneoABM";
	private TablaTorneos tabla;
	private ServicioTorneo servicioTorneo;
	
	public PaginaTorneoABM() {
		servicioTorneo = FabricaServicios.crearServicioTorneo();
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
		
		// ACOMODO TODO
		HorizontalLayout botones = new HorizontalLayout();
		botones.addComponent(btnAgregar);
		botones.addComponent(btnEditar);
		botones.addComponent(btnBorrar);
		botones.addComponent(btnVolver);
		return botones;
	}
		
	private void borrar() {
		List<Torneo> torneos = tabla.obtenerSeleccion();
		
		if (torneos.size() == 0)
			Notification.show("No habia ningun torneo seleccionado");
		else if (torneos.size() > 1)
			Notification.show("Habia demasiados torneos seleccionados");
		else {
			Torneo torneo = torneos.get(0);
			servicioTorneo.cancelar(torneo);
			recargar();
		}
	}

	private void agregar() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaTorneoAM.NOMBRE);
	}
	
	private void editar() {
		List<Torneo> torneos = tabla.obtenerSeleccion();
		
		if (torneos.size() == 0)
			Notification.show("No habia ningun torneo seleccionado");
		else if (torneos.size() > 1)
			Notification.show("Habia demasiados torneos seleccionados");
		else {
			Torneo torneo = torneos.get(0);
			AplicacionUI ui = AplicacionUI.getInstancia();
			ui.setSesion("torneo", torneo);
			ui.irPagina(PaginaTorneoAM.NOMBRE);
		}		
	}
	
	private void volver() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaPrincipal.NOMBRE);
	}
	
	private void recargar() {
		removeAllComponents();
		tabla = new TablaTorneos();
		addComponent(tabla);
		addComponent(crearBotones());
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		recargar();
	}

}