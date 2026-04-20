package DAO;


import DataBase.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaDAO {
    public void listarVentas() {

        String sql = "SELECT v.id, c.nombre, p.nombre, d.cantidad, v.fecha " +
                "FROM ventas v " +
                "JOIN clientes c ON v.id_cliente = c.id " +
                "JOIN detalle_venta d ON v.id = d.id_venta " +
                "JOIN productos p ON d.id_producto = p.id " +
                "ORDER BY v.id";

        try (Connection con = ConexionDB.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                int idVenta = rs.getInt(1);
                String cliente = rs.getString(2);
                String producto = rs.getString(3);
                int cantidad = rs.getInt(4);
                String fecha = rs.getString(5);

                System.out.println("Venta " + idVenta + " | " +
                        cliente + " | " +
                        producto + " | Cantidad: " + cantidad +
                        " | Fecha: " + fecha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void topProductosVendidos (){
        String sql = "SELECT p.nombre, SUM(d.cantidad) AS total_vendido " +
                "FROM detalle_venta d " +
                "JOIN productos p ON d.id_producto = p.id " +
                "GROUP BY p.nombre " +
                "ORDER BY total_vendido DESC";

        try(
                Connection con = ConexionDB.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ){

            System.out.println("=== TOP PRODUCTOS MÁS VENDIDOS ===");
            while (rs.next()) {
                String nombre = rs.getString(1);
                int total = rs.getInt(2);

                System.out.println(nombre + " - " + total + " unidades");
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}