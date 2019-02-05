package com.caballero.torneos.test.repositorio;

import com.caballero.torneos.negocios.interfaces.EquipoServicio;
import com.caballero.torneos.negocios.interfaces.JugadorServicio;
import com.caballero.torneos.negocios.servicios.EquipoServicioImpl;
import com.caballero.torneos.negocios.servicios.JugadorServicioImpl;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class FabricaServiciosTest {
	
	public static EquipoServicio crearEquipoServicio() {
		EquipoDAO obd = new EquipoDAOTest();
		return new EquipoServicioImpl(obd);
	}
	
	public static JugadorServicio crearJugadorServicio() {
		JugadorDAO obd = new JugadorDAOTest();
		EquipoDAO dao = new EquipoDAOTest();
		return new JugadorServicioImpl(obd, dao);
	}

}