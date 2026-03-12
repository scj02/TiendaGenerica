package co.edu.unbosque.msventas.dto;

import java.util.List;

public class VentaRequestDTO {
    private String cedulaCliente;
    private String cedulaUsuario;
    private List<ItemVentaDTO> items;

    public String getCedulaCliente() { return cedulaCliente; }
    public void setCedulaCliente(String cedulaCliente) { this.cedulaCliente = cedulaCliente; }
    public String getCedulaUsuario() { return cedulaUsuario; }
    public void setCedulaUsuario(String cedulaUsuario) { this.cedulaUsuario = cedulaUsuario; }
    public List<ItemVentaDTO> getItems() { return items; }
    public void setItems(List<ItemVentaDTO> items) { this.items = items; }

    public static class ItemVentaDTO {
        private Long codigoProducto;
        private Integer cantidad;

        public Long getCodigoProducto() { return codigoProducto; }
        public void setCodigoProducto(Long codigoProducto) { this.codigoProducto = codigoProducto; }
        public Integer getCantidad() { return cantidad; }
        public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    }
}
