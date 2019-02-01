package com.caballero.torneos.negocios.excepciones;

public class NombreEquipoInvalidoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NombreEquipoInvalidoExcepcion(String mensaje) {
		super(mensaje);
	}

}