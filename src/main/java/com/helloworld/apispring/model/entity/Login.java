package com.helloworld.apispring.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login")
    private Integer id;

    @Column(name = "usuario_login")
    private String usuario;

    @Column(name = "contraseña_login")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "id_ciudadano")
    @JsonBackReference
    private Ciudadano ciudadano;

    @Transient
    private int idCiudadano2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public int getIdCiudadano2() {
        return idCiudadano2;
    }

    public void setIdCiudadano2(int idCiudadano2) {
        this.idCiudadano2 = idCiudadano2;
    }

}
