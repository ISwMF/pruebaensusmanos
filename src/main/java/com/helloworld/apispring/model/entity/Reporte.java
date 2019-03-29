package com.helloworld.apispring.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Integer reporteId;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_reporte")
    private Date fecha;

    @Column(name = "lugar_reporte")
    private String lugar;

    @Column(name = "situacion_reporte")
    private String situacion;

    @Column(name = "puntos_reporte")
    private String puntos;

    @ManyToOne
    @JoinColumn(name = "id_ciudadano")
    @JsonBackReference
    private Ciudadano ciudadano;

    @Transient
    private int idCiudadano;

    public Integer getReporteId() {
        return reporteId;
    }

    public void setReporteId(Integer reporteId) {
        this.reporteId = reporteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public int getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(int idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

}
