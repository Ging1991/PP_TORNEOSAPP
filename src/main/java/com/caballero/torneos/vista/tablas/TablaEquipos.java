package com.caballero.torneos.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.entidades.Equipo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;

public class TablaEquipos extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	Grid<Equipo> grilla;

	public TablaEquipos(List<Equipo> equipos) {
		grilla = new Grid<Equipo>();
		grilla.setSelectionMode(SelectionMode.SINGLE);
		grilla.setItems(equipos);
		grilla.addColumn(Equipo::getNombre).setCaption("Nombre");
		addComponent(grilla);
		setComponentAlignment(grilla, Alignment.MIDDLE_CENTER);
	}
	
	public List<Equipo> obtenerSeleccion() {
		List<Equipo> lista = new ArrayList<Equipo>();
		lista.addAll(grilla.getSelectedItems());
		return lista;
	}
	
}