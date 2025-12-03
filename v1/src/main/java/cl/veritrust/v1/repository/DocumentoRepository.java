package cl.veritrust.v1.repository;

import cl.veritrust.v1.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    // Busca documentos filtrando por el email del usuario dueño
    List<Documento> findByUsuarioEmail(String email);
}