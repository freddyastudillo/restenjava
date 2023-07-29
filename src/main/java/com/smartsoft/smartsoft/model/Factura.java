package com.smartsoft.smartsoft.model;

public class Factura {
    public final long num_factura;
    public final long id_cliente;

    public final String fecha;

    public Factura(long numFactura, long idCliente, String fecha) {
        this.num_factura = numFactura;
        this.id_cliente = idCliente;
        this.fecha = fecha;
    }
}
