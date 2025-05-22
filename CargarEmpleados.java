package Practicas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargarEmpleados {

    public static List<Empleado> cargarEmpleados(String rutaArchivo) {
    	
        List<Empleado> empleados = new ArrayList<>(); // Realizamos una lista de empleados
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) { // Lee hasta que no haya mas líneas
                String[] fila = linea.split("#");
                
                // Parsear los datos desde el archivo de texto a los atributos del objeto Empleado
                String nombre = fila[1];
                String apellido1 = fila[2];
                String apellido2 = fila[3];
                int edad = Integer.parseInt(fila[4]);
                String sexo = fila[5];
                String telefono = fila[6];
                double salario = Double.parseDouble(fila[7].replace(",", "."));
                String dni = fila[8];

                // Creamos un objeto Empleado con los datos que hemos obtenido
                Empleado empleado = new Empleado(nombre, apellido1, apellido2, edad, sexo, telefono, salario, dni);

                // Añadimos el empleado a la lista
                empleados.add(empleado);
            }

            // Si la lista esta vacía, se indica que el archibo esta vacío
            if (empleados.isEmpty()) {
                System.out.println("El archivo está vacío.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + rutaArchivo);
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato numérico.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error : " + e.getMessage());
        }

        return empleados; // Devolvemos la lista
    }
}

