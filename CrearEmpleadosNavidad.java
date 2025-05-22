package Practicas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CrearEmpleadosNavidad {

    public static void crearArchivoNavidad(List<Empleado> empleados, String rutaArchivo) {
    	
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            for (Empleado empleado : empleados) {
            	 // Escribimos cada objeto Empleado en el archivo .dat
                salida.writeObject(empleado);
            }
            System.out.println("Archivo " + rutaArchivo + " creado");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}