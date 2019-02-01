package com.caballero.torneos.persistencia.entidades;

import com.caballero.torneos.persistencia.definidos.EstadoPartido;

public class Partido {
	private Integer partidoID, torneo, local, visitante, marcadorLocal, marcadorVisitante;
	private EstadoPartido estado;
	
	public Partido(Integer partidoID, Integer torneo, Integer local, Integer visitante, Integer marcadorLocal,
			Integer marcadorVisitante, EstadoPartido estado) {
		this.partidoID = partidoID;
		this.torneo = torneo;
		this.local = local;
		this.visitante = visitante;
		this.marcadorLocal = marcadorLocal;
		this.marcadorVisitante = marcadorVisitante;
		this.estado = estado;
	}

	public Integer getPartidoID() {
		return partidoID;
	}

	public void setPartidoID(Integer partidoID) {
		this.partidoID = partidoID;
	}

	public Integer getTorneo() {
		return torneo;
	}

	public void setTorneo(Integer torneo) {
		this.torneo = torneo;
	}

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}

	public Integer getVisitante() {
		return visitante;
	}

	public void setVisitante(Integer visitante) {
		this.visitante = visitante;
	}

	public Integer getMarcadorLocal() {
		return marcadorLocal;
	}

	public void setMarcadorLocal(Integer marcadorLocal) {
		this.marcadorLocal = marcadorLocal;
	}

	public Integer getMarcadorVisitante() {
		return marcadorVisitante;
	}

	public void setMarcadorVisitante(Integer marcadorVisitante) {
		this.marcadorVisitante = marcadorVisitante;
	}

	public EstadoPartido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPartido estado) {
		this.estado = estado;
	}
	
}