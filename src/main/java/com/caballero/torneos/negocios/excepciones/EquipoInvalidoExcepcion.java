package com.caballero.torneos.negocios.excepciones;

public class EquipoInvalidoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EquipoInvalidoExcepcion(String mensaje) {
		super(mensaje);
	}

}