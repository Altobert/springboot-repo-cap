package cl.practica3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.practica3.app.entity.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
			
}
