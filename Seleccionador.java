import java.util.ArrayList;
import java.util.List;

public class Seleccionador {

    // Método Recursivo
    public static <T extends Comparable<T>> int recursiva(List<Paquete<T>> paq, int n, int cap) {
        if (n == 0 || cap == 0) return 0;
        if (paq.get(n - 1).peso > cap) return recursiva(paq, n - 1, cap);
        return Math.max(
            paq.get(n - 1).valorizacion + recursiva(paq, n - 1, cap - paq.get(n - 1).peso),
            recursiva(paq, n - 1, cap)
        );
    }

    // Método de Programación Dinámica
    public static <T extends Comparable<T>> List<Paquete<T>> dinamica(List<Paquete<T>> paq, int cap) {
        int n = paq.size();
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= cap; w++) {
                if (paq.get(i - 1).peso <= w) {
                    dp[i][w] = Math.max(paq.get(i - 1).valorizacion + dp[i - 1][w - paq.get(i - 1).peso], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        List<Paquete<T>> res = new ArrayList<>();
        int w = cap;
        for (int i = n; i > 0 && dp[i][w] > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                res.add(paq.get(i - 1));
                w -= paq.get(i - 1).peso;
            }
        }
        return res;
    }
}
