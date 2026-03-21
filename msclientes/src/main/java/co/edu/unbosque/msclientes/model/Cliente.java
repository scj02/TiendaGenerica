package co.edu.unbosque.msclientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "cedula")
    @JsonProperty("cedula")
    private Long cedula_cliente;
    
    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String direccion_cliente;
    
    @Column(name = "correo_electronico")
    @JsonProperty("correoElectronico")
    private String email_cliente;
    
    @Column(name = "nombre_completo")
    @JsonProperty("nombreCompleto")
    private String nombre_cliente;
    
    @Column(name = "telefono")
    @JsonProperty("telefono")
    private String telefono_cliente;

    // Genera los Getters y Setters
    public Long getCedula_cliente() { return cedula_cliente; }
    public void setCedula_cliente(Long cedula_cliente) { this.cedula_cliente = cedula_cliente; }
    
    public String getDireccion_cliente() { return direccion_cliente; }
    public void setDireccion_cliente(String direccion_cliente) { this.direccion_cliente = direccion_cliente; }
    
    public String getEmail_cliente() { return email_cliente; }
    public void setEmail_cliente(String email_cliente) { this.email_cliente = email_cliente; }
    
    public String getNombre_cliente() { return nombre_cliente; }
    public void setNombre_cliente(String nombre_cliente) { this.nombre_cliente = nombre_cliente; }
    
    public String getTelefono_cliente() { return telefono_cliente; }
    public void setTelefono_cliente(String telefono_cliente) { this.telefono_cliente = telefono_cliente; }
}