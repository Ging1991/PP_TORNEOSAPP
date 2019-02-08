package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.DAOMySQL;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.entidades.Participante;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.ParticipanteDAO;

public class ParticipanteDAOMySQL extends DAOMySQL implements ParticipanteDAO{
	private final String campos = "torneo, jugador, derrotas";
	private final String tabla = "tor_participantes";
	
	@Override
	public void insert(Participante participante) {
		String valores = participante.getTorneo()
				+", "+participante.getJugador()
				+", "+participante.getDerrotas();
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void update(Participante participante) {
		String condicion = "ID = "+participante.getID();
		String valores = "set torneo = " + participante.getTorneo()
				+ "set jugador = " + participante.getJugador()
				+ "set derrotas = " + participante.getDerrotas();
		String consulta = "update "+tabla+" set "+valores+" where ("+condicion+");";
		ejecutarSQL(consulta);
		
	}

	@Override
	public void delete(Participante participante) {
		String condicion = "ID = "+participante.getID();
		String consulta = "delete from "+tabla+" where("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Participante> select() {
		String condicion = "true";
		return selectByCondicion(condicion);
	}

	@Override
	public Participante selectByID(int id) {
		return selectUnicoByCondicion("ID = "+id);
	}

	@Override
	public Participante selectUltimo() {
		int id = selectLastID(tabla);
		return selectByID(id);
	}
	
	@Override
	public List<Participante> selectByTorneo(Torneo torneo) {
		String condicion = "torneo = " + torneo.getID();
		return selectByCondicion(condicion);
	}
	
	@Override
	public List<Participante> selectByJugador(Jugador jugador) {
		String condicion = "jugador = " + jugador.getID();
		return selectByCondicion(condicion);
	}
	
	@Override
	public List<Participante> selectByTorneoDerrotas(Torneo torneo, int derrotas) {
		String condicion = "torneo = " + torneo.getID()+ " and derrotas = "+derrotas;
		return selectByCondicion(condicion);
	}

	private Participante selectUnicoByCondicion(String condicion) {
		List<Participante> seleccion = selectByCondicion(condicion);
		if (!seleccion.isEmpty())
			return seleccion.get(0);
		return null;
	}
	
	private List<Participante> selectByCondicion(String condicion) {
		List<Participante> equipos = new ArrayList<Participante>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				equipos.add(new Participante(
						resultados.getInt("ID"),
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