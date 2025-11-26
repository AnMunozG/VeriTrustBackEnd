package cl.veritrust.v1.service;
import cl.veritrust.v1.model.Documento;
import cl.veritrust.v1.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    public Documento getDocumentoById(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    public Documento createDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Documento updateDocumento(Long id, Documento documentoDetails) {
        Documento documento = documentoRepository.findById(id).orElse(null);
        if (documento != null) {
            documento.setNombreArchivo(documentoDetails.getNombreArchivo());
            documento.setFechaFirmado(documentoDetails.getFechaFirmado());
            documento.setDireccionArchivo(documentoDetails.getDireccionArchivo());
            return documentoRepository.save(documento);
        }
        return null;
    }

    public void deleteDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
    public List<Documento> getDocumentosByUsuarioId(Long usuarioId) {
        List<Documento> allDocumentos = documentoRepository.findAll();
        List<Documento> userDocumentos = new ArrayList<>();
        for (Documento documento : allDocumentos) {
            if (documento.getUsuarioId().equals(usuarioId)) {
                userDocumentos.add(documento);
            }
        }
        return userDocumentos;
    }
}