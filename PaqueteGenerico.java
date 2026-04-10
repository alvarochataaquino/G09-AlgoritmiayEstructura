package Trabajo1;

class PaqueteGenerico<K extends Comparable<K>> {
    private String codigo;
    private double peso;
    private K prioridad;
    private int valorizacion;
    private int zona;

    public PaqueteGenerico(String codigo, double peso, K prioridad, int valorizacion, int zona) {
        this.codigo = codigo;
        this.peso = peso;
        this.prioridad = prioridad;
        this.valorizacion = valorizacion;
        this.zona = zona;
    }

    public String getCodigo() { return codigo; }
    public double getPeso() { return peso; }
    public K getPrioridad() { return prioridad; }
    public int getValorizacion() { return valorizacion; }
    public int getZona() { return zona; }

    @Override
    public String toString() {
        return String.format("[%s|P:%s|V:%d|W:%.1f]", codigo, prioridad, valorizacion, peso);
    }
}