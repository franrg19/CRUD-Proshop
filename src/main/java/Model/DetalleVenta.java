package Model;

public class DetalleVenta {
    private int id;
    private int id_venta;
    private int id_producto;
    private int cantidad;

    public DetalleVenta(int id_producto,int cantidad) {
        this.id_producto=id_producto;
        this.cantidad=cantidad;

    }

    public DetalleVenta (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
