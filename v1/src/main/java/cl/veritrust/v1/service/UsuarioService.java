package cl.veritrust.v1.service;
import cl.veritrust.v1.model.Usuario;
import cl.veritrust.v1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario createUsuario(Usuario usuario) {
        // Asignar rol por defecto si no viene
        if (usuario.getRol() == null || usuario.getRol().isBlank()) {
            usuario.setRol("usuario");
        }
        if (usuario.getFechaCreacion() == null) {
            usuario.setFechaCreacion(new java.util.Date());
        }
        return usuarioRepository.save(usuario);
    }
    public Usuario updateUsuario(Long id, Usuario nuevoUsuario) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setRut(nuevoUsuario.getRut());
            usuario.setNombre(nuevoUsuario.getNombre());
            usuario.setEmail(nuevoUsuario.getEmail());
            usuario.setContrasena(nuevoUsuario.getContrasena());
            usuario.setTelefono(nuevoUsuario.getTelefono());
            usuario.setRol(nuevoUsuario.getRol());
            usuario.setFechaNac(nuevoUsuario.getFechaNac());
            return usuarioRepository.save(usuario);
        }
        return null;
    }
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    public Usuario getUsuarioByEmail(String email) {
        Optional<Usuario> opt = usuarioRepository.findByEmail(email);
        return opt.orElse(null);
    }
    public Usuario getUsuarioByRut(String rut) {
        Optional<Usuario> opt = usuarioRepository.findByRut(rut);
        return opt.orElse(null);
    }

    /**
     * Intento sencillo de login: busca por email y contraseña.
     * Nota: en producción nunca almacenes contraseñas en texto plano.
     */
    public Usuario login(String email, String contrasena) {
        Optional<Usuario> opt = usuarioRepository.findByEmailAndContrasena(email, contrasena);
        return opt.orElse(null);
    }
}