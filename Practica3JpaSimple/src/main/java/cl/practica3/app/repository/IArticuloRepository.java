package cl.practica3.app.repository;

import org.springframework.data.repository.CrudRepository;

import cl.practica3.app.entities.Articulo;

//Se crea interfaz por la injeccion de dependencia
//(spring boot)Si quieres hacer un crud, yo te lo doy
//me permite tener la implementacion, para crear los metodos crud
public interface IArticuloRepository extends CrudRepository<Articulo, Integer>{
	
	//save() 
	//delete(), 
	//find(),
	//update()

}
