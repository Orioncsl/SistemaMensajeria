/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.servicio;

import com.mensajeria.dao.ClienteDAO;
import com.mensajeria.modelo.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClienteServicio {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> listarTodos() throws SQLException, IOException {
        return clienteDAO.listarTodos();
    }

    public void validar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException(
                    "El cliente no puede ser nulo.");
        }

        if (cliente.getNombre() == null
                || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del cliente es obligatorio.");
        }

        cliente.setNombre(cliente.getNombre().trim());

        if (cliente.getTelefono() != null) {
            cliente.setTelefono(cliente.getTelefono().trim());
        }

        if (cliente.getDireccion() != null) {
            cliente.setDireccion(cliente.getDireccion().trim());
        }

        if (cliente.getCorreo() != null) {
            cliente.setCorreo(cliente.getCorreo().trim());
        }
    }
}