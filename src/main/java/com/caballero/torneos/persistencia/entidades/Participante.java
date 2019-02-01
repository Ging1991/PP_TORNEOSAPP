package com.caballero.torneos.persistencia.entidades;

public class Participante {
	private Integer participanteID, torneo, jugador, derrotas;

	public Participante(Integer participanteID, Integer torneo, Integer jugador, Integer derrotas) {
		this.participanteID = participanteID;
		this.torneo = torneo;
		this.jugador = jugador;
		this.derrotas = derrotas;
	}

	public Integer getParticipanteID() {
		return participanteID;
	}

	public void setParticipanteID(Integer participanteID) {
		this.participanteID = participanteID;
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