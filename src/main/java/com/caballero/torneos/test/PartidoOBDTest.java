package com.caballero.torneos.test;

import java.util.List;

import com.caballero.torneos.persistencia.FabricaDAO;
import com.caballero.torneos.persistencia.definidos.EstadoPartido;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;

public class PartidoOBDTest {
	
	public static void insertTest(Partido partido) {
		System.out.println("___ Insert Test");
		PartidoDAO obd = FabricaDAO.crearPartidoOBD();
		obd.insert(partido);
	}
	
	public static void selectTest() {
		System.out.println("___ Select test");
		PartidoDAO obd = FabricaDAO.crearPartidoOBD();
		List<Partido> partidos = obd.select();
		System.out.println("Cantidad: "+partidos.size());
		for (Partido equipo: partidos)
			System.out.println(equipo.getID());
	}
	
	public static void main(String[] args) {
		Partido partido = new Partido(-1, 1, 1, 2, 5, 0, EstadoPartido.JUGADO);
		insertTest(partido);
		selectTest();
	}

}