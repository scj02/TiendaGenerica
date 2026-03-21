package co.edu.unbosque.msclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.msclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Solo con esta interfaz ya tienes acceso a save, findAll, deleteById, etc.
}