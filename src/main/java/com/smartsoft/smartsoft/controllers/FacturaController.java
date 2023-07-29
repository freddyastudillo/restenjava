package com.smartsoft.smartsoft.controllers;

import com.smartsoft.smartsoft.model.Detalle;
import com.smartsoft.smartsoft.model.Factura;
import com.smartsoft.smartsoft.services.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService){
        this.facturaService = facturaService;
    }

    @GetMapping("/factura")
    public List<Factura> getAllFacturas(){
        return facturaService.getAllFacturas();
    }

    @GetMapping("/detallesfact/{idfac}")
    public List<Detalle> getFacDetalles(@PathVariable int idfac){
        return facturaService.getFacDetalles(idfac);
    }

    @PostMapping("/factura")
    public long createFactura(@RequestBody Factura newFactura){
        return facturaService.createFactura(newFactura);
    }
}
