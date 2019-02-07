package com.caballero.torneos.persistencia;

import com.caballero.torneos.persistencia.definidos.EstadoPartido;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;

public class Definido {
	
	public static EstadoTorneo estadoTorneo(Integer estado) {
		EstadoTorneo ret = null;
		if (estado == 1)
			ret = EstadoTorneo.CURSO;
		else if (estado == 2)
			ret = EstadoTorneo.TERMINADO;
		return ret;
	}

	public static Integer estadoTorneo(EstadoTorneo estado) {
		Integer ret = null;
		if (estado == EstadoTorneo.CURSO)
			ret = 1;
		else if (estado == EstadoTorneo.TERMINADO)
			ret = 2;
		return ret;
	}

	public static EstadoPartido estadoPartido(Integer estado) {
		EstadoPartido ret = null;
		if (estado == 1)
			ret = EstadoPartido.PENDIENTE;
		else if (estado == 2)
			ret = EstadoPartido.JUGADO;
		return ret;
	}

	public static Integer estadoPartido(EstadoPartido estado) {
		Integer ret = null;
		if (estado == EstadoPartido.PENDIENTE)
			ret = 1;
		else if (estado == EstadoPartido.JUGADO)
			ret = 2;
		return ret;
	}
	
}