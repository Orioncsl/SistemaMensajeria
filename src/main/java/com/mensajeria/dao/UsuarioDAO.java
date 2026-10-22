/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.dao;

import com.mensajeria.modelo.Usuario;
import com.mensajeria.util.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> listarTodos() throws SQLException, IOException {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = """
                SELECT id_usuario, id_rol, nombre_usuario, clave_hash, estado
                FROM usuario
                ORDER BY id_usuario
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Usuario usuario = new Usuario();

                usuario.setIdUsuario(resultado.getInt("id_usuario"));
                usuario.setIdRol(resultado.getInt("id_rol"));
                usuario.setNombreUsuario(resultado.getString("nombre_usuario"));
                usuario.setClaveHash(resultado.getString("clave_hash"));
                usuario.setEstado(resultado.getString("estado"));

                usuarios.add(usuario);
            }
        }

        return usuarios;
    }
}