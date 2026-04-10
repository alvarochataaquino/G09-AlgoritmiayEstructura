import java.io.*;
import java.util.*;

public class LectorArchivo {
    private int capacidadCamion;
    private int numZonas;
    private int paquetesPorZona;

    // Este método devuelve la matriz ya llena para el Estudiante 2
    public Paquete<String>[][] leerArchivo(String ruta) {
        Paquete<String>[][] matriz = null;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // 1. Leer parámetros iniciales [cite: 107]
            capacidadCamion = Integer.parseInt(br.readLine().split("=")[1].trim());
            numZonas = Integer.parseInt(br.readLine().split("=")[1].trim());
            paquetesPorZona = Integer.parseInt(br.readLine().split("-")[1].trim());

            // Inicializar la matriz [cite: 110, 111]
            matriz = new Paquete[numZonas][paquetesPorZona];
            
            // Saltar la línea de encabezado (Codigo, peso, prioridad...)
            br.readLine();

            // 2. Procesar cada paquete [cite: 108]
            String linea;
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                String[] datos = linea.split(",");
                
                String codigo = datos[0].trim();
                double peso = Double.parseDouble(datos[1].trim());
                // Aquí usamos String para el ejemplo, pero podría ser Double/Integer
                String prioridad = datos[2].trim(); 
                int valorizacion = Integer.parseInt(datos[3].trim());
                int zonaIndex = Integer.parseInt(datos[4].trim()) - 1; // Ajuste a índice 0

                // Crear el objeto genérico
                Paquete<String> nuevoPaquete = new Paquete<>(codigo, peso, prioridad, valorizacion, zonaIndex + 1);

                // 3. Guardar en la matriz (Estudiante 2 usará esto) [cite: 111]
                // Buscamos el primer espacio vacío en la fila de la zona
                for (int j = 0; j < paquetesPorZona; j++) {
                    if (matriz[zonaIndex][j] == null) {
                        matriz[zonaIndex][j] = nuevoPaquete;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return matriz;
    }

    // Getters para que el equipo use los parámetros [cite: 107]
    public int getCapacidadCamion() { return capacidadCamion; }
    public int getNumZonas() { return numZonas; }
    public int getPaquetesPorZona() { return paquetesPorZona; }
}
