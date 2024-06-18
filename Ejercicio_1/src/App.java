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

    public static float Calcular_promedio(HashMap <String, Byte> diccionario_Estudiantes){
        short cantidad_de_estudiantes = (short)(diccionario_Estudiantes.size());
        short suma_notas = 0;
        for (String indice: diccionario_Estudiantes.keySet()){
            suma_notas += (short)diccionario_Estudiantes.get(indice);
        }
        float promedio = (float)(suma_notas / cantidad_de_estudiantes);
        return promedio;
    }

    public static void Imprimir_estudiantes_con_sus_notas(HashMap <String, Byte> diccionario_Estudiantes){
        for (String indice: diccionario_Estudiantes.keySet()){
            Byte nota = diccionario_Estudiantes.get(indice);
            System.out.println("Estudiante: " + indice + " Nota: " + nota);
        }
    }

    public static void Imprimir_estudiantes_con_notas_superiores_al_promedio(HashMap <String, Byte> diccionario_Estudiantes, float promedio){
        for (String indice: diccionario_Estudiantes.keySet()){
            if (diccionario_Estudiantes.get(indice) > promedio){
                Byte nota = diccionario_Estudiantes.get(indice);
                System.out.println("Estudiante: " + indice + " Nota: " + nota);
            }
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

    public static void Estructura_de_elecciones(HashMap <String, Byte> diccionario_Estudiantes, Scanner scanner, byte eleccion){
        switch (eleccion) {
            case 1:
                Añadir_Estudiantes(diccionario_Estudiantes, scanner);
                Continuar(diccionario_Estudiantes, scanner);
                break;

            case 2:
                Imprimir_estudiantes_con_sus_notas(diccionario_Estudiantes);
                Continuar(diccionario_Estudiantes, scanner);
                break;

            case 3:
                System.out.println("Promedio: " + Calcular_promedio(diccionario_Estudiantes));
                Continuar(diccionario_Estudiantes, scanner);
                break;
            
            case 4:
                Imprimir_estudiantes_con_notas_superiores_al_promedio(diccionario_Estudiantes, Calcular_promedio(diccionario_Estudiantes));
                Continuar(diccionario_Estudiantes, scanner);
                break;

            default:
                break;
        }
    }

    public static void Continuar(HashMap <String, Byte> diccionario_Estudiantes, Scanner scanner){
        System.out.println("¿Desea continuar en el sistema? Escriba si o no: ");
        String eleccion = scanner.nextLine().toLowerCase();
        if (eleccion.equals("si") || eleccion.equals("no")){
            if (eleccion.equals("si")){
            Estructura_de_elecciones(diccionario_Estudiantes, scanner, menu(diccionario_Estudiantes, scanner));
        }
        }
        else {
            System.out.println("Lo que dijistaste no es valido, por favor escribe una de las opciones que se te mostraron");
            Continuar(diccionario_Estudiantes, scanner);
        }
    }

    public static void main(String[] args) throws Exception {
        HashMap <String, Byte> diccionario_Estudiantes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenid@ al sistema de manejo de notas de la academia de Brawl Stars");
        Estructura_de_elecciones(diccionario_Estudiantes, scanner, menu(diccionario_Estudiantes, scanner));
    }
}