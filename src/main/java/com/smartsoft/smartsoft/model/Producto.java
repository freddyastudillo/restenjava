package com.smartsoft.smartsoft.model;

public class Producto {
    public final long id_producto;
    public final String nombre;
    public final long precio;
    public final long stock;

    public Producto(long id_producto, String nombre, long precio, long stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}
