package com.caballero.torneos.negocios.servicios;

import com.caballero.torneos.negocios.excepciones.JugadorInvalidoExcepcion;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class JugadorServicioImpl implements JugadorServicio {
	private JugadorDAO obd;

	public JugadorServicioImpl(JugadorDAO obd) {
		this.obd = obd;
	}

	@Override
	public boolean agregarJugador(Jugador jugador) throws JugadorInvalidoExcepcion {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarJugador(Jugador jugador) throws JugadorInvalidoExcepcion {
		// TODO Auto-generated method stub
		return false;
	}

}
