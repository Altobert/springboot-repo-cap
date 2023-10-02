package cl.practica5.app.repository;

import org.springframework.data.repository.CrudRepository;

import cl.practica5.app.entities.Articulo;

public interface IArticuloRepository extends CrudRepository<Articulo, Integer>{

}
