package DAO;

import DataBase.ConexionDB;
import Model.DetalleVenta;
import Model.Venta;

import java.sql.*;
import java.util.List;

public class VentaDAO {

    public void crearVenta(Venta venta, List<DetalleVenta> detalles) {

        String sqlVenta = "INSERT INTO ventas (fecha, id_cliente) VALUES (?, ?)";
        String sqlDetalle = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad) VALUES (?, ?, ?)";

        try (Connection con = ConexionDB.conectar()) {

            // insertar la venta
            PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
            psVenta.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            psVenta.setInt(2, venta.getId_cliente());
            psVenta.executeUpdate();

            // Obtener ID venta
            ResultSet rs = psVenta.getGeneratedKeys();
            int idVenta = 0;
            if (rs.next()) {
                idVenta = rs.getInt(1);
            }

            // Insertar detalles
            PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);

            for (DetalleVenta d : detalles) {
                psDetalle.setInt(1, idVenta);
                psDetalle.setInt(2, d.getId_producto());
                psDetalle.setInt(3, d.getCantidad());
                psDetalle.addBatch();
            }

            psDetalle.executeBatch();
            System.out.println("Venta creada correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
