package com.caballero.torneos.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caballero.torneos.persistencia.DAOMySQL;
import com.caballero.torneos.persistencia.entidades.Equipo;
import com.caballero.torneos.persistencia.interfaces.EquipoDAO;

public class EquipoDAOMySQL extends DAOMySQL implements EquipoDAO{
	private final String campos = "nombre";
	private final String tabla = "tor_equipos";
	
	@Override
	public void insert(Equipo equipo) {
		String valores = "'"+equipo.getNombre()+"'";
		String consulta = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(consulta);
	}

	public void update(Equipo equipo) {
		String condicion = "ID = "+equipo.getID();
		String valores = " nombre = '"+equipo.getNombre()+"'";
		String consulta = "update "+tabla+" set "+valores+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	public void delete(Equipo equipo) {
		String condicion = "ID = "+equipo.getID();
		String consulta = "delete from "+tabla+" where("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Equipo> select() {
		String condicion = "true";
		return selectByCondicion(condicion);
	}

	@Override
	public Equipo selectByID(int id) {
		String condicion = "ID = "+id;
		List<Equipo> equipos = selectByCondicion(condicion);
		if (equipos.size() > 0)
			return equipos.get(0);
		return null;
	}

	@Override
	public Equipo selectUltimo() {
		Integer id = selectLastID("ID", tabla);
		return selectByID(id);
	}
	

	@Override
	public Equipo selectByNombre(String nombre) {
		return selectUnicoByCondicion("nombre = "+nombre);
	}
	
	private Equipo selectUnicoByCondicion(String condicion) {
		List<Equipo> equipos = selectByCondicion(condicion);
		if (!equipos.isEmpty())
			return equipos.get(0);
		return null;
	}
	
	private List<Equipo> selectByCondicion(String condicion) {
		List<Equipo> equipos = new ArrayList<Equipo>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			
	
			while (resultados.next()) {
				equipos.add(new Equipo(
						resultados.getInt("ID"),
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