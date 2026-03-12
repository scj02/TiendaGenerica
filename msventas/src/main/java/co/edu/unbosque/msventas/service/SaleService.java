package co.edu.unbosque.msventas.service;

import co.edu.unbosque.msventas.dto.ProductResponseDTO;
import co.edu.unbosque.msventas.dto.VentaRequestDTO;
import co.edu.unbosque.msventas.model.Sale;
import co.edu.unbosque.msventas.model.SaleDetail;
import co.edu.unbosque.msventas.repository.SaleDetailRepository;
import co.edu.unbosque.msventas.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.productos.url}")
    private String productosBaseUrl;

    @Value("${service.clientes.url}")
    private String clientesBaseUrl;

    @Transactional
    public Sale processSale(VentaRequestDTO request) {
        // 1. Validar cliente (Simulado por ahora, o llamar a msclientes si existiera el endpoint)
        // Por simplicidad en este ejercicio, asumimos que el cliente existe.

        double subtotalAcumulado = 0;
        double ivaAcumulado = 0;
        List<SaleDetail> detailsToSave = new ArrayList<>();

        // Procesar hasta 3 productos según el requerimiento (aunque el DTO permite mas, aplicamos la regla de negocio)
        int itemCount = Math.min(request.getItems().size(), 3);

        for (int i = 0; i < itemCount; i++) {
            VentaRequestDTO.ItemVentaDTO item = request.getItems().get(i);
            
            // Consultar producto a msproductos
            ProductResponseDTO product = restTemplate.getForObject(
                productosBaseUrl + "/api/products/" + item.getCodigoProducto(), 
                ProductResponseDTO.class
            );

            if (product == null) {
                throw new RuntimeException("Producto no encontrado: " + item.getCodigoProducto());
            }

            double valorUnitario = product.getPrice();
            double ivaPorcentaje = product.getIva() != null ? product.getIva() : 0;
            double valorTotalItem = valorUnitario * item.getCantidad();
            double ivaItem = valorTotalItem * (ivaPorcentaje / 100.0);

            subtotalAcumulado += valorTotalItem;
            ivaAcumulado += ivaItem;

            SaleDetail detail = new SaleDetail();
            detail.setCodigoProducto(item.getCodigoProducto());
            detail.setCantidad(item.getCantidad());
            detail.setValorUnitario(valorUnitario);
            detail.setValorTotal(valorTotalItem);
            detailsToSave.add(detail);
        }

        // Crear la venta maestra
        Sale sale = new Sale();
        sale.setCedulaCliente(request.getCedulaCliente());
        sale.setCedulaUsuario(request.getCedulaUsuario());
        sale.setValorTotalVenta(subtotalAcumulado);
        sale.setValorIva(ivaAcumulado);
        sale.setValorTotalMasIva(subtotalAcumulado + ivaAcumulado);

        Sale savedSale = saleRepository.save(sale);

        // Guardar detalles con el ID de la venta
        for (SaleDetail detail : detailsToSave) {
            detail.setCodigoVenta(savedSale.getCodigoVenta());
            saleDetailRepository.save(detail);
        }

        return savedSale;
    }
}
