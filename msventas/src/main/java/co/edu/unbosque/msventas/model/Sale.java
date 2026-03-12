package co.edu.unbosque.msventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "ventas")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Long codigoVenta;

    @Column(name = "cedula_cliente")
    private String cedulaCliente;

    @Column(name = "cedula_usuario")
    private String cedulaUsuario;

    @Column(name = "valor_total_venta")
    private Double valorTotalVenta;

    @Column(name = "valor_iva")
    private Double valorIva;

    @Column(name = "valor_total_mas_iva")
    private Double valorTotalMasIva;

    public Sale() {
    }

    public Sale(Long codigoVenta, String cedulaCliente, String cedulaUsuario, Double valorTotalVenta, Double valorIva, Double valorTotalMasIva) {
        this.codigoVenta = codigoVenta;
        this.cedulaCliente = cedulaCliente;
        this.cedulaUsuario = cedulaUsuario;
        this.valorTotalVenta = valorTotalVenta;
        this.valorIva = valorIva;
        this.valorTotalMasIva = valorTotalMasIva;
    }

    public Long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public Double getValorTotalVenta() {
        return valorTotalVenta;
    }

    public void setValorTotalVenta(Double valorTotalVenta) {
        this.valorTotalVenta = valorTotalVenta;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    public Double getValorTotalMasIva() {
        return valorTotalMasIva;
    }

    public void setValorTotalMasIva(Double valorTotalMasIva) {
        this.valorTotalMasIva = valorTotalMasIva;
    }
}
