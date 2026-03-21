package co.edu.unbosque.msproveedores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "proveedores")
public class Provider {

    @Id
    @Column(name = "nit")
    @JsonProperty("nit")
    private Long nit;
    
    @Column(name = "nombre_proveedor")
    @JsonProperty("nombreProveedor")
    private String name;
    
    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String address;
    
    @Column(name = "telefono")
    @JsonProperty("telefono")
    private String phone;

    @Column(name = "ciudad")
    @JsonProperty("ciudad")
    private String ciudad;

    @Column(name = "correo")
    @JsonProperty("correo")
    private String correo;

    public Provider() {
    }

    public Provider(Long nit, String name, String address, String phone, String ciudad, String correo) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ciudad = ciudad;
        this.correo = correo;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
