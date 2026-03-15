package co.edu.unbosque.msusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.msusuarios.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Este método es clave para que el login funcione
    Optional<Usuario> findByUsuarioAndPassword(String usuario, String password);
}