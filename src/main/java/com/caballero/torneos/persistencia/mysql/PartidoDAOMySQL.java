package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.DAOMySQL;
import com.caballero.torneos.persistencia.Definido;
import com.caballero.torneos.persistencia.entidades.Partido;
import com.caballero.torneos.persistencia.interfaces.PartidoDAO;

public class PartidoDAOMySQL extends DAOMySQL implements PartidoDAO{
	private final String campos = "torneo, local, visitante, estado, goles_local, goles_visitante";
	private final String tabla = "tor_partidos";
	
	@Override
	public void insert(Partido partido) {
		String valores = partido.getTorneo()
				+", "+partido.getLocal()
				+", "+partido.getVisitante()
				+", "+Definido.estadoPartido(partido.getEstado())
				+", "+partido.getMarcadorLocal()
				+", "+partido.getMarcadorVisitante();
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void update(Partido partido) {
		String condicion = "ID = "+partido.getID();
		String valores = "set torneo = " + partido.getTorneo()
				+ "set local = " + partido.getLocal()
				+ "set visitante = " + partido.getVisitante()
				+ "set goles_local = " + partido.getMarcadorLocal()
				+ "set goles_visitante= " + partido.getMarcadorVisitante();
		String consulta = "update "+tabla+" set "+valores+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Partido partido) {
		String condicion = "ID = "+partido.getID();
		String consulta = "delete from "+tabla+" where("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Partido> select() {
		String condicion = "true";
		return selectByCondicion(condicion);
	}
	
	@Override
	public Partido selectByID(int id) {
		return selectUnicoByCondicion("ID = "+id);
	}

	@Override
	public Partido selectUltimo() {
		int id = selectLastID(tabla);
		return selectByID(id);
	}

	private Partido selectUnicoByCondicion(String condicion) {
		List<Partido> seleccion = selectByCondicion(condicion);
		if (!seleccion.isEmpty())
			return seleccion.get(0);
		return null;
	}
	
	private List<Partido> selectByCondicion(String condicion) {
		List<Partido> equipos = new ArrayList<Partido>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				equipos.add(new Partido(
						resultados.getInt("ID"),
						resultados.getInt("torneo"),
						resultados.getInt("local"),
						resultados.getInt("visitante"),
						resultados.getInt("goles_local"),
						resultados.getInt("goles_visitante"),
						Definido.estadoPartido(resultados.getInt("estado"))
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