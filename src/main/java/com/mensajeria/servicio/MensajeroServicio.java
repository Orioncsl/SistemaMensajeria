/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.servicio;

import com.mensajeria.dao.MensajeroDAO;
import com.mensajeria.modelo.Mensajero;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MensajeroServicio {

    private final MensajeroDAO mensajeroDAO = new MensajeroDAO();

    public List<Mensajero> listarTodos()
            throws SQLException, IOException {
        return mensajeroDAO.listarTodos();
    }

    public void validar(Mensajero mensajero) {
        if (mensajero == null) {
            throw new IllegalArgumentException(
                    "El mensajero no puede ser nulo.");
        }

        if (mensajero.getNombre() == null
                || mensajero.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del mensajero es obligatorio.");
        }

        mensajero.setNombre(mensajero.getNombre().trim());

        String estado = mensajero.getEstado();

        if (estado == null || estado.trim().isEmpty()) {
            mensajero.setEstado("Activo");
        } else if (!estado.equalsIgnoreCase("Activo")
                && !estado.equalsIgnoreCase("Inactivo")) {
            throw new IllegalArgumentException(
                    "El estado debe ser Activo o Inactivo.");
        }
    }
}