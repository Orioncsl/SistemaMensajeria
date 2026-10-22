package com.mensajeria.dao;

import com.mensajeria.modelo.Cliente;
import com.mensajeria.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listarTodos() throws SQLException, java.io.IOException {

        List<Cliente> clientes = new ArrayList<>();

        String sql = """
                SELECT id_cliente, nombre, telefono, direccion, correo
                FROM cliente
                ORDER BY id_cliente
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(resultado.getInt("id_cliente"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setCorreo(resultado.getString("correo"));

                clientes.add(cliente);
            }
        }

        return clientes;
    }
}