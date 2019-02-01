package com.caballero.torneos.negocios.excepciones;

public class JugadorInvalidoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JugadorInvalidoExcepcion(String mensaje) {
		super(mensaje);
	}

}