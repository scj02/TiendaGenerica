package co.edu.unbosque.msusuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.unbosque.msusuarios.model.Usuario;
import co.edu.unbosque.msusuarios.service.UsuarioService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Fundamental para evitar el error de CORS con el frontend
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }
    
    @GetMapping("/buscar/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable("id") Long id) {
        return usuarioService.findById(id);
    }

    // EL ENDPOINT DEL LOGIN (Conecta con tu fetch de JS)
    @GetMapping("/login")
    public boolean login(@RequestParam String usuario, @RequestParam String password) {
        return usuarioService.login(usuario, password);
    }
}