/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria;

import com.mensajeria.dao.MensajeroDAO;
import com.mensajeria.modelo.Mensajero;
import java.util.List;

public class PruebaMensajeroDAO {

    public static void main(String[] args) {

        try {
            MensajeroDAO dao = new MensajeroDAO();

            List<Mensajero> mensajeros = dao.listarTodos();

            if (mensajeros.isEmpty()) {
                System.out.println("Consulta realizada correctamente.");
                System.out.println("Todavia no hay mensajeros registrados.");
            } else {
                System.out.println("Mensajeros encontrados: " + mensajeros.size());

                for (Mensajero mensajero : mensajeros) {
                    System.out.println(
                            mensajero.getIdMensajero() + " - "
                            + mensajero.getNombre() + " - "
                            + mensajero.getEstado()
                    );
                }
            }

        } catch (Exception e) {
            System.err.println("Error al consultar mensajeros.");
            System.err.println("Motivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}