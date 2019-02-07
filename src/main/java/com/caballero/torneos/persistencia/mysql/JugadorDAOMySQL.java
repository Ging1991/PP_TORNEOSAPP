package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.DAOMySQL;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.JugadorDAO;

public class JugadorDAOMySQL extends DAOMySQL implements JugadorDAO{
	private final String campos = "nombre, equipo";
	private final String tabla = "tor_jugadores";
	
	@Override
	public void insert(Jugador jugador) {
		String valores = "'"+jugador.getNombre()+"', "+jugador.getEquipo();
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}

	public void update(Jugador jugador) {
		String condicion = "ID = "+jugador.getID();
		String valores = " nombre = '"+jugador.getNombre()+"'"
				+", equipo = "+jugador.getEquipo();
		String consulta = "update "+tabla+" set "+valores+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	public void delete(Jugador jugador) {
		String condicion = "ID = "+jugador.getID();
		String consulta = "delete from "+tabla+" where("+condicion+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public List<Jugador> select() {
		String condicion = "true";
		return selectByCondicion(condicion);
	}
	
	@Override
	public Jugador selectByID(int id) {
		String condicion = "ID = "+id;
		List<Jugador> jugadores = selectByCondicion(condicion);
		if ( jugadores.size()>0)
			return jugadores.get(0);
		return null;
	}

	@Override
	public Jugador selectUltimo() {
		int id = selectLastID(tabla);
		return selectByID(id);
	}
	
	@Override
	public Jugador selectByNombre(String nombre) {
		return selectUnicoByCondicion("nombre = "+nombre);
	}
	
	private Jugador selectUnicoByCondicion(String condicion) {
		List<Jugador> equipos = selectByCondicion(condicion);
		if (!equipos.isEmpty())
			return equipos.get(0);
		return null;
	}
	
	
	private List<Jugador> selectByCondicion(String condicion) {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				jugadores.add(new Jugador(
						resultados.getInt("ID"),
						resultados.getInt("equipo"),
						resultados.getString("nombre")
						));
				}
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return jugadores;
	}

	
}