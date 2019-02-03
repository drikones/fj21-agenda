package br.com.caelum.jdbc;

import java.util.List;


public interface CRUD<T> {
	
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public List<T> getList();

}
