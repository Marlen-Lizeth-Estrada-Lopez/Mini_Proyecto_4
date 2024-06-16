import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static void Añadir_Estudiantes(HashMap <String, Byte> diccionario_Estudiantes, Scanner scanner){
        System.out.print("Escriba el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        if (diccionario_Estudiantes.containsKey(nombre)) {
            System.out.println("El estudiante con el nombre " + nombre + " ya está registrado. No se puede añadir de nuevo");
        } else {
        System.out.print("Escriba la nota del estudiante: ");
        byte nota = scanner.nextByte();
        scanner.nextLine();
        diccionario_Estudiantes.put(nombre, nota);
        }
        System.out.println("¿Desea añadir a otro estudiante? Escriba si o no: ");
        String continuar = scanner.nextLine().toLowerCase();
        if (continuar.equals("si") || continuar.equals("no")){
            if (continuar.equals("si")){
            Añadir_Estudiantes(diccionario_Estudiantes, scanner);
            }
        }
        else {
            System.out.println("Lo que dijistaste no es valido, por favor escribe una de las opciones que se te mostraron, se te preguntara si quieres seguir en el sistema en el caso de estar de acuerdo se te enviara de nuevo al menú, si deseas seguir agregando estudiantes elije la opcion nuevamente");
        }
    }

    public static byte menu(HashMap <String, Byte> diccionario_Estudiantes, Scanner scanner){
        System.out.println("Opciones: ");
        System.out.println("1. Añadir estudiantes");
        System.out.println("2. Mostrar todos los estudiantes");
        System.out.println("3. Mostrar promedio de nota");
        System.out.println("4. Mostrar estudiantes con nota superior al promedio");
        System.out.println("5. Salir del sistema");
        System.out.print("Escriba su elección: ");
        try{
            byte eleccion = scanner.nextByte();
            scanner.nextLine();
            if(eleccion > 0 && eleccion <= 5){
            return eleccion;
            }
            else{
                System.out.println("Digitaste una opcion fuera del rango de opciones se te mostrara de nuevo el menu, por favor digita una de las opciones que se te dan");
                return menu(diccionario_Estudiantes, scanner);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Lo que dijistaste no es valido, por favor escribe una de las opciones que se te mostraron, a continuación se le volvera a enviar al menu");
            return menu(diccionario_Estudiantes, scanner);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenid@ al sistema de manejo de notas de la academia de Brawl Stars");
    }
}