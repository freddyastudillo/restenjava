package com.smartsoft.smartsoft.model;

public class Detalle {

    public final long num_detalle;

    public final long id_factura;
    public final long id_producto;
    public final long cantidad;
    public final long precio;

    public Detalle(long numDetalle, long idFactura, long idProducto, long cantidad, long precio) {
        this.num_detalle = numDetalle;
        this.id_factura = idFactura;
        this.id_producto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
