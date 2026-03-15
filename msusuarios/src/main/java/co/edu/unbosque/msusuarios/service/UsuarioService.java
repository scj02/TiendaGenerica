package co.edu.unbosque.msusuarios.service;

import co.edu.unbosque.msusuarios.model.Usuario;
import co.edu.unbosque.msusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Long id, Usuario usuarioDetalles) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setEmail_usuario(usuarioDetalles.getEmail_usuario());
            usuario.setNombre_usuario(usuarioDetalles.getNombre_usuario());
            usuario.setPassword(usuarioDetalles.getPassword());
            usuario.setUsuario(usuarioDetalles.getUsuario());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
    }

    // Lógica del Login
    public boolean login(String username, String password) {
        Optional<Usuario> user = usuarioRepository.findByUsuarioAndPassword(username, password);
        return user.isPresent(); // Retorna true si lo encontró, false si no
    }
}