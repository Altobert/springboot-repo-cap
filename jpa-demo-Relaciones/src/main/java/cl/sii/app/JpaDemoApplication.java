package cl.sii.app;

import java.util.Date;
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
import cl.sii.app.model.Perfil;
import cl.sii.app.model.Usuario;
import cl.sii.app.model.Vacante;
import cl.sii.app.repository.CategoriasRepository;
import cl.sii.app.repository.PerfilesRepository;
import cl.sii.app.repository.UsuarioRepository;
import cl.sii.app.repository.VacantesRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Autowired
	private VacantesRepository vacanteRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
			
	@Autowired
	private PerfilesRepository perfilesRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		//guardarTodas();
		//buscarTodosJPA();
		//borrarTodoJPA();
		//buscarTodosOrdenados();
		
		//buscarTodosPaginados();
		//buscarTodosPaginacionOrdenados();
		
		//guardarVacante();
		
		//buscarVacantes();
		
		//crearPerfilesApp();
		
		//crearUsuarioConDosPerfiles();
		
		buscarUsuario();
		
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
		repoCategorias.saveAll(categorias);
	}
	
	/**
	 * Metodo existsById - Interfaz CrudRepository
	 */
	private void existeId() {
		
		Boolean existe = repoCategorias.existsById(100);
		System.out.println("la categoria existe: "+existe);
	}
	
	/**
	 * Metodo findAll - Interfaz CrudRepository
	 */
	private void buscarTodos() {
		
		Iterable<Categoria> cateogoras =   repoCategorias.findAll();
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
		Iterable<Categoria> categorias =   repoCategorias.findAllById(ids);
		for (Categoria categoria : categorias) {
			System.out.println("encontrado: "+categoria);
		}

	}
	
	/**
	 * Metodo deleteAll - Interfaz CrudRepository
	 */
	private void eliminarTodos() {
	
		repoCategorias.deleteAll();
	}
	
	/**
	 * Metodo count - Interfaz CrudRepository
	 */
	private void conteo() {
		long contador  = repoCategorias.count();
		System.out.println("cantidad de registros: "+contador);
	}
	
	/**
	 * Metodo deleteById - Interfaz CrudRepository
	 */
	private void eliminar() {

		int idCategoria = 10;
		repoCategorias.deleteById(idCategoria);		
		
	}
	
	/**
	 * Metodo save(update) - Interfaz CrudRepository
	 */
	private void modificar() {
		
		Optional<Categoria> optCategoria =  repoCategorias.findById(10);
		if(optCategoria.isPresent()) {
			
			Categoria catTemp = optCategoria.get();
			catTemp.setNombre("Programador Java");
			catTemp.setDescripcion("Trabajos asociados a programacion");
			
			repoCategorias.save(catTemp);
			
		}else {
			
			System.out.println("No se econtro nada");
		}

	}
	
	/**
	 * Metodo findById - Interfaz CrudRepository
	 */
	private void buscarPorId() {
		
		Optional<Categoria> optCategoria =  repoCategorias.findById(10);
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
		repoCategorias.save(cat);
	
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
		List<Categoria> listCategorias =  repoCategorias.findAll();
		for (Categoria categoria : listCategorias) {
			System.out.println("Categoria: "+categoria.getId()+" Nombre: "+categoria.getNombre());
		}
	}
	
	/**
	 * 
	 */
	private void borrarTodoJPA() {
		repoCategorias.deleteAllInBatch();
		System.out.println("Datos que quedan en BDD: "+repoCategorias.count());
	}
	
	
	/**
	 * 
	 */
	private void buscarTodosOrdenados() {
		List<Categoria> listCategorias = repoCategorias.findAll(Sort.by("nombre").descending());
		for (Categoria categoria : listCategorias) {
			System.out.println(categoria.getId()+" : "+categoria.getNombre());
		}
	}
	
	/**
	 * 
	 * 	 */
	private void buscarTodosPaginados() {
		Page<Categoria> pageCategoria=repoCategorias.findAll(PageRequest.of(0, 5));
				
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
		
		Page<Categoria> pageCategoria =  repoCategorias.findAll(PageRequest.of(0, 5, Sort.by("nombre").descending()));		
		System.out.println("Total elementos: "+pageCategoria.getTotalElements());
		System.out.println("Total paginas: "+pageCategoria.getTotalPages());
		for (Categoria categoria : pageCategoria.getContent()) {
			System.out.println(categoria.getId()+" - "+categoria.getNombre());
		}
		
		
	}
	
	
	// Codigo JPA Relaciones
	
	private void buscarVacantes() {
		List<Vacante> listVacantes =  vacanteRepo.findAll();
		for (Vacante vacante : listVacantes) {
			System.out.println(vacante.getId() +" - "+ vacante.getNombre()+" - "+vacante.getCategoria().getNombre());
		}
	}
	
	private void guardarVacante() {
		Vacante vacante = new Vacante();
		vacante.setNombre("Profesor Filosofia");
		vacante.setDescripcion("Universidad busca profesor de filosofia");		
		vacante.setFecha(new Date());
		vacante.setSalario(125.000);
		vacante.setEstatus("Aprobada");
		vacante.setDestacado(0);
		vacante.setImagen("mi-universidad.jpg");
		vacante.setDetalles("<h1>Conocimientos de pre socraticos</h1>");
		Categoria cat = new Categoria();
		cat.setId(15);
		vacante.setCategoria(cat);
		
		vacanteRepo.save(vacante);
	}
	
	
	private void crearPerfilesApp() {
		perfilesRepo.saveAll(obtenerPerfilesApp());
	}
	
	
	private List<Perfil> obtenerPerfilesApp(){
		
		List<Perfil> listPerfiles = new LinkedList<>();
		
		Perfil p1 = new Perfil();		
		p1.setPerfil("Supervisor");
		
		Perfil p2 = new Perfil();		
		p2.setPerfil("Administrador");
		
		Perfil p3 = new Perfil();		
		p3.setPerfil("Usuario");
		
		listPerfiles.add(p1);
		listPerfiles.add(p2);
		listPerfiles.add(p3);
		
		return listPerfiles;
	}
	
	private void buscarUsuario() {
		
		Optional<Usuario> opUsuario =  usuarioRepo.findById(1);
		
		if(opUsuario.isPresent()) {
			
			Usuario usuario = opUsuario.get();
			System.out.println("Nombre: "+usuario.getNombre());
			System.out.println("Perfiles: "+usuario.getPerfiles());
			
			if(usuario.getPerfiles()!= null && usuario.getPerfiles().size()>0) {
				for (Perfil p: usuario.getPerfiles()) {
					System.out.println(p.getId() +" "+p.getPerfil());
				}
			}
			
		}else {
			System.out.println("No se encontro el usuario");
		}
		
		
	}
	
	private void crearUsuarioConDosPerfiles() {
		
		Usuario usr = new Usuario();
		usr.setNombre("alberto san martin");
		usr.setEmail("alberto@sii.cl");		
		usr.setFechaRegistro(new Date());
		usr.setUsername("altobert");
		usr.setPassword("123456");
		usr.setEstatus(1);
		
		Perfil perfil1 = new Perfil();
		perfil1.setId(1);
		perfil1.setPerfil("Programador");
		
		Perfil perfil2 = new Perfil();
		perfil2.setId(2);
		perfil2.setPerfil("Enfermera");
		
		usr.agregar(perfil1);
		usr.agregar(perfil2);
		
		usuarioRepo.save(usr);
	}
		
}
