package com.smartsoft.smartsoft.services;

import com.smartsoft.smartsoft.model.Cliente;
import com.smartsoft.smartsoft.model.Factura;
import com.smartsoft.smartsoft.repositories.ClienteRepository;
import com.smartsoft.smartsoft.repositories.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final FacturaRepository repositoryfac;

    public ClienteService(ClienteRepository repository, FacturaRepository repositoryfac){
        this.repository = repository;
        this.repositoryfac = repositoryfac;
    }

    public List<Cliente> getAllClientes(){
        return repository.getAllClientes();
    }

    public List<Factura> getFacturaCliente(int idcli){
        return repositoryfac.getFacturasCliente(idcli);
    }

    public long createCliente(Cliente newCliente) {
        return repository.createCliente(newCliente);
    }
}
