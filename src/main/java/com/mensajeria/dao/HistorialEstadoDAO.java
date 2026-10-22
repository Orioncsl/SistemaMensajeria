/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.dao;

import com.mensajeria.modelo.HistorialEstado;
import com.mensajeria.util.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialEstadoDAO {

    public List<HistorialEstado> listarPorEnvio(int idEnvio)
            throws SQLException, IOException {

        List<HistorialEstado> historial = new ArrayList<>();

        String sql = """
                SELECT id_historial, id_envio, estado,
                       fecha_hora, id_usuario, observacion
                FROM historial_estado
                WHERE id_envio = ?
                ORDER BY fecha_hora, id_historial
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idEnvio);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    HistorialEstado registro = new HistorialEstado();

                    registro.setIdHistorial(
                            resultado.getInt("id_historial"));
                    registro.setIdEnvio(
                            resultado.getInt("id_envio"));
                    registro.setEstado(
                            resultado.getString("estado"));

                    registro.setFechaHora(
                            resultado.getTimestamp("fecha_hora")
                                    .toLocalDateTime());

                    registro.setIdUsuario(
                            resultado.getInt("id_usuario"));
                    registro.setObservacion(
                            resultado.getString("observacion"));

                    historial.add(registro);
                }
            }
        }

        return historial;
    }
}