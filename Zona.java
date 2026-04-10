package mipaquete;
import java.util.*;
public class Zona{ //donde se guardalos p
	private PaqueteGenerico[][]zonas;
	private int numzonas;
	private int paquetesporzona;
	
	public Zona(int numzonas, int paquetesporzona) {
		this.zonas = new PaqueteGenerico[numzonas][paquetesporzona]; //matriz creada
	    this.numzonas = numzonas;
	    this.paquetesporzona = paquetesporzona;
	}
	public void cargarPaqueteEnMatriz(PaqueteGenerico obj, int fila, int columna){
	    if(fila >= 0 && fila < numzonas && columna >= 0 && columna < paquetesporzona){
	        if(zonas[fila][columna] == null){
	            zonas[fila][columna] = obj;
	            System.out.println("INGRESADO CORRECTAMENTE");
	        } else {
	            System.out.println("POSICION OCUPADA");
	        }
	    } else {
	        System.out.println("POSICION FUERA DE RANGO");
	    }
	}
	public void mostrarmatriz() { //mostrar matriz
		for(int i = 0 ; i < zonas.length ; i++) {
			for(int j = 0 ; j < zonas[i].length ; j++) {
				System.out.print(zonas[i][j]);
			}
			System.out.println();
		}
	}
}
