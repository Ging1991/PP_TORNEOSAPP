package com.caballero.torneos.vista.equipos;

import java.util.List;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.Fichador;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.vista.PaginaPrincipal;
import com.caballero.torneos.vista.tablas.TablaEquipos;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class PaginaEquipoABM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaEquipoABM";
	private TablaEquipos tabla;
	private ServicioEquipo equipoServicio;
	
	public PaginaEquipoABM() {
		equipoServicio = FabricaServicios.crearEquipoServicio();
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
		List<Equipo> equipos = tabla.obtenerSeleccion();
		
		if (equipos.size() == 0)
			Notification.show("No habia ningun equipo seleccionado");
		else if (equipos.size() > 1)
			Notification.show("Habia demasiados equipos seleccionados");
		else {
			Equipo equipo = equipos.get(0);
			Fichador.borrarEquipo(equipo);
			recargar();
		}
	}

	private void agregar() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaEquipoAM.NOMBRE);
	}
	
	private void editar() {
		List<Equipo> equipos = tabla.obtenerSeleccion();
		
		if (equipos.size() == 0)
			Notification.show("No habia ningun equipo seleccionado");
		else if (equipos.size() > 1)
			Notification.show("Habia demasiados equipos seleccionados");
		else {
			AplicacionUI ui = AplicacionUI.getInstancia();
			Equipo equipo = equipos.get(0);
			ui.setSesion("equipo", equipo);
			ui.irPagina(PaginaEquipoAM.NOMBRE);
		}		
	}
	
	private void volver() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaPrincipal.NOMBRE);
	}
	
	private void recargar() {
		removeAllComponents();
		tabla = new TablaEquipos(equipoServicio.traerTodo());
		addComponent(tabla);
		addComponent(crearBotones());
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		recargar();
	}

}