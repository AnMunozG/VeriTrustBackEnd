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

    @JsonProperty("user")
    private String email;

    @JsonProperty("password")
    private String contrasena;

    private String telefono;

    private Date fechaNac;


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
            }
        }
    }

}
