package cl.sii.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sii.app.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer>{
	
}
