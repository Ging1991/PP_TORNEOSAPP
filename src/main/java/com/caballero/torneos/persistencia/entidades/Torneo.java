package com.caballero.torneos.persistencia.entidades;

import java.sql.Date;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;

public class Torneo {
	private Integer ID;
	private String nombre;
	private Date fecha;
	private EstadoTorneo estado;
	
	public Torneo(Integer ID, String nombre, Date fecha, EstadoTorneo estado) {
		this.ID = ID;
		this.nombre = nombre;
		this.fecha = fecha;
		this.estado = estado;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoTorneo getEstado() {
		return estado;
	}

	public void setEstado(EstadoTorneo estado) {
		this.estado = estado;
	}

}