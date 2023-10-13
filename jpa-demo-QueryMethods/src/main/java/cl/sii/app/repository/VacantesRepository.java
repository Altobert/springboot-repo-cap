package cl.sii.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sii.app.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer>{
	
	List<Vacante> findByEstatus(String status);
	
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
	
	List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double v1, double v2);
	
	List<Vacante> findByEstatusIn(String[] estatus);
	
}
