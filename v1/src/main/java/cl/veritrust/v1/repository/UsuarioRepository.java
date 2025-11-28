package cl.veritrust.v1.repository;

import cl.veritrust.v1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByRut(String rut);
	Optional<Usuario> findByEmailAndContrasena(String email, String contrasena);
}