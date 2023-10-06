package cl.practica5.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import cl.practica5.app.entities.Articulo;
import cl.practica5.app.repository.IArticuloRepository;



//Service implementa un sigleton
//Solamente puede haber una instancia de esta aplicacion.
//Esto es backend, aca no van respuestas 
@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	@Autowired
	private IArticuloRepository articuloRepository;

	@Override
	@Transactional
	public List<Articulo> findAll() {
		
		List<Articulo> listArticulo = (List<Articulo>) articuloRepository.findAll();
		
		return listArticulo;
	}

	@Override
	@Transactional(readOnly=true)	
	public Articulo findById(int id) {
		// TODO Auto-generated method stub
		
		Articulo articulo =  articuloRepository.findById(id).orElse(null);
		return null;
	}

	@Override
	@Transactional
	public Articulo save(Articulo articulo) {
		// TODO Auto-generated method stub
		articuloRepository.save(articulo);
		
		return null;
	}

	@Override
	@Transactional
	public void delete(Integer id)  {
		// TODO Auto-generated method stub
		try {
			articuloRepository.deleteById(null);
		} catch (Exception e) {
			// TODO: handle exception
			//No es buena practica realizar esto.
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo no encontrado");
		}
		
	}
	

}
