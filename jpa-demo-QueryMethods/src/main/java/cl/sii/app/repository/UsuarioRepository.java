package cl.sii.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sii.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
