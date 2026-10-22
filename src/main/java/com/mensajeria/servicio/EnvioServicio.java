/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.servicio;

import com.mensajeria.dao.EnvioDAO;
import com.mensajeria.modelo.Envio;
import com.mensajeria.modelo.EstadoEnvio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EnvioServicio {

    private final EnvioDAO envioDAO = new EnvioDAO();

    public List<Envio> listarTodos() throws SQLException, IOException {
        return envioDAO.listarTodos();
    }

    public void validarNuevo(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException(
                    "El envío no puede ser nulo.");
        }

        if (envio.getIdCliente() == null
                || envio.getIdCliente() <= 0) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un cliente válido.");
        }

        if (envio.getIdPaquete() == null
                || envio.getIdPaquete() <= 0) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un paquete válido.");
        }

        if (envio.getNombreDestinatario() == null
                || envio.getNombreDestinatario().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del destinatario es obligatorio.");
        }

        if (envio.getDireccionDestino() == null
                || envio.getDireccionDestino().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La dirección de destino es obligatoria.");
        }

        if (envio.getFechaEnvio() == null) {
            throw new IllegalArgumentException(
                    "La fecha del envío es obligatoria.");
        }

        envio.setNombreDestinatario(
                envio.getNombreDestinatario().trim());

        envio.setDireccionDestino(
                envio.getDireccionDestino().trim());

        if (envio.getEstado() == null) {
            envio.setEstado(EstadoEnvio.REGISTRADO);
        }

        if (envio.getEstado() != EstadoEnvio.REGISTRADO) {
            throw new IllegalArgumentException(
                    "Un envío nuevo debe comenzar en estado Registrado.");
        }
    }
}