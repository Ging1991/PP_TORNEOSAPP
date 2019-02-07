package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.DAOMySQL;
import com.caballero.torneos.persistencia.Definido;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class TorneoDAOMySQL extends DAOMySQL implements TorneoDAO{
	private final String campos = "nombre, estado, fecha";
	private final String tabla = "tor_torneos";
	private final String ID = "torneo_ID";
	
	@Override
	public void insert(Torneo torneo) {
		String valores = "'"+torneo.getNombre()+"'"
				+", "+ Definido.estadoTorneo(torneo.getEstado())
				+", '"+torneo.getFecha()+"'";
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}
	
	public void update(Torneo torneo) {
		String condicion = ID +"="+torneo.getID();
		String valores = " nombre = '"+torneo.getNombre()+"'"
				+", estado = "+ Definido.estadoTorneo(torneo.getEstado())
				+", fecha = '"+torneo.getFecha()+"'";
		String consulta = "update "+tabla+" set "+valores+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	public void delete(Torneo torneo) {
		String condicion = ID +"="+torneo.getID();
		String consulta = "delete from "+tabla+" where("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Torneo> select() {
		String condicion = "true";
		return selectByCondicion(condicion);
	}

	@Override
	public Torneo selectByID(int id) {
		return selectUnicoByCondicion("ID = "+id);
	}

	@Override
	public Torneo selectUltimo() {
		int id = selectLastID(tabla);
		return selectByID(id);
	}

	private Torneo selectUnicoByCondicion(String condicion) {
		List<Torneo> seleccion = selectByCondicion(condicion);
		if (!seleccion.isEmpty())
			return seleccion.get(0);
		return null;
	}
	
	private List<Torneo> selectByCondicion(String condicion) {
		List<Torneo> torneos = new ArrayList<Torneo>();
		String comandoSQL = "select "+ID+", "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				torneos.add(new Torneo(
						resultados.getInt(ID),
						resultados.getString("nombre"),
						resultados.getDate("fecha"),
						Definido.estadoTorneo(resultados.getInt("estado"))
						));
				}

			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return torneos;
	}
	
}