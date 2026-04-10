package Trabajo1;

class Ordenamiento<K extends Comparable<K>> {
    public void ordenarMatriz(PaqueteGenerico<K>[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (i % 2 == 0) selectionSort(matriz[i]);
            else quickSort(matriz[i], 0, matriz[i].length - 1);
        }
    }

    private void selectionSort(PaqueteGenerico<K>[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getPrioridad().compareTo(arr[max].getPrioridad()) > 0) max = j;
            }
            PaqueteGenerico<K> temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }

    private void quickSort(PaqueteGenerico<K>[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(PaqueteGenerico<K>[] arr, int low, int high) {
        K pivot = arr[high].getPrioridad();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].getPrioridad().compareTo(pivot) > 0) {
                i++;
                PaqueteGenerico<K> temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        PaqueteGenerico<K> temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}