package com.caballero.torneos.test;

import java.util.List;
import com.caballero.torneos.negocios.Almanaque;
import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.definidos.EstadoTorneo;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class TorneoOBDTest {
	
	public static void insertTest(String nombre) {
		System.out.println("___ Insert Test: "+nombre);
		TorneoDAO obd = FabricaDAO.crearTorneoOBD();
		obd.insert(new Torneo(-1, nombre, Almanaque.hoy(), EstadoTorneo.JUGANDO));
	}
	
	public static void selectTest() {
		System.out.println("___ Select test");
		TorneoDAO obd = FabricaDAO.crearTorneoOBD();
		List<Torneo> torneos = obd.select();
		System.out.println("Cantidad: "+torneos.size());
		for (Torneo torneo: torneos)
			System.out.println(torneo.getNombre());
	}
	
	public static void main(String[] args) {
		insertTest("Torneo la copa de la fortuna");
		selectTest();
	}

}