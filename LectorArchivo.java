import java.io.*;
import java.util.*;

public class LectorArchivo {
    private int capacidadCamion;
    private int numZonas;
    private int paquetesPorZona;

    public Paquete<String>[][] leerArchivo(String ruta) {
        Paquete<String>[][] matriz = null;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            capacidadCamion = Integer.parseInt(br.readLine().split("=")[1].trim());
            numZonas = Integer.parseInt(br.readLine().split("=")[1].trim());
            paquetesPorZona = Integer.parseInt(br.readLine().split("-")[1].trim());

            matriz = new Paquete[numZonas][paquetesPorZona];
        
            br.readLine();

            String linea;
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                String[] datos = linea.split(",");
                String codigo = datos[0].trim();
                double peso = Double.parseDouble(datos[1].trim());
                String prioridad = datos[2].trim(); 
                int valorizacion = Integer.parseInt(datos[3].trim());
                int zonaIndex = Integer.parseInt(datos[4].trim()) - 1;

                Paquete<String> nuevoPaquete = new Paquete<>(codigo, peso, prioridad, valorizacion, zonaIndice + 1);
                
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
    
    public int getCapacidadCamion() { return capacidadCamion; }
    public int getNumZonas() { return numZonas; }
    public int getPaquetesPorZona() { return paquetesPorZona; }
}
