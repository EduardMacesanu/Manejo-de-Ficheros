package Practicas;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        List<Empleado> empleados = null;

        while (opcion != 3) {
            System.out.println("Menú principal:");
            System.out.println("1. Cargar fichero de empleados");
            System.out.println("2. Generar fichero XML de subvenciones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca la ruta del fichero : ");
                    String rutaArchivo = sc.nextLine();
                    empleados = CargarEmpleados.cargarEmpleados(rutaArchivo);

                    if (empleados.isEmpty()) {
                        System.out.println("Error al cargar el fichero");
                    } else {
                        System.out.println("Empleados cargados correctamente.");
                        // Creamos el archivo empleadosNavidad.dat
                        CrearEmpleadosNavidad.crearArchivoNavidad(empleados, "empleadosNavidad.dat");
                    }
                    break;

                case 2:
                    if (empleados == null || empleados.isEmpty()) {
                        System.out.println("Error: Debe cargar los empleados primero.");
                        break;
                    }

                    System.out.println("Seleccione el tipo de XML a generar:");
                    System.out.println("1. Menores de 25");
                    System.out.println("2. Mayores de 55");
                    int tipoXML = sc.nextInt();
                    if (tipoXML == 1) {
                        // Generar XML para menores de 25
                        GenerarSubvencionesXML.generarXMLSubvencion("subvenciones_menores_25.xml", empleados, 0, 25);
                    } else if (tipoXML == 2) {
                        // Generar XML para mayores de 55
                        GenerarSubvencionesXML.generarXMLSubvencion("subvenciones_mayores_55.xml", empleados, 56, Integer.MAX_VALUE); // Se hace hasta el valor máximo
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3:
                    System.out.println("Programa terminado");
                    break;

                default:
                    System.out.println("Opción no incorrecta, seleccione una opción correcta.");
                    break;
            }
        }

        sc.close();
    }
}

