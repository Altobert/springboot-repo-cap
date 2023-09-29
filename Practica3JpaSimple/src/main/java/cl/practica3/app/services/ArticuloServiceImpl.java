package cl.practica3.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.practica3.app.entities.Articulo;
import cl.practica3.app.repository.IArticuloRepository;

//Clase de servicio, logica de negocio, transacciones
@Service
public class ArticuloServiceImpl implements IArticuloService{

	//es una interfaz no se puede instancias
	//spring utiliza la injeccion
	//en tiempo de ejecucion el servidor crea una clase que implementa la interfaz
	//se utiliza el polimorfismo para convertir la interfaz en una clase.
	//Por medio de la injeccion de dependencias se puede utilizar una interfaz 
	//y en tiempo de ejecucion se pasa a clase, o se crea un bean de eso.	
	@Autowired
	private IArticuloRepository articuloRepository;
	
	@Override
	public List<Articulo> findAll() {
		// TODO Auto-generated method stub
		List<Articulo> lArticulo = (List<Articulo>) articuloRepository.findAll();		
		return lArticulo;		
	}

}
