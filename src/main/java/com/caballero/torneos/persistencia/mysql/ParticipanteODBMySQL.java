package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.caballero.torneos.persistencia.OBDMySQL;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteOBD;

public class ParticipanteODBMySQL extends OBDMySQL implements ParticipanteOBD{
	private final String campos = "torneo, jugador, derrotas";
	private final String tabla = "tor_participantes";
	private final String ID = "participante_ID";
	
	@Override
	public void insert(Participante participante) {
		String valores = participante.getTorneo()
				+", "+participante.getJugador()
				+", "+participante.getDerrotas();
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Participante> select() {
		String condicion = "1=1";
		return selectByCondicion(condicion);
	}

	@Override
	public List<Participante> selectByTorneo(Torneo torneo) {
		String condicion = ID+"="+torneo.getID();
		return selectByCondicion(condicion);
	}

	private List<Participante> selectByCondicion(String condicion) {
		List<Participante> equipos = new ArrayList<Participante>();
		String comandoSQL = "select "+ID+", "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				equipos.add(new Participante(
						resultados.getInt(ID),
						resultados.getInt("torneo"),
						resultados.getInt("jugador"),
						resultados.getInt("derrotas")
						));
				}

			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return equipos;
	}
	
}