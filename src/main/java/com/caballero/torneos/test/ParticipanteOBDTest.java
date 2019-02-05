package com.caballero.torneos.test;

import java.util.List;

import com.caballero.torneos.persistencia.FabricaOBD;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.interfaces.ParticipanteOBD;

public class ParticipanteOBDTest {
	
	public static void insertTest(Participante participante) {
		System.out.println("___ Insert Test");
		ParticipanteOBD obd = FabricaOBD.crearParticipanteOBD();
		obd.insert(participante);
	}
	
	public static void selectTest() {
		System.out.println("___ Select test");
		ParticipanteOBD obd = FabricaOBD.crearParticipanteOBD();
		List<Participante> participantes = obd.select();
		System.out.println("Cantidad: "+participantes.size());
		for (Participante participante: participantes)
			System.out.println(participante.getID());
	}
	
	public static void main(String[] args) {
		Participante participante = new Participante(-1, 1, 1, 0);
		insertTest(participante);
		selectTest();
	}

}