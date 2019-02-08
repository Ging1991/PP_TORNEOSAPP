package com.caballero.torneos.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.negocios.FabricaServicios;
import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.VerticalLayout;

public class TablaJugadores extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	Grid<Jugador> grilla;
	private ServicioEquipo servicioEquipo;

	public TablaJugadores(List<Jugador> jugadores) {
		servicioEquipo = FabricaServicios.crearEquipoServicio();
		grilla = new Grid<Jugador>();
		grilla.setSelectionMode(SelectionMode.MULTI);
		recargar(jugadores);
		addComponent(grilla);
		setComponentAlignment(grilla, Alignment.MIDDLE_CENTER);
	}
	
	public void recargar(List<Jugador> jugadores) {
		grilla.removeAllColumns();
		grilla.setItems(jugadores);
		grilla.addColumn(Jugador::getNombre).setCaption("Nombre");
		Column<Jugador, Integer> columna = grilla.addColumn(Jugador::getEquipo);
		//columna.setRenderer(equipo -> (servicioEquipo.traerPorID(jugador.getEquipo() , new TextRenderer())));
		columna.setCaption("Equipo");
	}
	
	public List<Jugador> obtenerSeleccion() {
		List<Jugador> lista = new ArrayList<Jugador>();
		lista.addAll(grilla.getSelectedItems());
		return lista;
	}
	
	public void setSeleccion(List<Jugador> jugadores) {
		
	}
	
}