/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mensajeria;

import com.mensajeria.dao.EnvioDAO;
import com.mensajeria.dao.HistorialEstadoDAO;
import com.mensajeria.dao.RolDAO;
import com.mensajeria.dao.UsuarioDAO;
import com.mensajeria.modelo.Envio;
import com.mensajeria.modelo.HistorialEstado;
import com.mensajeria.modelo.Rol;
import com.mensajeria.modelo.Usuario;
import java.util.List;

public class PruebaDAOAdicionales {

    public static void main(String[] args) throws Exception {

        // 1. Probar la consulta de roles.
        List<Rol> roles = new RolDAO().listarTodos();

        System.out.println("Consulta de roles correcta.");
        System.out.println("Cantidad de roles: " + roles.size());

        // 2. Probar la consulta de usuarios.
        List<Usuario> usuarios = new UsuarioDAO().listarTodos();

        System.out.println("Consulta de usuarios correcta.");
        System.out.println("Cantidad de usuarios: " + usuarios.size());

        // 3. Probar la consulta de envíos.
        List<Envio> envios = new EnvioDAO().listarTodos();

        System.out.println("Consulta de envíos correcta.");
        System.out.println("Cantidad de envíos: " + envios.size());

        // 4. Probar el historial si hay algún envío.
        if (!envios.isEmpty()) {

            Integer idEnvio = envios.get(0).getIdEnvio();

            List<HistorialEstado> historial =
                    new HistorialEstadoDAO().listarPorEnvio(idEnvio);

            System.out.println("Consulta de historial correcta.");
            System.out.println(
                    "Registros de historial: " + historial.size()
            );

        } else {
            System.out.println(
                    "Historial no probado: todavía no hay envíos."
            );
        }

        System.out.println("Pruebas de DAO finalizadas.");
    }
}
