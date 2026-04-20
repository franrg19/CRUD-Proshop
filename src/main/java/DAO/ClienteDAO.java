package DAO;

import DataBase.ConexionDB;
import Model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // 1. Crear Cliente en BBDD

    public  void insertarCliente(Cliente c){
        String sql = "INSERT INTO clientes (nombre,dni,email,telefono) VALUES (?,?,?,?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDni());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefono());

            ps.executeUpdate();
            System.out.println("Cliente creado con exito");
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente");;
        }
    }


    //2. Listar clientes

    public List <Cliente> listarClientes (){
        List <Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = ConexionDB.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()){
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDni(rs.getString("dni"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));

                lista.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return lista;
    }

    //3. Modificar Cliente
    public void actualizarCliente (Cliente cliente){
        String sql = "UPDATE cliente SET nombre = ?, email = ?, telefono = ? WHERE id_cliente = ? ";

        try(Connection con = ConexionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //4. Eliminar Cliente
    public void eliminarCliente (int id){
        String sql = "DELETE FROM clientes WHERE id = ?";

        try(Connection con = ConexionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.executeUpdate();

            System.out.println("cliente eliminado");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
