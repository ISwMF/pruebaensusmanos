/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.entity.Ciudadano;
import com.helloworld.apispring.model.entity.Reporte;
import com.helloworld.apispring.model.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/informacion")
public class Controller {

    @Autowired
    private CiudadanoServicio ciudadanoServicio;

    @Autowired
    private ReporteServicio reporteServicio;
    
    @Autowired
    private LoginServicio loginServicio;

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.GET)
    public ResponseEntity<List<Ciudadano>> obtenerEquipos() {
        List<Ciudadano> equipos = ciudadanoServicio.getAllRanking();
        return new ResponseEntity<List<Ciudadano>>(equipos, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearCiudadano(@RequestBody Ciudadano ciudadano) {
        String resultado = "Se creo persona con ID: " + ciudadanoServicio.createCitizen(ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ciudadano> obtenerCiudadanoPorID(@PathVariable("id") int id) {
        Ciudadano ciudadano = ciudadanoServicio.getCitizenByID(id);
        return new ResponseEntity<Ciudadano>(ciudadano, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/orden/", method = RequestMethod.GET)
    public ResponseEntity<List<Ciudadano>> obtenerCiudadanosOrdenadosPorID() {
        List<Ciudadano> equipos = ciudadanoServicio.getAllCitizenOrderedByPoints();
        return new ResponseEntity<List<Ciudadano>>(equipos, HttpStatus.OK);
    }

    @RequestMapping(value = "/reportes/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearReporte(@RequestBody Reporte reporte) {
        String resultado = "Se creo reporte con ID :" + reporteServicio.createReport(reporte);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
    
//    @RequestMapping(value = "/ciudadanos/{id}/reportes", method = RequestMethod.GET)
//    public ResponseEntity<List<Reporte>> obtenerReportesDeUnCiudadano(@PathVariable("id") int id) {
//        Ciudadano ciudadano = ciudadanoServicio.getCitizenByID(id);
//        return new ResponseEntity<Ciudadano>(ciudadano, HttpStatus.OK);
//    }
    
    
}
