/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.servicio;

import com.mensajeria.dao.PaqueteDAO;
import com.mensajeria.modelo.Paquete;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class PaqueteServicio {

    private final PaqueteDAO paqueteDAO = new PaqueteDAO();

    public List<Paquete> listarTodos() throws SQLException, IOException {
        return paqueteDAO.listarTodos();
    }

    public void validar(Paquete paquete) {
        if (paquete == null) {
            throw new IllegalArgumentException(
                    "El paquete no puede ser nulo.");
        }

        if (paquete.getTipo() == null
                || (!paquete.getTipo().equals("Paquete")
                && !paquete.getTipo().equals("Documento"))) {
            throw new IllegalArgumentException(
                    "El tipo debe ser Paquete o Documento.");
        }

        if (paquete.getDescripcion() == null
                || paquete.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción del paquete es obligatoria.");
        }

        paquete.setDescripcion(paquete.getDescripcion().trim());

        BigDecimal peso = paquete.getPeso();

        if (peso != null && peso.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "El peso debe ser mayor que cero.");
        }

        if (paquete.getDimensiones() != null) {
            paquete.setDimensiones(
                    paquete.getDimensiones().trim());
        }
    }
}
