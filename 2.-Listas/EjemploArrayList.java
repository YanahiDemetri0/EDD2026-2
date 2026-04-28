import java.util.*;
public class EjemploArrayList{

    public static void main(String[] args) {
       
        Lista<Integer> lista = new Lista<>();

        lista.agregar(5);
        lista.agregar(2);
        lista.agregar(8);
        lista.agregar(1);

        lista.bubbleSort();

        Iterator<Integer> it = lista.iterador();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}