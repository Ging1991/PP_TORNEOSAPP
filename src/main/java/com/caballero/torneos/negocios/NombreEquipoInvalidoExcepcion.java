package com.caballero.torneos.negocios;

public class NombreEquipoInvalidoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NombreEquipoInvalidoExcepcion(String mensaje) {
		super(mensaje);
	}

}