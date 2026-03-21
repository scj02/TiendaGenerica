package co.edu.unbosque.msclientes.service;

import co.edu.unbosque.msclientes.model.Cliente;
import co.edu.unbosque.msclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    // Aquí aplicamos la misma lógica de actualización que tienes en Productos
    public Cliente update(Long id, Cliente clienteDetalles) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre_cliente(clienteDetalles.getNombre_cliente());
            cliente.setDireccion_cliente(clienteDetalles.getDireccion_cliente());
            cliente.setTelefono_cliente(clienteDetalles.getTelefono_cliente());
            cliente.setEmail_cliente(clienteDetalles.getEmail_cliente());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
    }
}