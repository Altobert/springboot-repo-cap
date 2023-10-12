package cl.sii.app;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import cl.sii.app.model.Categoria;
import cl.sii.app.repository.CategoriasRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriasRepository repo;
	

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		//guardarTodas();
		//buscarTodosJPA();
		//borrarTodoJPA();
		//buscarTodosOrdenados();
		
		buscarTodosPaginados();
		buscarTodosPaginacionOrdenados();
		
		/*guardarTodas();
		guardar();
		conteo();*/
		//conteo();
		/*buscarTodos();
		existeId();
		encontrarPorIds();*/
		
		//modificar();
		
		//buscarPorId();
		
		//eliminar();
		
		//eliminarTodos();
		
	}
	
	/**
	 * Metodo saveAll - Interfaz CrudRepository
	 */
	private void guardarTodas() {
		List<Categoria> categorias = getListaCategorias();
		repo.saveAll(categorias);
	}
	
	/**
	 * Metodo existsById - Interfaz CrudRepository
	 */
	private void existeId() {
		
		Boolean existe = repo.existsById(100);
		System.out.println("la categoria existe: "+existe);
	}
	
	/**
	 * Metodo findAll - Interfaz CrudRepository
	 */
	private void buscarTodos() {
		
		Iterable<Categoria> cateogoras =   repo.findAll();
		for (Categoria categoria : cateogoras) {
			System.out.println(categoria);
		}
	}
	
	/**
	 * Metodo findAllById - Interfaz CrudRepository
	 */
	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		
		ids.add(10);
		ids.add(11);
		ids.add(12);
		
		//si no encuentra, no lo muestra.
		Iterable<Categoria> categorias =   repo.findAllById(ids);
		for (Categoria categoria : categorias) {
			System.out.println("encontrado: "+categoria);
		}

	}
	
	/**
	 * Metodo deleteAll - Interfaz CrudRepository
	 */
	private void eliminarTodos() {
	
		repo.deleteAll();
	}
	
	/**
	 * Metodo count - Interfaz CrudRepository
	 */
	private void conteo() {
		long contador  = repo.count();
		System.out.println("cantidad de registros: "+contador);
	}
	
	/**
	 * Metodo deleteById - Interfaz CrudRepository
	 */
	private void eliminar() {

		int idCategoria = 10;
		repo.deleteById(idCategoria);		
		
	}
	
	/**
	 * Metodo save(update) - Interfaz CrudRepository
	 */
	private void modificar() {
		
		Optional<Categoria> optCategoria =  repo.findById(10);
		if(optCategoria.isPresent()) {
			
			Categoria catTemp = optCategoria.get();
			catTemp.setNombre("Programador Java");
			catTemp.setDescripcion("Trabajos asociados a programacion");
			
			repo.save(catTemp);
			
		}else {
			
			System.out.println("No se econtro nada");
		}

	}
	
	/**
	 * Metodo findById - Interfaz CrudRepository
	 */
	private void buscarPorId() {
		
		Optional<Categoria> optCategoria =  repo.findById(10);
		if(optCategoria.isPresent()) {
			
			System.out.println(optCategoria.get());
			
		}else {
			
			System.out.println("No se encontro categoria");
		}

	}
	
	/**
	 * Metodo save - Interfaz CrudRepository
	 */
	private void guardar() {
		Categoria cat = new Categoria();
		cat.setNombre("RRHH");
		cat.setDescripcion("trabajos relacionados a RRHH");
		repo.save(cat);
	
	}
	
	/**
	 * Metodo que regresa una lista de 3 Categorias
	 * @return
	 */
	private List<Categoria> getListaCategorias(){
		List<Categoria> lista = new LinkedList<Categoria>();
		Categoria cat1 = new Categoria();
		cat1.setNombre("Programador de nodeJs");
		cat1.setDescripcion("Trabajo relacionado backen node");
		
		Categoria cat2 = new Categoria();
		cat2.setNombre("Fotocopiador");
		cat2.setDescripcion("Dueño de fotocopiadora");
		
		Categoria cat3 = new Categoria();
		cat3.setNombre("Literato");
		cat3.setDescripcion("Escritor de porqueria");
		
		Categoria cat4 = new Categoria();
		cat4.setNombre("Dibujante");
		cat4.setDescripcion("Realiza tatoo en restaurant a gente en estado etilico");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		
		return lista;
	}
	
	//CrudRepository
	
	//JpaRepository
	
	private void buscarTodosJPA() {
		List<Categoria> listCategorias =  repo.findAll();
		for (Categoria categoria : listCategorias) {
			System.out.println("Categoria: "+categoria.getId()+" Nombre: "+categoria.getNombre());
		}
	}
	
	/**
	 * 
	 */
	private void borrarTodoJPA() {
		repo.deleteAllInBatch();
		System.out.println("Datos que quedan en BDD: "+repo.count());
	}
	
	
	/**
	 * 
	 */
	private void buscarTodosOrdenados() {
		List<Categoria> listCategorias = repo.findAll(Sort.by("nombre").descending());
		for (Categoria categoria : listCategorias) {
			System.out.println(categoria.getId()+" : "+categoria.getNombre());
		}
	}
	
	/**
	 * 
	 * 	 */
	private void buscarTodosPaginados() {
		Page<Categoria> pageCategoria=repo.findAll(PageRequest.of(0, 5));
				
		System.out.println("Total elementos: "+pageCategoria.getTotalElements());
		System.out.println("Total paginas: "+pageCategoria.getTotalPages());
		
		for (Categoria categoria : pageCategoria.getContent()) {
			System.out.println(categoria.getId()+" - "+categoria.getNombre());
		}
	}
	
	/**
	 * 
	 */
	private void buscarTodosPaginacionOrdenados() {
		
		Page<Categoria> pageCategoria =  repo.findAll(PageRequest.of(0, 5, Sort.by("nombre").descending()));		
		System.out.println("Total elementos: "+pageCategoria.getTotalElements());
		System.out.println("Total paginas: "+pageCategoria.getTotalPages());
		for (Categoria categoria : pageCategoria.getContent()) {
			System.out.println(categoria.getId()+" - "+categoria.getNombre());
		}
		
		
	}
	
	
	//JPA - RELACIONES
	
	
		
}
