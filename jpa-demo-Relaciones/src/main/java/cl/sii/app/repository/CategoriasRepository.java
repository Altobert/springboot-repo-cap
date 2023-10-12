package cl.sii.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.sii.app.model.Categoria;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
//public interface CategoriasRepository extends PagingAndSortingRepository<Categoria, Integer> {
public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
