package co.edu.unbosque.msventas.dto;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private Double iva;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getIva() { return iva; }
    public void setIva(Double iva) { this.iva = iva; }
}
