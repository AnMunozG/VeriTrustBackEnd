package cl.veritrust.v1.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private String descripcion;

    // Android app sends `precio` as Int
    private Integer precio;

    // Lista de detalles enviada por la app móvil
    @ElementCollection
    @CollectionTable(name = "servicio_detalles", joinColumns = @JoinColumn(name = "servicio_id"))
    @Column(name = "detalle")
    private List<String> detalles;

}