package cl.practica3.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.practica3.app.entity.Alumno;
import cl.practica3.app.service.IAlumnoServiceImpl;

@RestController
public class HomeController {
	
	@Autowired
	IAlumnoServiceImpl alumnoService;
	
	@PostMapping("/alumno")
	public Alumno guardar(@RequestBody Alumno alumno) {
		
		Alumno alumnoRespuesta = alumnoService.save(alumno);
		
		return alumnoRespuesta;
	}
	
	@GetMapping("/listar")
	public List<Alumno> findAll(Model model){
		
		List<Alumno> listAlumno = alumnoService.findAll();
						
		return listAlumno;
	}
	
	@DeleteMapping("/alumno/{id}") //localhost:8080/alumno
	public ResponseEntity<Void> eliminarAlumno(@PathVariable("id") Integer id) {
		
		alumnoService.delete(id);
		
		return ResponseEntity.noContent().build();
				
	}
	
	@PutMapping("/alumno/update")
	public ResponseEntity<Alumno> actualizarAlumno(@RequestBody Alumno alumno) {
		
		Alumno alumnoActualizado = alumnoService.update(alumno);
		
		if(alumnoActualizado!= null ) {
			
			return new ResponseEntity(alumnoActualizado, HttpStatus.OK);
		}
		
		return ResponseEntity.notFound().build();
	}

}
