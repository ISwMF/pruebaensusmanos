package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.CiudadanoRepositorio;
import com.helloworld.apispring.model.entity.Login;
import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServicio {

    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;

    public LoginServicio() {
    }

    public long createLogin(Login login) {
        Ciudadano ciudadano = ciudadanoRepositorio.getCitizenByID(login.getIdCiudadano2());
        login.setCiudadano(ciudadano);
        return ciudadanoRepositorio.createLogin(login);
    }
}
