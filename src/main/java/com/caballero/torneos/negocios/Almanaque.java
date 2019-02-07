package com.caballero.torneos.negocios;

import java.sql.Date;

public class Almanaque {

	public static Date hoy() {
		return new Date(new java.util.Date().getTime());
	}

}