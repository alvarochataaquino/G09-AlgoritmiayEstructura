package Trabajo1;

public class Main {
    public static void main(String[] args) {
        LectorArchivo lector = new LectorArchivo();
        PaqueteGenerico<Double>[][] matriz = lector.leerArchivo("P_TXT.txt");
        
        if (matriz != null) {
            GestionZonas<Double> gestion = new GestionZonas<>(matriz);
            
            System.out.println("--- MATRIZ CARGADA (ANTES DEL ORDENAMIENTO) ---");
            gestion.mostrarMatriz();

            Ordenamiento<Double> ord = new Ordenamiento<>();
            ord.ordenarMatriz(matriz);

            System.out.println("\n--- MATRIZ ORDENADA POR PRIORIDAD (MAYOR A MENOR) ---");
            gestion.mostrarMatriz();

            SeleccionPaquetes<Double> seleccion = new SeleccionPaquetes<>();
            seleccion.resolver(matriz, lector.getCapacidadCamion());
        }
    }
}