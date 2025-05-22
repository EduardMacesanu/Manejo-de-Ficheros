package Practicas;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.List;

public class GenerarSubvencionesXML {

    public static void generarXMLSubvencion(String nombreArchivo, List<Empleado> empleados, int edadMin, int edadMax) {
    	
        try {
        	
            // Crear el constructor de documentos
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Elemento raíz
            Document doc = docBuilder.newDocument();
            Element raiz = doc.createElement("Empleados");
            doc.appendChild(raiz);

            // Filtrar los empleados por rango de edad
            for (Empleado empleado : empleados) {
                if (empleado.getEdad() >= edadMin && empleado.getEdad() <= edadMax) {
                    // Creamos el elemento principal Empleado
                    Element empleadoElement = doc.createElement("Empleado");
                    raiz.appendChild(empleadoElement);

                    
                    
                    // DNI
                    Element dni = doc.createElement("DNI");
                    dni.appendChild(doc.createTextNode(empleado.getDni()));
                    empleadoElement.appendChild(dni); // Dentro de la etiqueta Empleado

                    // Nombre
                    Element nombre = doc.createElement("Nombre");
                    nombre.appendChild(doc.createTextNode(empleado.getNombre()));
                    empleadoElement.appendChild(nombre);

                    // Apellidos
                    Element apellidos = doc.createElement("Apellidos");
                    apellidos.appendChild(doc.createTextNode(empleado.getApellido1() + " " + empleado.getApellido2()));
                    empleadoElement.appendChild(apellidos);

                    // Edad
                    Element edad = doc.createElement("Edad");
                    edad.appendChild(doc.createTextNode(String.valueOf(empleado.getEdad())));
                    empleadoElement.appendChild(edad);

                    // Teléfono
                    Element telefono = doc.createElement("Telefono");
                    telefono.appendChild(doc.createTextNode(empleado.getTelefono()));
                    empleadoElement.appendChild(telefono);

                    // Sexo
                    Element sexo = doc.createElement("Sexo");
                    sexo.appendChild(doc.createTextNode(empleado.getSexo()));
                    empleadoElement.appendChild(sexo);

                    // Sueldo (anual en 14 pagas)
                    Element sueldo = doc.createElement("Sueldo");
                    sueldo.appendChild(doc.createTextNode(String.format("%.2f", empleado.getSalario() * 14))); // Tiene 14 pagas
                    empleadoElement.appendChild(sueldo);
                }
            }

            
            
            // Verificar y crear el directorio si no existe
            File dir = new File("Subvenciones");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Escribir el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(dir, nombreArchivo));

            transformer.transform(source, result);

            System.out.println("Archivo " + nombreArchivo + " creado");

        } catch (ParserConfigurationException e) {
            System.err.println("Error de configuración del parser: " + e.getMessage());
        } catch (TransformerException e) {
            System.err.println("Error al transformar el documento XML: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
