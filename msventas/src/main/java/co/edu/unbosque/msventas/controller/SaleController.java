package co.edu.unbosque.msventas.controller;

import co.edu.unbosque.msventas.dto.VentaRequestDTO;
import co.edu.unbosque.msventas.model.Sale;
import co.edu.unbosque.msventas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<Sale> processSale(@RequestBody VentaRequestDTO request) {
        try {
            Sale sale = saleService.processSale(request);
            return ResponseEntity.ok(sale);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
