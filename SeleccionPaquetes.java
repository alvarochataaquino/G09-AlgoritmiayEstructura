package Trabajo1;

import java.util.*;

class SeleccionPaquetes<K extends Comparable<K>> {
    public void resolver(PaqueteGenerico<K>[][] matriz, int cap) {
        List<PaqueteGenerico<K>> lista = new ArrayList<>();
        for (PaqueteGenerico<K>[] fila : matriz) {
            for (PaqueteGenerico<K> p : fila) if (p != null) lista.add(p);
        }

        int n = lista.size();
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= cap; w++) {
                if (lista.get(i - 1).getPeso() <= w) {
                    dp[i][w] = Math.max(lista.get(i - 1).getValorizacion() + dp[i - 1][w - (int)lista.get(i - 1).getPeso()], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("\n--- SELECCION DE PAQUETES (MOCHILA 0/1) ---");
        System.out.println("Valorizacion Total Maxima: " + dp[n][cap]);
        int res = dp[n][cap];
        int w = cap;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                System.out.println("Cargado: " + lista.get(i - 1));
                res -= lista.get(i - 1).getValorizacion();
                w -= (int)lista.get(i - 1).getPeso();
            }
        }
    }
}