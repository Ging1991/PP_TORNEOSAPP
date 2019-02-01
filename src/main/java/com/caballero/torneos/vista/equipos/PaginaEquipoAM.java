package com.caballero.torneos.vista.equipos;

import com.caballero.torneos.AplicacionUI;
import com.caballero.torneos.negocios.Fichador;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PaginaEquipoAM extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	public static String NOMBRE = "PaginaEquipoAM";
	private TextField inNombre;
	private Equipo equipo;
	
	public PaginaEquipoAM() {
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
		String nombre = inNombre.getValue();
		if (equipo == null)
			Fichador.crearEquipo(nombre);
		else {
			equipo.setNombre(nombre);
			Fichador.actualizarEquipo(equipo);
		}
		equipo = null;
		volver();	
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