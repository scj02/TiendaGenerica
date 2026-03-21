package co.edu.unbosque.msproductos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("codigoProducto")
    private Long id;
    
    @Column(name = "name")
    @JsonProperty("nombreProducto")
    private String name;
    
    @Column(name = "price")
    @JsonProperty("precioCompra")
    private Double price;
    
    @Column(name = "cantidad")
    private Integer quantity;
    
    @Column(name = "iva")
    @JsonProperty("ivaCompra")
    private Double iva;

    @Column(name = "nit_proveedor")
    @JsonProperty("nitProveedor")
    private Long nitProveedor;

    @Column(name = "precio_venta")
    @JsonProperty("precioVenta")
    private Double precioVenta;

    public Product() {
    }

    public Product(Long id, String name, Double price, Integer quantity, Double iva) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.iva = iva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
