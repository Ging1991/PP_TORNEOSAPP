package com.caballero.torneos.persistencia.entidades;

public class Jugador {
	private Integer jugadorID, equipo;
	private String nombre;

	public Jugador(Integer jugadorID, Integer equipo, String nombre) {
		this.jugadorID = jugadorID;
		this.equipo = equipo;
		this.nombre = nombre;
	}
	
	public Integer getJugadorID() {
		return jugadorID;
	}
	
	public void setJugadorID(Integer jugadorID) {
		this.jugadorID = jugadorID;
	}
	
	public Integer getEquipo() {
		return equipo;
	}
	
	public void setEquipo(Integer equipo) {
		this.equipo = equipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}