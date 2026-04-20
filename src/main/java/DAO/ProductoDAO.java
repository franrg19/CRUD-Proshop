package DAO;

import DataBase.ConexionDB;
import Model.Productos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // 1. insertar
    public void insertarProducto (Productos p){
        String sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?,?,?,?)";

        try(Connection con = ConexionDB.conectar();
            PreparedStatement ps =con.prepareStatement(sql);
        ){
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3,p.getPrecio());
            ps.setInt(4,p.getStock());

            ps.executeUpdate();

            System.out.println("Producto insertado con exito");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //2. Eliminar producto
    public void eliminarProducto (int id){
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection con = ConexionDB.conectar();
        PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (Exception e) {
            System.out.println("Error al eliminar el producto");
            e.printStackTrace();
        }
    }

    //3. Listar productos
    public List <Productos> listarProductos (){
        List <Productos> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (
                Connection con = ConexionDB.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)){

            while (rs.next()){
                Productos p =new Productos();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));

                productos.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return productos;
    }
}
