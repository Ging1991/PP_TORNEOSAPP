package com.caballero.torneos.persistencia.interfaces;

import java.util.List;

public interface CRUD<T> {

	public void insert(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public List<T> select();
	
	public T selectByID(int id);

	public T selectUltimo();
	
}