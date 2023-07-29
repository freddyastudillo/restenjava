package com.smartsoft.smartsoft.controllers;

import com.smartsoft.smartsoft.model.Detalle;
import com.smartsoft.smartsoft.services.DetalleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DetalleControler {

    private final DetalleService detalleService;

    public DetalleControler(DetalleService detalleService){
        this.detalleService = detalleService;
    }

    @GetMapping("/detalle")
    public List<Detalle> getAllDetalles(){
        return detalleService.getAllDetalles();
    }

    @PostMapping("/detalle")
    public long createDetalle(@RequestBody Detalle newDetalle){
        return detalleService.createDetalle(newDetalle);
    }
}
