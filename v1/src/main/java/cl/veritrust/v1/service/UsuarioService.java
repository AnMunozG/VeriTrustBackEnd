package cl.veritrust.v1.service;

import cl.veritrust.v1.model.Usuario;
import cl.veritrust.v1.repository.DocumentoRepository;
import cl.veritrust.v1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// v1/src/main/java/cl/veritrust/v1/service/UsuarioService.java

@Service
public class UsuarioService {

    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    // ⭐ MODIFICADO: Asignar rol 'user' por defecto al crear
    public Usuario createUsuario(Usuario usuario) {
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) {
            usuario.setRol("user");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena).orElse(null);
    }

    public Usuario actualizarPorEmail(Usuario datosNuevos) {
        Optional<Usuario> usuarioExistenteOpt = usuarioRepository.findByEmail(datosNuevos.getEmail());

        if (usuarioExistenteOpt.isPresent()) {
            Usuario usuarioAntiguo = usuarioExistenteOpt.get();

            usuarioAntiguo.setNombre(datosNuevos.getNombre());
            usuarioAntiguo.setTelefono(datosNuevos.getTelefono());
            usuarioAntiguo.setRut(datosNuevos.getRut());
            usuarioAntiguo.setRegion(datosNuevos.getRegion());
            usuarioAntiguo.setGenero(datosNuevos.getGenero());

            if (datosNuevos.getFechaNac() != null) {
                usuarioAntiguo.setFechaNac(datosNuevos.getFechaNac());
            }

            if (datosNuevos.getContrasena() != null && !datosNuevos.getContrasena().isBlank()) {
                usuarioAntiguo.setContrasena(datosNuevos.getContrasena());
            }

            return usuarioRepository.save(usuarioAntiguo);
        }
        return null;
    }

    @Transactional
    public boolean eliminarPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            documentoRepository.deleteAllByUsuarioId(usuario.get().getId());
            usuarioRepository.delete(usuario.get());
            return true;
        }
        return false;
    }
}