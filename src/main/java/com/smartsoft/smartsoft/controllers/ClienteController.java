package com.smartsoft.smartsoft.controllers;

import com.smartsoft.smartsoft.model.Cliente;
import com.smartsoft.smartsoft.model.Factura;
import com.smartsoft.smartsoft.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente")
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/factcliente/{idcli}")
    public List<Factura> getFacturaCliente(@PathVariable int idcli){
        return clienteService.getFacturaCliente(idcli);
    }
    @PostMapping("/cliente")
    public long createCliente(@RequestBody Cliente newCliente){
        return clienteService.createCliente(newCliente);
    }

}
