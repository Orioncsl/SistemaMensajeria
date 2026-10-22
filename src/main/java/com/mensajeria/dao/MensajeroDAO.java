/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.dao;

import com.mensajeria.modelo.Mensajero;
import com.mensajeria.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MensajeroDAO {

    public List<Mensajero> listarTodos() throws SQLException, IOException {

        List<Mensajero> mensajeros = new ArrayList<>();

        String sql = """
                SELECT id_mensajero, nombre, telefono, direccion, estado
                FROM mensajero
                ORDER BY id_mensajero
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Mensajero mensajero = new Mensajero();

                mensajero.setIdMensajero(resultado.getInt("id_mensajero"));
                mensajero.setNombre(resultado.getString("nombre"));
                mensajero.setTelefono(resultado.getString("telefono"));
                mensajero.setDireccion(resultado.getString("direccion"));
                mensajero.setEstado(resultado.getString("estado"));

                mensajeros.add(mensajero);
            }
        }

        return mensajeros;
    }
}