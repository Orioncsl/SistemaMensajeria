/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.dao;

import com.mensajeria.modelo.Rol;
import com.mensajeria.util.ConexionBD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDAO {

    public List<Rol> listarTodos() throws SQLException, IOException {
        List<Rol> roles = new ArrayList<>();

        String sql = """
                SELECT id_rol, nombre_rol, descripcion
                FROM rol
                ORDER BY id_rol
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                Rol rol = new Rol();

                rol.setIdRol(resultado.getInt("id_rol"));
                rol.setNombreRol(resultado.getString("nombre_rol"));
                rol.setDescripcion(resultado.getString("descripcion"));

                roles.add(rol);
            }
        }

        return roles;
    }
}