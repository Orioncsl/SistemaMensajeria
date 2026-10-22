/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.modelo;

/**
 * Representa a un cliente del sistema de mensajería.
 */
public class Cliente {

    private Integer idCliente;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con todos los campos
    public Cliente(Integer idCliente, String nombre, String telefono,
                   String direccion, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    // Obtener el identificador del cliente
    public Integer getIdCliente() {
        return idCliente;
    }

    // Establecer el identificador del cliente
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    // Obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Establecer el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener el teléfono
    public String getTelefono() {
        return telefono;
    }

    // Establecer el teléfono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Obtener la dirección
    public String getDireccion() {
        return direccion;
    }

    // Establecer la dirección
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Obtener el correo electrónico
    public String getCorreo() {
        return correo;
    }

    // Establecer el correo electrónico
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}