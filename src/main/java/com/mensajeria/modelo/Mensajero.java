/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.modelo;

/**
 *
 * @author orion
 */
public class Mensajero {
    private Integer idMensajero;
    private String nombre;
    private String telefono;
    private String direccion;
    private String estado = "Activo";

    public Mensajero() {
    }

    public Integer getIdMensajero() {
        return idMensajero;
    }

    public void setIdMensajero(Integer idMensajero) {
        this.idMensajero = idMensajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
