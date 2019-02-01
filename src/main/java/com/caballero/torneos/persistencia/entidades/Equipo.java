package com.caballero.torneos.persistencia.entidades;

public class Equipo {
	private Integer ID;
	private String nombre;
	
	public Equipo(Integer ID, String nombre) {
		this.ID = ID;
		this.nombre = nombre;
	}

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}