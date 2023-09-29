package tablashash;
/*import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
*/
public class FuHash {
    static final int tamano = 75;  // Aumenta el tamaño a 75
    private int Elementos;
    private double Carga;
    private Nodo[] tabla;

    public FuHash() {
        tabla = new Nodo[tamano];
        for (int j = 0; j < tamano; j++) {
            tabla[j] = null;
        }
        Elementos = 0;
        Carga = 0.0;
    }

    public int ValorHash(String codig, String nom, int prom) {
        long d = transformaCadena(codig);
        int p = (int) (d % tamano);
        System.out.println("Indice:"+prom +" Codigo:"+codig+ " Nombre:"+nom+" Promedio:"+p);
        while (tabla[p] != null && !tabla[p].getCodigo().equals(codig)) {
            p = (p + 1) % tamano;  // Exploración lineal
            System.out.println("Indice:**"+prom +" Codigo:"+codig+ " Nombre:"+nom+" Promedio:"+p);
        }
        return p;
    }

    long transformaCadena(String c) {
        long d = 0;
        for (int j = 0; j < Math.min(10, c.length()); j++) {
            d = d * 27 + (int) c.charAt(j);
        }
        if (d < 0) {
            d = -d;
        }
        return d;
    }

    public void insertar(Nodo r) {
        int posicion;
        posicion = ValorHash(r.getCodigo(), r.getNombre(), r.getPromedio());
        if (tabla[posicion] != null) {
            System.out.println("Colision en el indice " + posicion);
        }
        tabla[posicion] = r;
        Elementos++;
    }

    public Nodo buscar(String codigo, String nombre, int prom) {
        Nodo pr;
        int posicion;
        posicion = ValorHash(codigo, nombre, prom);
        pr = tabla[posicion];
        return pr;
    }

    public void mostrarTabla() {
        for (int i = 0; i < tamano; i++) {
            if (tabla[i] == null) {
                System.out.println("Indice: " + i + ", Codigo: LIBRE, Nombre: LIBRE, Promedio: LIBRE");
            } else {
                System.out.println("Indice: " + i + ", Codigo: " + tabla[i].getCodigo() + ", Nombre: " + tabla[i].getNombre() + ", Promedio: " + tabla[i].getPromedio());
            }
        }
    }
   /* public void imprimirTablaOrdenada() {
        ArrayList<Nodo> nodos = new ArrayList<>();
        for (int i = 0; i < tamaño; i++) {
            if (tabla[i] != null) {
                nodos.add(tabla[i]); 
            }
        }
        Collections.sort(nodos, new Comparator<Nodo>() {
            public int compare(Nodo nodo1, Nodo nodo2) {
                return nodo1.getCodigo().compareTo(nodo2.getCodigo());
            }
        });

        // Imprimir los nodos en orden
        for (Nodo nodo : nodos) {
            System.out.println("Codigo: " + nodo.getCodigo() + ", Nombre: " + nodo.getNombre() + ", Promedio: " + nodo.getPromedio());
        }
    }
    */
    public void imprimirTablaOrdenada() {
    for (int i = 0; i < tamano; i++) {
        Nodo nodo = tabla[i];
        if (nodo != null) {
            System.out.println("Indice: " + i + ", Codigo: " + nodo.getCodigo() + ", Nombre: " + nodo.getNombre() + ", Promedio: " + nodo.getPromedio());
        }
    }
}
}
