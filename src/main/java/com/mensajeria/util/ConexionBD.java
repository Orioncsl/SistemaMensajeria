/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author orion
 */
public class ConexionBD {
    private static Properties cargarConfiguracion() throws IOException {
    Properties propiedades = new Properties();

    try (InputStream entrada = ConexionBD.class
            .getClassLoader()
            .getResourceAsStream("db.properties")) {

        if (entrada == null) {
            throw new IOException(
                    "No se encontro el archivo db.properties en los recursos."
            );
        }

        propiedades.load(entrada);
    }

    return propiedades;
}
    
    public static Connection conectar() throws SQLException, IOException {
    Properties propiedades = cargarConfiguracion();

    String url = propiedades.getProperty("db.url");
    String usuario = propiedades.getProperty("db.user");
    String contrasena = propiedades.getProperty("db.password");

    if (url == null || usuario == null || contrasena == null
            || url.isBlank() || usuario.isBlank() || contrasena.isBlank()) {
        throw new IOException(
                "Faltan propiedades de conexion en db.properties."
        );
    }

    return DriverManager.getConnection(url, usuario, contrasena);
}
    
}
