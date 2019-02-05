package com.caballero.torneos.persistencia.entidades;

public class Jugador {
	private Integer ID, equipo;
	private String nombre;

	public Jugador(Integer ID, Integer equipo, String nombre) {
		this.ID = ID;
		this.equipo = equipo;
		this.nombre = nombre;
	}
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer ID) {
		this.ID = ID;
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