package com.smartsoft.smartsoft.services;
import com.smartsoft.smartsoft.model.Producto;
import com.smartsoft.smartsoft.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }

    public List<Producto> getAllProductos(){
        return repository.getAllProductos();
    }

    public long createProducto(Producto newProducto) {
        return repository.createProducto(newProducto);
    }
}
