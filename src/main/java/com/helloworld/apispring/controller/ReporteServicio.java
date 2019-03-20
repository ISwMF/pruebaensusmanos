/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.CiudadanoRepositorio;
import com.helloworld.apispring.model.dao.ReporteRepositorio;
import com.helloworld.apispring.model.entity.Reporte;
import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteServicio {
    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;

    @Autowired
    private ReporteRepositorio reporteRepositorio;

    public ReporteServicio() {
    }
    
    public long createReport(Reporte reporte){
        Ciudadano ciudadano = ciudadanoRepositorio.getCitizenByID(reporte.getIdCiudadano());
        reporte.setCiudadano(ciudadano);
        return ciudadanoRepositorio.createReport(reporte);
    }

    public List<Reporte> getAllReportsByCitizen(int id) {
        return reporteRepositorio.getAllReportsByCitizen(id);
    }
}
