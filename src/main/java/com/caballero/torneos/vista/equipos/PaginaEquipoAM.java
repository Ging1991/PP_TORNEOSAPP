package com.caballero.torneos.vista.equipos;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.excepciones.EquipoInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PaginaEquipoAM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaEquipoAM";
	private TextField inNombre;
	private Equipo equipo;
	private ServicioEquipo servicio;
	
	public PaginaEquipoAM() {
		servicio = FabricaServicios.crearEquipoServicio();
		
		// ENTRADAS DE TEXTO
		inNombre = new TextField("Nombre");
		
		// BOTONES
		Button btnAceptar = new Button("Aceptar");
		btnAceptar.addClickListener(e -> {
			aceptar();
		});

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.addClickListener(e -> {
			volver();
		});

		addComponent(inNombre);
		addComponent(btnAceptar);
		addComponent(btnCancelar);		
	}
	
	private void aceptar() {
		try {
			String nombre = inNombre.getValue();
			Equipo nuevo = new Equipo(-1, nombre);
			
			
			if (equipo == null)
				servicio.agregar(nuevo);
			else {
				equipo.setNombre(nombre);
				servicio.modificar(equipo);
			}
			equipo = null;
			volver();
			
		} catch (EquipoInvalidoExcepcion e) {
			Notification.show(e.getMessage());
		}	
	}
	
	private void volver() {
		AplicacionUI ui = AplicacionUI.getInstancia();
		ui.irPagina(PaginaEquipoABM.NOMBRE);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		inNombre.setValue("");
		AplicacionUI ui = AplicacionUI.getInstancia();
		equipo = (Equipo) ui.getSesion("equipo");
		if (equipo != null)
			inNombre.setValue(equipo.getNombre());
	}

}