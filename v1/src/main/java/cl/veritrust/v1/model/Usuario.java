package cl.veritrust.v1.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// v1/src/main/java/cl/veritrust/v1/model/Usuario.java

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
    
    @JsonProperty("region")
    private String region;

    @JsonProperty("genero")
    private String genero;

    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    // ⭐ NUEVO: Campo de rol con valor por defecto
    @Column(nullable = false)
    private String rol = "user"; // Por defecto todos son 'user'

    // Métodos de fecha (mantener los existentes)
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    @JsonProperty("fechaNacimiento")
    public String getFechaNacimientoStr() {
        if (this.fechaNac != null) {
            try {
                return SDF.format(this.fechaNac);
            } catch (Exception e) { return ""; }
        }
        return "";
    }

    @JsonProperty("fechaNacimiento")
    public void setFechaNacimientoStr(String fechaStr) {
        if (fechaStr != null && !fechaStr.trim().isEmpty()) {
            try {
                this.fechaNac = SDF.parse(fechaStr);
            } catch (Exception e) {
                System.err.println("Error fecha: " + fechaStr);
            }
        }
    }
}