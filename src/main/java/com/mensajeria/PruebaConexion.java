/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria;

import com.mensajeria.util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PruebaConexion {

    public static void main(String[] args) {
        try (Connection conexion = ConexionBD.conectar(); Statement sentencia = conexion.createStatement(); ResultSet resultado = sentencia.executeQuery(
                "SELECT USER, SYS_CONTEXT('USERENV', 'SERVICE_NAME') "
                + "FROM DUAL")) {

            if (resultado.next()) {
                System.out.println("Conexion a Oracle exitosa.");
                System.out.println("Usuario: " + resultado.getString(1));
                System.out.println("Servicio: " + resultado.getString(2));
            }

        } catch (Exception e) {
            System.err.println("No se pudo conectar a Oracle.");
            System.err.println("Motivo: " + e.getMessage());
        }
    }
}
