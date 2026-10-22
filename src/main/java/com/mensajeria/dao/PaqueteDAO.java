/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.dao;

import com.mensajeria.modelo.Paquete;
import com.mensajeria.util.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaqueteDAO {

    public List<Paquete> listarTodos() throws SQLException, IOException {

        List<Paquete> paquetes = new ArrayList<>();

        String sql = """
                SELECT id_paquete, tipo, descripcion, peso, dimensiones
                FROM paquete
                ORDER BY id_paquete
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Paquete paquete = new Paquete();

                paquete.setIdPaquete(resultado.getInt("id_paquete"));
                paquete.setTipo(resultado.getString("tipo"));
                paquete.setDescripcion(resultado.getString("descripcion"));

                java.math.BigDecimal peso = resultado.getBigDecimal("peso");
                paquete.setPeso(peso);

                paquete.setDimensiones(resultado.getString("dimensiones"));

                paquetes.add(paquete);
            }
        }

        return paquetes;
    }
}