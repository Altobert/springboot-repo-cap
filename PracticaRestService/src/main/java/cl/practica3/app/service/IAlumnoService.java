package cl.practica3.app.service;

import java.util.List;

import cl.practica3.app.entity.Alumno;


public interface IAlumnoService {
	
	public Alumno save(Alumno a);
	
	public List<Alumno> findAll();
	
	public boolean delete(Integer id);
	
	public Alumno update(Alumno alumno);

}
