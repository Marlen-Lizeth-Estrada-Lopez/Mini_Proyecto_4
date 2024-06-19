import java.util.HashMap;

public class Gestion_Inventario {
    private HashMap<String, Producto> inventario;

    public Gestion_Inventario() {
        this.inventario = new HashMap<>();
    }

    public void agregarProducto(String codigo, int cantidad) {
        if (inventario.containsKey(codigo)) {
            System.out.println("El producto con código " + codigo + " ya existe. Use la opción de actualizar cantidad.");
        } else {
            inventario.put(codigo, new Producto(codigo, cantidad));
            System.out.println("Producto " + codigo + " agregado con cantidad " + cantidad + ".");
        }
    }

    public void actualizarCantidad(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null) {
            producto.setCantidad(cantidad);
            System.out.println("Cantidad del producto " + codigo + " actualizada a " + cantidad + ".");
        } else {
            System.out.println("El producto con código " + codigo + " no existe. Use la opción de agregar producto.");
        }
    }
}