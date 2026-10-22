package com.mensajeria;

import com.mensajeria.dao.ClienteDAO;
import com.mensajeria.modelo.Cliente;
import java.util.List;

public class PruebaClienteDAO {

    public static void main(String[] args) {
        try {
            ClienteDAO dao = new ClienteDAO();

            List<Cliente> clientes = dao.listarTodos();

            if (clientes.isEmpty()) {
                System.out.println("Consulta realizada correctamente.");
                System.out.println("Todavia no hay clientes registrados.");
            } else {
                System.out.println("Clientes encontrados: " + clientes.size());

                for (Cliente cliente : clientes) {
                    System.out.println(
                            cliente.getIdCliente() + " - "
                            + cliente.getNombre()
                    );
                }
            }

        } catch (Exception e) {
            System.err.println("Error al consultar clientes.");
            System.err.println("Motivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}