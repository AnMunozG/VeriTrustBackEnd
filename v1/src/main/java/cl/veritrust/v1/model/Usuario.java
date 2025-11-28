package cl.veritrust.v1.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // El móvil envía el email con la clave "user". Lo mantenemos mapeado a la columna
    @JsonProperty("user")
    private String email;

    // El móvil envía la contraseña con la clave "password". Lo mantenemos mapeado a la columna
    @JsonProperty("password")
    private String contrasena;

    private String telefono;

    // Rol del usuario: "usuario" o "admin"
    private String rol = "usuario";

    // Campo persistente en BD (tipo Date). Seguimos guardando fechaNac en la BD.
    private Date fechaNac;

    // Fecha de creación del registro
    private Date fechaCreacion;


    @Transient
    @JsonProperty("fechaNacimiento")
    private String fechaNacimiento;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public String getFechaNacimiento() {
        if (this.fechaNac != null) {
            return SDF.format(this.fechaNac);
        }
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {
            try {
                this.fechaNac = SDF.parse(fechaNacimiento);
            } catch (ParseException e) {
                // ignore parse errors; fechaNac stays null
            }
        }
    }

}
