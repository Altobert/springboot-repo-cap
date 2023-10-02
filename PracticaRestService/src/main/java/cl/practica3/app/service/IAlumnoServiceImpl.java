package cl.practica3.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.practica3.app.entity.Alumno;
import cl.practica3.app.repository.IAlumnoRepository;

@Service
public class IAlumnoServiceImpl implements IAlumnoService{
	
	@Autowired
	IAlumnoRepository alumnoRepository;
	 
	@Transactional
	@Override
	public Alumno save(Alumno a) {
		// TODO Auto-generated method stub
		Alumno alumnoRepo = alumnoRepository.save(a);
		return alumnoRepo;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		List<Alumno> listAlumnos = (List<Alumno>)alumnoRepository.findAll();
		
		return listAlumnos;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
		
		return Boolean.TRUE;
	}

	@Override
	@Transactional
	public Alumno update(Alumno alumno) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumnoBD = alumnoRepository.findById(alumno.getId());
		if(alumnoBD.isPresent()) {
			
			Alumno alumnoActualizar = alumnoBD.get();
			
			alumnoActualizar.setNombre(alumno.getNombre());
			alumnoActualizar.setEdad(alumno.getEdad());
			alumnoActualizar.setEdad(alumno.getCorreo());
			
			return save(alumnoActualizar);
		}
		
		return null;
	}

}
