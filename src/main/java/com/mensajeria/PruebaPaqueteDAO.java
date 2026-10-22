package com.mensajeria;

import com.mensajeria.dao.PaqueteDAO;
import com.mensajeria.modelo.Paquete;
import java.util.List;

public class PruebaPaqueteDAO {

    public static void main(String[] args) {
        try {
            PaqueteDAO dao = new PaqueteDAO();
            List<Paquete> paquetes = dao.listarTodos();

            if (paquetes.isEmpty()) {
                System.out.println("Consulta realizada correctamente.");
                System.out.println("Todavia no hay paquetes registrados.");
            } else {
                System.out.println("Paquetes encontrados: " + paquetes.size());

                for (Paquete paquete : paquetes) {
                    System.out.println(
                            paquete.getIdPaquete() + " - "
                            + paquete.getTipo() + " - "
                            + paquete.getDescripcion() + " - "
                            + paquete.getPeso()
                    );
                }
            }

        } catch (Exception e) {
            System.err.println("Error al consultar paquetes.");
            System.err.println("Motivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}