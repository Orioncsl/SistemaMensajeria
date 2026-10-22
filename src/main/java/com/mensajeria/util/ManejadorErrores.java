/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.util;

/**
 *
 * @author orion
 */
public final class ManejadorErrores {

    private ManejadorErrores() {
    }

    public static void manejar(String contexto, Exception error) {
        System.err.println("Error en: " + contexto);
        System.err.println("Detalle: " + error.getMessage());
        error.printStackTrace();

        Mensajes.error(
                "Ocurrio un problema al " + contexto
                + ". Consulte el registro de errores."
        );
    }
}
