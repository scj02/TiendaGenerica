package co.edu.unbosque.msclientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.unbosque.msclientes.model.Cliente;
import co.edu.unbosque.msclientes.service.ClienteService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*") 
public class ClienteController {

    // Cambiamos el Repository por el Service
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/guardar")
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteService.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }

    // Usamos la nueva ruta con el ID en la URL para actualizar, igual que en Productos
    @PutMapping("/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }
    
    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable("id") Long id) {
        return clienteService.findById(id);
    }
}