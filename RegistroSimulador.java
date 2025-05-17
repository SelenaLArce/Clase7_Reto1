package Clase7_Reto1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class RegistroSimulador {

    public static void main(String[] args) {
        // Definir la ruta del archivo de parametros en la carpeta configuracion (config)
        Path rutaCarpeta = Paths.get("src/Solucion_Reto_01/config");
        Path rutaArchivo = rutaCarpeta.resolve("parametros.txt");

        // String con los parámetros de simulación
        String parametros = "Tiempo: 45.8 seg"
                          + "Velocidad: 1.2 m/s"
                          + "Número de estaciones: 6";

        try {
            // Carpeta
            if (!Files.exists(rutaCarpeta)) {
                Files.createDirectory(rutaCarpeta);
                System.out.println("Carpeta 'config' creada con éxito.");
            }

            // Escribir el contenido 
            Files.write(rutaArchivo, parametros.getBytes());
            System.out.println("Archivo de parámetros escrito.");

            // Validar si el archivo fue creado
            if (Files.exists(rutaArchivo)) {
                System.out.println("El archivo se creó con éxito en: " + rutaArchivo.toAbsolutePath());

                // Contenido
                String contenidoLeido = Files.readString(rutaArchivo);
                System.out.println("Contenido del archivo:");
                System.out.println(contenidoLeido);
            } else {
                System.out.println("No se pudo crear el archivo.");
            }

        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());
        }
    }
}
