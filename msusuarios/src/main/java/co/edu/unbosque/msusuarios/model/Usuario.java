package co.edu.unbosque.msusuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @JsonProperty("cedula")
    private Long cedula_usuario;
    @JsonProperty("correoElectronico")
    private String email_usuario;
    @JsonProperty("nombreCompleto")
    private String nombre_usuario;
    @JsonProperty("password")
    private String password;
    @JsonProperty("usuario")
    private String usuario;

    // Getters y Setters
    public Long getCedula_usuario() { return cedula_usuario; }
    public void setCedula_usuario(Long cedula_usuario) { this.cedula_usuario = cedula_usuario; }
    
    public String getEmail_usuario() { return email_usuario; }
    public void setEmail_usuario(String email_usuario) { this.email_usuario = email_usuario; }
    
    public String getNombre_usuario() { return nombre_usuario; }
    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
}