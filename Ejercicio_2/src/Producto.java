public class Producto {
    private String codigo;
    private int cantidad;

    public Producto(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return codigo + "," + cantidad;
    }
}