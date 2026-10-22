/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.util;

/**
 *
 * @author orion
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Fechas {

    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private Fechas() {
    }

    public static String formatear(LocalDateTime fecha) {
        if (fecha == null) {
            return "";
        }

        return fecha.format(FORMATO);
    }
}