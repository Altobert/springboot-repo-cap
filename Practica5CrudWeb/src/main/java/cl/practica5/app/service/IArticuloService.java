package cl.practica5.app.service;

import java.util.List;

import cl.practica5.app.entities.Articulo;

public interface IArticuloService {
	
	public List<Articulo> findAll();
	
	public Articulo findById(int id);
	
	public Articulo save(Articulo articulo);
	
	public void delete();
	
}
