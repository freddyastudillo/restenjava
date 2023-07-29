package com.smartsoft.smartsoft.services;

import com.smartsoft.smartsoft.model.Detalle;
import com.smartsoft.smartsoft.model.Factura;
import com.smartsoft.smartsoft.repositories.DetalleRepository;
import com.smartsoft.smartsoft.repositories.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository repository;

    private final DetalleRepository repositorydet;

    public FacturaService(FacturaRepository repository,DetalleRepository repositorydet){
        this.repository = repository;
        this.repositorydet = repositorydet;
    }

    public List<Factura> getAllFacturas(){
        return repository.getAllFacturas();
    }

    public List<Detalle> getFacDetalles(int idfac){
        return repositorydet.getFacDetalles(idfac);
    }

    public long createFactura(Factura newFactura) {
        return repository.createFactura(newFactura);
    }
}
