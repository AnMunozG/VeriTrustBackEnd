package cl.veritrust.v1.controller;

import cl.veritrust.v1.model.Documento;
import cl.veritrust.v1.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/documentos")
@CrossOrigin(origins = "*")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public List<Documento> getAll() { return documentoService.getAllDocumentos(); }

    @PostMapping
    public Documento create(@RequestBody Documento documento) {
        return documentoService.createDocumento(documento);
    }

    // Obtener documentos de un usuario por su email
    @GetMapping("/usuario/{email}")
    public List<Documento> getByUsuario(@PathVariable String email) {
        return documentoService.getDocumentosByUsuarioEmail(email);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { documentoService.deleteDocumento(id); }
}