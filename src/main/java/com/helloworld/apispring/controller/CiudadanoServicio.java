package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.CiudadanoRepositorio;
import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadanoServicio {

    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;

    public CiudadanoServicio() {
    }

    public List<Ciudadano> getAllRanking() {
        return ciudadanoRepositorio.getAllCitizen();
    }

    public Integer crearCiudadano(Ciudadano ciudadano) {
        return ciudadanoRepositorio.crearCiudadano(ciudadano);
    }

    public Ciudadano getCitizenByID(int id) {
        return ciudadanoRepositorio.getCitizenByID(id);
    }
    
    public List<Ciudadano> getAllCitizenOrderedByPoints(){
        return ciudadanoRepositorio.getAllCitizenOrderedByPoints();
    }
}
