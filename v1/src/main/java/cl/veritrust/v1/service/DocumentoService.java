package cl.veritrust.v1.service;

import cl.veritrust.v1.model.Documento;
import cl.veritrust.v1.model.Usuario;
import cl.veritrust.v1.repository.DocumentoRepository;
import cl.veritrust.v1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Documento> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    public Documento getDocumentoById(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    // --- GUARDADO INTELIGENTE ---
    public Documento createDocumento(Documento documento) {
        // La App nos manda un usuario que solo trae el email.
        // Buscamos el ID real en la base de datos.
        if (documento.getUsuario() != null && documento.getUsuario().getEmail() != null) {
            Optional<Usuario> usuarioReal = usuarioRepository.findByEmail(documento.getUsuario().getEmail());
            usuarioReal.ifPresent(documento::setUsuario);
        }
        return documentoRepository.save(documento);
    }

    public void deleteDocumento(Long id) {
        documentoRepository.deleteById(id);
    }

    public List<Documento> getDocumentosByUsuarioEmail(String email) {
        return documentoRepository.findByUsuarioEmail(email);
    }
}