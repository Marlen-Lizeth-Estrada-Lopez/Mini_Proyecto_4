import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Gestion_Inventario gestionInventario = new Gestion_Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones del sistema de gestión de inventario:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar cantidad");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Buscar producto");
            System.out.println("5. Guardar inventario");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el código del producto: ");
                    String codigoAgregar = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidadAgregar = Integer.parseInt(scanner.nextLine());
                    gestionInventario.agregarProducto(codigoAgregar, cantidadAgregar);
                    break;
                case "2":
                    System.out.print("Ingrese el código del producto: ");
                    String codigoActualizar = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad: ");
                    int cantidadActualizar = Integer.parseInt(scanner.nextLine());
                    gestionInventario.actualizarCantidad(codigoActualizar, cantidadActualizar);
                    break;
                case "3":
                    System.out.print("Ingrese el código del producto: ");
                    String codigoEliminar = scanner.nextLine();
                    gestionInventario.eliminarProducto(codigoEliminar);
                    break;
                case "4":
                    System.out.print("Ingrese el código del producto: ");
                    String codigoBuscar = scanner.nextLine();
                    gestionInventario.buscarProducto(codigoBuscar);
                    break;
                case "5":
                    System.out.print("Ingrese el nombre del archivo para guardar el inventario: ");
                    String archivo = scanner.nextLine();
                    gestionInventario.guardarInventario(archivo);
                    break;
                case "6":
                    System.out.println("Saliendo del sistema de gestión de inventario.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}