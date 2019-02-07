package com.caballero.torneos.test.repositorio;

import com.caballero.torneos.negocios.interfaces.ServicioEquipo;
import com.caballero.torneos.negocios.interfaces.ServicioJugador;
import com.caballero.torneos.negocios.servicios.ServicioEquipoImpl;
import com.caballero.torneos.negocios.servicios.ServicioJugadorImpl;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class FabricaServiciosTest {
	
	public static ServicioEquipo crearEquipoServicio() {
		EquipoDAO obd = new EquipoDAOTest();
		return new ServicioEquipoImpl(obd);
	}
	
	public static ServicioJugador crearJugadorServicio() {
		JugadorDAO obd = new JugadorDAOTest();
		EquipoDAO dao = new EquipoDAOTest();
		return new ServicioJugadorImpl(obd, dao);
	}

}