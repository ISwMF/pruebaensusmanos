package com.helloworld.apispring.model.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue
    @Column(name = "id_reporte")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_reporte")
    private Date Fecha;

    @Column(name = "lugar_reporte")
    private String Lugar;

    @Column(name = "situacion_reporte")
    private String Situacion;

    @Column(name = "puntos_reporte")
    private Integer Puntos;

    @ManyToOne
    @JoinColumn(name = "id_ciudadano")
    private Ciudadano ciudadano;

    public Reporte() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getSituacion() {
        return Situacion;
    }

    public void setSituacion(String Situacion) {
        this.Situacion = Situacion;
    }

    public Integer getPuntos() {
        return Puntos;
    }

    public void setPuntos(Integer Puntos) {
        this.Puntos = Puntos;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

}
