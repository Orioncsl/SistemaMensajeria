/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.util;
/**
 *
 * @author orion
 */
public final class Texto {

    private Texto() {
    }

    public static String limpiar(String valor) {
    if (valor == null) {
        return null;
    }

    String limpio = valor.trim();
    return limpio.isEmpty() ? null : limpio;
}

    public static boolean estaVacio(String valor) {
        return valor == null || valor.isBlank();
    }
}
