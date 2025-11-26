package cl.veritrust.v1.service;
import cl.veritrust.v1.model.Compra;
import cl.veritrust.v1.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public Compra getCompraById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public Compra createCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public Compra updateCompra(Long id, Compra compraDetails) {
        Compra compra = compraRepository.findById(id).orElse(null);
        if (compra != null) {
            compra.setFechaCompra(compraDetails.getFechaCompra());
            compra.setMontoTotal(compraDetails.getMontoTotal());
            compra.setMetodoPago(compraDetails.getMetodoPago());
            return compraRepository.save(compra);
        }
        return null;
    }

    public void deleteCompra(Long id) {
        compraRepository.deleteById(id);
    }

    public List<Compra> getComprasByUsuarioId(Long usuarioId) {
        List<Compra> allCompras = compraRepository.findAll();
        List<Compra> userCompras = new ArrayList<>();
        for (Compra compra : allCompras) {
            if (compra.getUsuarioId().equals(usuarioId)) {
                userCompras.add(compra);
            }
        }
        return userCompras;
    }
}