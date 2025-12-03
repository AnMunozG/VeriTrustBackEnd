package cl.veritrust.v1.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String rut;
    private String nombre;

    @Column(unique = true)
    @JsonProperty("user")
    private String email;

    @JsonProperty("password")
    private String contrasena;

    private String telefono;

    // Estos campos ya se guardan bien, solo asegúrate que estén aquí
    @JsonProperty("region")
    private String region;

    @JsonProperty("genero")
    private String genero;

    // --- ARREGLO DE LA FECHA ---
    @Temporal(TemporalType.DATE)
    private Date fechaNac; // Esta es la única variable de fecha real

    // Formateador
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    // "Truco": Creamos métodos 'dummy' para el JSON, sin crear una variable String
    
    // ENVIAR AL CELULAR (Date -> String)
    @JsonProperty("fechaNacimiento")
    public String getFechaNacimientoStr() {
        if (this.fechaNac != null) {
            try {
                return SDF.format(this.fechaNac);
            } catch (Exception e) { return ""; }
        }
        return "";
    }

    // RECIBIR DEL CELULAR (String -> Date)
    @JsonProperty("fechaNacimiento")
    public void setFechaNacimientoStr(String fechaStr) {
        if (fechaStr != null && !fechaStr.trim().isEmpty()) {
            try {
                this.fechaNac = SDF.parse(fechaStr); // Aquí se guarda en la variable real
            } catch (Exception e) {
                System.err.println("Error fecha: " + fechaStr);
            }
        }
    }
}