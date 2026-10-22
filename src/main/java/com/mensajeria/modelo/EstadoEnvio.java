/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.modelo;

/**
 *
 * @author orion
 */
public enum EstadoEnvio {

    REGISTRADO("Registrado"),
    ASIGNADO("Asignado"),
    EN_TRANSITO("En tránsito"),
    ENTREGADO("Entregado"),
    ENTREGA_FALLIDA("Entrega fallida"),
    CANCELADO("Cancelado");

    private final String etiqueta;

    EstadoEnvio(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public static EstadoEnvio desdeEtiqueta(String etiqueta) {
        for (EstadoEnvio estado : values()) {
            if (estado.etiqueta.equalsIgnoreCase(etiqueta)) {
                return estado;
            }
        }

        throw new IllegalArgumentException(
                "Estado de envio desconocido: " + etiqueta
        );
    }
}
