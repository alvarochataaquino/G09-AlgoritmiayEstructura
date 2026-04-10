package Trabajo1;

import java.io.*;

class LectorArchivo {
    private int capacidadCamion;
    private int numZonas;
    private int paquetesPorZona;

    public PaqueteGenerico<Double>[][] leerArchivo(String ruta) {
        PaqueteGenerico<Double>[][] matriz = null;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            capacidadCamion = Integer.parseInt(br.readLine().split("=")[1].trim());
            numZonas = Integer.parseInt(br.readLine().split("=")[1].trim());
            paquetesPorZona = Integer.parseInt(br.readLine().split("-")[1].trim());
            
            matriz = new PaqueteGenerico[numZonas][paquetesPorZona];
            br.readLine(); 

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] d = linea.split(",");
                String cod = d[0].trim();
                double peso = Double.parseDouble(d[1].trim());
                double prio = Double.parseDouble(d[2].trim());
                int val = Integer.parseInt(d[3].trim());
                int z = Integer.parseInt(d[4].trim()) - 1;

                for (int j = 0; j < paquetesPorZona; j++) {
                    if (matriz[z][j] == null) {
                        matriz[z][j] = new PaqueteGenerico<>(cod, peso, prio, val, z + 1);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error ->" + e.getMessage());
        }
        return matriz;
    }

    public int getCapacidadCamion() { return capacidadCamion; }
}
