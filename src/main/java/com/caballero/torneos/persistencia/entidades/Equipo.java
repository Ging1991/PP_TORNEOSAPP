package com.caballero.torneos.persistencia.entidades;

public class Equipo {
	private Integer equipoID;
	private String nombre;
	
	public Equipo(Integer equipoID, String nombre) {
		this.equipoID = equipoID;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (equipoID == null) {
			if (other.equipoID != null)
				return false;
		} else if (!equipoID.equals(other.equipoID))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Integer getEquipoID() {
		return equipoID;
	}
	
	public void setEquipoID(Integer equipoID) {
		this.equipoID = equipoID;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}