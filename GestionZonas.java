package Trabajo1;

class GestionZonas<K extends Comparable<K>> {
    private PaqueteGenerico<K>[][] matriz;

    public GestionZonas(PaqueteGenerico<K>[][] matriz) {
        this.matriz = matriz;
    }

    public void mostrarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Zona " + (i + 1) + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null) System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
