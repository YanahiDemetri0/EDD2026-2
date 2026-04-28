import java.util.ArrayList;
import java.util.Random;

public class Ejemplo2 {

    static final int N = 100000;

    public static void main(String[] args) {

        System.out.println("Probando con " + N + " elementos\n");

        probarArrayList();
        probarListaLigada();
        probarListaDoblementeLigada();
    }

    static void probarArrayList(){

        ArrayList<Integer> lista = new ArrayList<>();
        Random r = new Random();

        long inicio = System.nanoTime();

        // insertar
        for(int i=0;i<N;i++){
            lista.add(r.nextInt(1000));
        }

        // eliminar pares
        lista.removeIf(n -> n % 2 == 0);

        // insertar después de múltiplos de 5
        for(int i=0;i<lista.size();i++){
            if(lista.get(i) % 5 == 0){
                lista.add(i+1,999);
                i++;
            }
        }

        // acceder a muchos elementos
        int suma = 0;
        for(int i=0;i<lista.size();i++){
            suma += lista.get(i);
        }

        long fin = System.nanoTime();

        System.out.println("ArrayList: " + (fin-inicio)/1e6 + " ms");
    }

    static void probarListaLigada(){

        Lista<Integer> lista = new Lista<>();
        Random r = new Random();

        long inicio = System.nanoTime();

        for(int i=0;i<N;i++){
            lista.agregar(r.nextInt(1000));
        }

        // eliminar pares
        for(int i=0;i<1000;i++){
            lista.eliminar(i*2);
        }

        // insertar
        for(int i=0;i<1000;i++){
            lista.agregar(i,999);
        }

        // recorrer lista
        int suma = 0;
        var it = lista.iterador();
        while(it.hasNext()){
            suma += it.next();
        }

        long fin = System.nanoTime();

        System.out.println("Lista simplemente ligada: " + (fin-inicio)/1e6 + " ms");
    }

    static void probarListaDoblementeLigada(){

        ListaDoblementeLigada<Integer> lista = new ListaDoblementeLigada<>();
        Random r = new Random();

        long inicio = System.nanoTime();

        for(int i=0;i<N;i++){
            lista.agregar(r.nextInt(1000));
        }

        // eliminar pares
        for(int i=0;i<1000;i++){
            lista.eliminar(i*2);
        }

        // insertar
        for(int i=0;i<1000;i++){
            lista.agregar(i,999);
        }

        // recorrer
        int suma = 0;
        var it = lista.iterador();

        while(it.hasNext()){
            suma += it.next();
        }

        long fin = System.nanoTime();

        System.out.println("Lista doblemente ligada: " + (fin-inicio)/1e6 + " ms");
    }
    
}