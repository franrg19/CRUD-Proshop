package Model;

public class Venta {
    private int id;
    private String fecha;
    private int id_cliente;

    public Venta(String fecha, int id_cliente) {
        this.fecha = fecha;
        this.id_cliente = id_cliente;
    }
    public Venta(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
