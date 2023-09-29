package tablashash;

public class Nodo {
    private String cod;
    private String nomb;
    private int prom;

    public Nodo(String cod, String nomb, int prom) {
        this.cod = cod;
        this.nomb = nomb;
        this.prom = prom;
    }

    public String getCodigo() {
        return cod;
    }

    public String getNombre() {
        return nomb;
    }

    public int getPromedio() {
        return prom;
    }
}
