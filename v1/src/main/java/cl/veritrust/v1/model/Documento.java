package cl.veritrust.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String nombreArchivo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFirmado;
    
    private String direccionArchivo;

    // --- RELACIÓN CON USUARIO (Foreign Key) ---
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("contrasena") // Evitamos devolver la pass al listar docs
    private Usuario usuario;
}