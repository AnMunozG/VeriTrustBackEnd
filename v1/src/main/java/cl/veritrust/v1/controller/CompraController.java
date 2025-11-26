package cl.veritrust.v1.controller;
import cl.veritrust.v1.model.Compra;
import cl.veritrust.v1.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraService.getAllCompras();
    }

    @GetMapping("/{id}")
    public Compra getCompraById(@PathVariable Long id) {
        return compraService.getCompraById(id);
    }

    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraService.createCompra(compra);
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@PathVariable Long id, @RequestBody Compra compraDetails) {
        return compraService.updateCompra(id, compraDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCompra(@PathVariable Long id) {
        compraService.deleteCompra(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Compra> getComprasByUsuarioId(@PathVariable Long usuarioId) {
        return compraService.getComprasByUsuarioId(usuarioId);
    }
}