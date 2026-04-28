import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de una cola basada en una lista
 * 
 * @version 24 marzo 2026
 */

public class Queue<T> implements TDAQueue<T>{
    private ArrayList<T> lista =  new ArrayList<>();

    @Override
    public void agregar(T e){
        lista.add(lista.size(), e);
    }

    @Override
    public T eliminar() throws NoSuchElementException{
        if(lista.isEmpty()){
            throw new NoSuchElementException();
        }
        return lista.remove(0);
    }

    @Override
    public T primero() throws NoSuchElementException{
        if(lista.isEmpty()){
            throw new NoSuchElementException();
        }
        return lista.get(0);
    }

    @Override
    public boolean estaVacia(){
        return lista.isEmpty();
    }

    @Override
    public int tamaño(){
        return lista.size();
    }

    @Override
    public void vaciar(){
        lista.clear();
    }

    @Override
    public void mostrar(){
        Iterator<T> iterator = lista.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}