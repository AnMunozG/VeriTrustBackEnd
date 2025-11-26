package cl.veritrust.v1.controller;
import cl.veritrust.v1.model.Documento;
import cl.veritrust.v1.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {
    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public List<Documento> getAllDocumentos() {
        return documentoService.getAllDocumentos();
    }

    @GetMapping("/{id}")
    public Documento getDocumentoById(@PathVariable Long id) {
        return documentoService.getDocumentoById(id);
    }

    @PostMapping
    public Documento createDocumento(@RequestBody Documento documento) {
        return documentoService.createDocumento(documento);
    }

    @PutMapping("/{id}")
    public Documento updateDocumento(@PathVariable Long id, @RequestBody Documento documentoDetails) {
        return documentoService.updateDocumento(id, documentoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable Long id) {
        documentoService.deleteDocumento(id);
    }
    @GetMapping("/usuario/{usuarioId}")
    public List<Documento> getDocumentosByUsuarioId(@PathVariable Long usuarioId) {
        return documentoService.getDocumentosByUsuarioId(usuarioId);
    }
    
}