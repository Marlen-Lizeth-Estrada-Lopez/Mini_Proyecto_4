import java.io.FileWriter;
import java.io.IOException;
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

    public void eliminarProducto(String codigo) {
        if (inventario.remove(codigo) != null) {
            System.out.println("Producto " + codigo + " eliminado del inventario.");
        } else {
            System.out.println("El producto con código " + codigo + " no existe.");
        }
    }

    public void buscarProducto(String codigo) {
        Producto producto = inventario.get(codigo);
        if (producto != null) {
            System.out.println("Producto " + codigo + ": cantidad " + producto.getCantidad());
        } else {
            System.out.println("El producto con código " + codigo + " no existe.");
        }
    }

    public void guardarInventario(String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            for (Producto producto : inventario.values()) {
                writer.write(producto.toString() + "\n");
            }
            System.out.println("Inventario guardado en " + archivo + ".");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }
}