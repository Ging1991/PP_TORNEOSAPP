package com.caballero.torneos.test;

import java.util.List;
import com.caballero.torneos.persistencia.Factory;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.interfaces.EquipoOBD;

public class EquipoOBDTest {
	
	public static void insertTest(String nombre) {
		System.out.println("___ Insert Test: "+nombre);
		EquipoOBD obd = Factory.crearEquipoOBD();
		obd.insert(new Equipo(-1, nombre));
	}
	
	public static void selectTest() {
		System.out.println("___ Select test");
		EquipoOBD obd = Factory.crearEquipoOBD();
		List<Equipo> equipos = obd.select();
		System.out.println("Cantidad: "+equipos.size());
		for (Equipo equipo: equipos)
			System.out.println(equipo.getNombre());
	}
	
	public static void main(String[] args) {
		insertTest("San Lorenzo");
		selectTest();
	}

}