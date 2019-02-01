package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.OBDMySQL;
import com.caballero.torneos.persistencia.entidades.Jugador;
import com.caballero.torneos.persistencia.interfaces.JugadorOBD;

public class JugadorODBMySQL extends OBDMySQL implements JugadorOBD{
	private final String campos = "nombre, equipo";
	private final String tabla = "tor_jugadores";
	private final String ID = "jugador_ID";
	
	@Override
	public void insert(Jugador jugador) {
		String valores = "'"+jugador.getNombre()+"', "+jugador.getEquipo();
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}

	public void update(Jugador jugador) {
		String condicion = ID +"="+jugador.getJugadorID();
		String valores = " nombre = '"+jugador.getNombre()+"'"
				+", equipo = "+jugador.getEquipo();
		String consulta = "update "+tabla+" set "+valores+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	public void delete(Jugador jugador) {
		String condicion = ID +"="+jugador.getJugadorID();
		String consulta = "delete from "+tabla+" where("+condicion+");";
		ejecutarSQL(consulta);
	}
	
	@Override
	public List<Jugador> select() {
		String condicion = "1=1";
		return selectByCondicion(condicion);
	}
	
	@Override
	public Jugador selectByID(Integer id) {
		String condicion = ID+"="+id;
		List<Jugador> jugadores = selectByCondicion(condicion);
		if ( jugadores.size()>0)
			return jugadores.get(0);
		return null;
	}

	private List<Jugador> selectByCondicion(String condicion) {
		List<Jugador> equipos = new ArrayList<Jugador>();
		String comandoSQL = "select "+ID+", "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				equipos.add(new Jugador(
						resultados.getInt(ID),
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
			
		return equipos;
	}
	
}