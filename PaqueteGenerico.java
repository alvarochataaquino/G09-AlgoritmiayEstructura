package mipaquete;

public class PaqueteGenerico <K>{
	private String codigo;
	private double peso;
	private K priorirdad;
	private int valorizacion;
	private int zona;
	public PaqueteGenerico(String codigo, double peso, K priorirdad, int valorizacion, int zona) {
		this.codigo = codigo;
		this.peso = peso;
		this.priorirdad = priorirdad;
		this.valorizacion = valorizacion;
		this.zona = zona;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public K getPriorirdad() {
		return priorirdad;
	}
	public void setPriorirdad(K priorirdad) {
		this.priorirdad = priorirdad;
	}
	public int getValorizacion() {
		return valorizacion;
	}
	public void setValorizacion(int valorizacion) {
		this.valorizacion = valorizacion;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
}
