/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.dao;

import com.mensajeria.modelo.Envio;
import com.mensajeria.modelo.EstadoEnvio;
import com.mensajeria.util.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EnvioDAO {

    public List<Envio> listarTodos() throws SQLException, IOException {
        List<Envio> envios = new ArrayList<>();

        String sql = """
                SELECT id_envio, id_cliente, id_paquete, id_mensajero,
                       fecha_envio, nombre_destinatario,
                       telefono_destinatario, direccion_destino,
                       estado, fecha_entrega, recibido_por,
                       motivo_fallo, observaciones
                FROM envio
                ORDER BY id_envio
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                Envio envio = new Envio();

                envio.setIdEnvio(resultado.getInt("id_envio"));
                envio.setIdCliente(resultado.getInt("id_cliente"));
                envio.setIdPaquete(resultado.getInt("id_paquete"));

                int idMensajero = resultado.getInt("id_mensajero");
                envio.setIdMensajero(
                        resultado.wasNull() ? null : idMensajero);

                Timestamp fechaEnvio =
                        resultado.getTimestamp("fecha_envio");

                if (fechaEnvio != null) {
                    envio.setFechaEnvio(fechaEnvio.toLocalDateTime());
                }

                envio.setNombreDestinatario(
                        resultado.getString("nombre_destinatario"));

                envio.setTelefonoDestinatario(
                        resultado.getString("telefono_destinatario"));

                envio.setDireccionDestino(
                        resultado.getString("direccion_destino"));

                String estado = resultado.getString("estado");

                if (estado != null) {
                    envio.setEstado(EstadoEnvio.desdeEtiqueta(estado));
                }

                Timestamp fechaEntrega =
                        resultado.getTimestamp("fecha_entrega");

                if (fechaEntrega != null) {
                    envio.setFechaEntrega(fechaEntrega.toLocalDateTime());
                }

                envio.setRecibidoPor(resultado.getString("recibido_por"));
                envio.setMotivoFallo(resultado.getString("motivo_fallo"));
                envio.setObservaciones(resultado.getString("observaciones"));

                envios.add(envio);
            }
        }

        return envios;
    }
}