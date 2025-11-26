package cl.veritrust.v1.service;
import cl.veritrust.v1.model.Servicio;
import cl.veritrust.v1.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerTodosLosServicios() {
        return servicioRepository.findAll();
    }

    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Optional<Servicio> obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id);
    }

    public Servicio actualizarServicio(Long id, Servicio servicioDetalles) {
        Optional<Servicio> servicioOptional = servicioRepository.findById(id);
        if (servicioOptional.isPresent()) {
            Servicio servicio = servicioOptional.get();
            servicio.setNombre(servicioDetalles.getNombre());
            servicio.setDescripcion(servicioDetalles.getDescripcion());
            servicio.setPrecio(servicioDetalles.getPrecio());
            return servicioRepository.save(servicio);
        }
        return null;
    }
    
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}