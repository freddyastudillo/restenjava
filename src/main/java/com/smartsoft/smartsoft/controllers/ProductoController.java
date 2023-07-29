package com.smartsoft.smartsoft.controllers;

import com.smartsoft.smartsoft.model.Producto;
import com.smartsoft.smartsoft.services.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/producto")
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @PostMapping("/producto")
    public long createProducto(@RequestBody Producto newProducto){
        return productoService.createProducto(newProducto);
    }
}
