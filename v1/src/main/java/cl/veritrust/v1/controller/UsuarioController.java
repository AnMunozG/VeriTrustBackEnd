package cl.veritrust.v1.controller;

import cl.veritrust.v1.model.Usuario;
import cl.veritrust.v1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite conexión desde cualquier IP (útil para desarrollo móvil)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Listar todos
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAllUsuarios();
    }

    // Registro
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario loggedUser = usuarioService.login(usuario.getEmail(), usuario.getContrasena());
        if (loggedUser != null) {
            return ResponseEntity.ok(loggedUser);
        }
        return ResponseEntity.status(401).build();
    }

    // Obtener Perfil (GET)
    @GetMapping("/{email}")
    public ResponseEntity<Usuario> getByEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.getUsuarioByEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    // Actualizar Perfil (PUT)
    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        Usuario actualizado = usuarioService.actualizarPorEmail(usuario);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar Perfil (DELETE) - NUEVO
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        boolean eliminado = usuarioService.eliminarPorEmail(email);
        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204 No Content (Éxito)
        }
        return ResponseEntity.notFound().build();
    }
}