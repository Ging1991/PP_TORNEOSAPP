package com.caballero.torneos.persistencia.entidades;

public class Participante {
	private Integer ID, torneo, jugador, derrotas;

	public Participante(Integer ID, Integer torneo, Integer jugador, Integer derrotas) {
		this.ID = ID;
		this.torneo = torneo;
		this.jugador = jugador;
		this.derrotas = derrotas;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Integer getTorneo() {
		return torneo;
	}

	public void setTorneo(Integer torneo) {
		this.torneo = torneo;
	}

	public Integer getJugador() {
		return jugador;
	}

	public void setJugador(Integer jugador) {
		this.jugador = jugador;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
		
}