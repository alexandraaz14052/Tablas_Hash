package tablashash;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class TablasHash {

    public static void main(String[] args) {
        Random rand = new Random();
        FuHash t = new FuHash();
        String[] nombres = {"Jose", "Marcos", "Julian", "Pep", "David"};
        System.out.println("DATOS DE ESTUDIANTE");
        try {
            System.out.println("=========================");
            System.out.println("5190-21-352, Jose Mauricio López García, sección: C");
            System.out.println("" + InetAddress.getLocalHost());
            System.out.println("=========================");
            
        } catch (UnknownHostException ex) {
            System.out.println( ex.getMessage() );
        }

        System.out.println("TABLA CON COLISIONES Y COMO SE ARREGLAN");
        System.out.println("=========================");
        for (int i = 12; i < 72; i++) {  // Comienza en 12 y termina en 72 para insertar 60 elementos
            String codigo = "TX-" + String.format("%03d", i) + "Y";
            String nombre = nombres[rand.nextInt(nombres.length)];  // Elige un nombre aleatorio de la lista de nombres
            int promedio = rand.nextInt(101);  // Genera un promedio aleatorio entre 0 y 100
            Nodo nodo = new Nodo(codigo, nombre, promedio);
            t.insertar(nodo);
            System.out.println("Codigo: " + codigo + ", Nombre: " + nombre + ", Promedio: " + promedio);
        }

        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        System.out.println("TABLA HASH CON ESPACIOS LIBRES");
        t.mostrarTabla();
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("TABLA HASH ORDENADA");
        t.imprimirTablaOrdenada();
    }
}


