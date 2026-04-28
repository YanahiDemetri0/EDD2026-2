import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class ColaPrioridadHospital<T extends Comparable<T>> implements TDAQueue<T>{
    private PriorityQueue<T> monticulo;

    public ColaPrioridadHospital(){
        this.monticulo = new PriorityQueue<>();
    }

    @Override
    public void agregar(T e){
        monticulo.add(e);
    }

    @Override
    public T eliminar() throws NoSuchElementException{
        if(estaVacia()){
            throw new NoSuchElementException("No hay pacientes en espera");
        }
        return monticulo.poll();
    }

    @Override
    public T primero() throws NoSuchElementException{
        if(estaVacia()){
            throw  new NoSuchElementException("No hay pacientes en espera");
        }
        return monticulo.peek();
    }

    @Override
    public boolean estaVacia(){
        return monticulo.isEmpty();
    }

    @Override
    public int tamaño(){
        return monticulo.size();
    }

    @Override
    public void vaciar(){
        monticulo.clear();
    }

    @Override
    public void mostrar(){
        System.out.println(monticulo);
    }
}