/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.util;
import javax.swing.JOptionPane;

/**
 *
 * @author orion
 */

public final class Mensajes {

    private Mensajes() {
    }

    public static void informar(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Sistema de Mensajeria",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void advertir(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void error(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
