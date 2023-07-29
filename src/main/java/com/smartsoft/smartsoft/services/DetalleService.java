package com.smartsoft.smartsoft.services;

import com.smartsoft.smartsoft.model.Detalle;
import com.smartsoft.smartsoft.repositories.DetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleService {

    private final DetalleRepository repository;

    public DetalleService(DetalleRepository repository){
        this.repository = repository;
    }

    public List<Detalle> getAllDetalles(){
        return repository.getAllDetalles();
    }

    public long createDetalle(Detalle newDetalle) {
        return repository.createDetalle(newDetalle);
    }
}
