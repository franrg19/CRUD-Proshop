import DAO.ClienteDAO;
import DAO.ConsultaDAO;
import DAO.ProductoDAO;
import DAO.VentaDAO;
import Model.Cliente;
import Model.DetalleVenta;
import Model.Productos;
import Model.Venta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- PROSHOP ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Eliminar clientes");
            System.out.println("4. Crear producto");
            System.out.println("5. Listar productos");
            System.out.println("6. Crear venta");
            System.out.println("7. Ver ventas");
            System.out.println("8. Top Productos vendidos");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            ClienteDAO clienteDAO = new ClienteDAO();
            ProductoDAO productoDAO = new ProductoDAO();
            ConsultaDAO consultaDAO = new ConsultaDAO();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    System.out.println("DNI:");
                    String dni = sc.nextLine();

                    System.out.println("Email:");
                    String email = sc.nextLine();

                    System.out.println("Telefono:");
                    String telefono = sc.nextLine();

                    Cliente cliente = new Cliente(nombre, dni, telefono, email);

                    clienteDAO.insertarCliente(cliente);
                    break;
                case 2:
                    List<Cliente> clientes = clienteDAO.listarClientes();

                    for (Cliente c : clientes) {
                        System.out.println(
                                "ID: " + c.getId() +
                                        " | Nombre: " + c.getNombre() +
                                        " | DNI: " + c.getDni() +
                                        " | Email: " + c.getEmail() +
                                        " | Teléfono: " + c.getTelefono()
                        );
                    }

                    break;
                case 3:
                    System.out.println("Introduce el ID del cliente a eliminar:");
                    int idEliminar = sc.nextInt();

                    clienteDAO.eliminarCliente(idEliminar);
                    break;
                case 4:
                    System.out.println("Nombre del producto:");
                    String nombreP = sc.nextLine();

                    System.out.println("Categoria:");
                    String categoria = sc.nextLine();

                    System.out.println("Precio:");
                    double precio = sc.nextDouble();

                    System.out.println("Stock:");
                    int stock = sc.nextInt();

                    Productos producto = new Productos (nombreP, categoria, precio, stock);

                    productoDAO.insertarProducto(producto);
                    break;
                case 5:
                    List<Productos> productos = productoDAO.listarProductos();

                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados");
                    } else {
                        for (Productos p : productos) {
                            System.out.println(
                                    "ID: " + p.getId() +
                                            " | Nombre: " + p.getNombre() +
                                            " | Categoria: " + p.getCategoria() +
                                            " | Precio: " + p.getPrecio() +
                                            " | Stock: " + p.getStock()
                            );
                        }
                    }

                    break;


                case 6:
                    System.out.println("ID del cliente:");
                    int idCliente = sc.nextInt();

                    // Crear venta
                    Venta venta = new Venta("2026-04-20", idCliente);

                    List<DetalleVenta> detalles = new ArrayList<>();

                    char continuar;

                    do {
                        System.out.println("ID del producto:");
                        int idProducto = sc.nextInt();

                        System.out.println("Cantidad:");
                        int cantidad = sc.nextInt();

                        detalles.add(new DetalleVenta(idProducto, cantidad));

                        System.out.println("¿Añadir otro producto? (s/n)");
                        continuar = sc.next().charAt(0);

                    } while (continuar == 's');

                    VentaDAO ventaDAO = new VentaDAO();
                    ventaDAO.crearVenta(venta, detalles);

                    break;
                case 7:
                    consultaDAO.listarVentas();
                    break;

                case 8:
                    consultaDAO.topProductosVendidos();
                    break;
            }

        } while (opcion != 0);
    }

}
