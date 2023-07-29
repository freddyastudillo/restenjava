package com.smartsoft.smartsoft.model;

public class Cliente {
    public final long id_cliente;
    public final String  nombre;
    public final String  apellido;
    public final String  direccion;
    public final String  fecha_nacimiento;
    public final String  telefono;
    public final String  email;

    public Cliente(long id_cliente, String nombre, String apellido, String direccion, String fechaNacimiento, String telefono, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fecha_nacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
    }
}
