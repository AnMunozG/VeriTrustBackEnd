package cl.veritrust.v1.service;

import cl.veritrust.v1.model.Usuario;
import cl.veritrust.v1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena).orElse(null);
    }

    // --- CORRECCIÓN IMPORTANTE: ACTUALIZAR DATOS ---
    public Usuario actualizarPorEmail(Usuario datosNuevos) {
        // 1. Buscamos al usuario que ya existe en la BD
        Optional<Usuario> usuarioExistenteOpt = usuarioRepository.findByEmail(datosNuevos.getEmail());

        if (usuarioExistenteOpt.isPresent()) {
            Usuario usuarioAntiguo = usuarioExistenteOpt.get();

            // 2. Pasamos los datos básicos
            usuarioAntiguo.setNombre(datosNuevos.getNombre());
            usuarioAntiguo.setTelefono(datosNuevos.getTelefono());
            usuarioAntiguo.setRut(datosNuevos.getRut());

            // 3. Pasamos los datos que FALTABAN (Por esto no se guardaban)
            usuarioAntiguo.setRegion(datosNuevos.getRegion());
            usuarioAntiguo.setGenero(datosNuevos.getGenero());

            // 4. Pasamos la FECHA procesada
            // El modelo ya convirtió el String a Date en 'datosNuevos', así que usamos el Date directo.
            if (datosNuevos.getFechaNac() != null) {
                usuarioAntiguo.setFechaNac(datosNuevos.getFechaNac());
            }

            // 5. Contraseña (Solo si el usuario escribió una nueva)
            if (datosNuevos.getContrasena() != null && !datosNuevos.getContrasena().isBlank()) {
                usuarioAntiguo.setContrasena(datosNuevos.getContrasena());
            }

            // 6. Guardamos los cambios en la BD
            return usuarioRepository.save(usuarioAntiguo);
        }
        return null;
    }

    // --- LÓGICA PARA ELIMINAR PERFIL ---
    @Transactional
    public boolean eliminarPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return true;
        }
        return false;
    }
}