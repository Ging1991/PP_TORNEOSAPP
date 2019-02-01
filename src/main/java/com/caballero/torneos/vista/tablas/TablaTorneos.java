package com.caballero.torneos.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.negocios.Organizador;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;

public class TablaTorneos extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	Grid<Torneo> grilla;

	public TablaTorneos() {
		List<Torneo> torneos = Organizador.traerTorneos();
		grilla = new Grid<Torneo>();
		grilla.setSelectionMode(SelectionMode.SINGLE);
		grilla.setItems(torneos);
		grilla.addColumn(Torneo::getNombre).setCaption("Nombre");
		addComponent(grilla);
		setComponentAlignment(grilla, Alignment.MIDDLE_CENTER);
	}
	
	public List<Torneo> obtenerSeleccion() {
		List<Torneo> lista = new ArrayList<Torneo>();
		lista.addAll(grilla.getSelectedItems());
		return lista;
	}
	
}