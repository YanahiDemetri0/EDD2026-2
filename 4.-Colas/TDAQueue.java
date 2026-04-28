import java.util.NoSuchElementException;

/**
 * INTERFAZ PARA MANEJAR QUEUE
 */
public interface TDAQueue<T>{
    /**
     * Método para agregar un nuevo elemento al final de la cola
     * 
     * @param e el elemento a agregar
     */
    public void agregar(T e);

    /**
     * Método para eliminar el primer elemento de la cola
     * 
     * @return el elemento
     * @throws NoSuchElementException si la cola esta vacía
     */
    public T eliminar() throws NoSuchElementException;

    /**
     * Método devuelve el elemento siguiente (primero) en la cola sin eliminarlo
     * 
     * @return el siguiente elemento en la cola
     * @throws NoSuchElementException si la cola esta vacía
     */
    public T primero() throws NoSuchElementException;

    /**
     * Verifica si la cola esta vacía
     * 
     * @return true si la cola no tiene elementos
     */
    public boolean estaVacia();

    /**
     * Devuelve el número de elementos en la cola
     * 
     * @return int tamaño
     */
    public int tamaño();


    /**
     * Método para eliminar todos los elementos.
     * 
     */
    public void vaciar();


    public void mostrar();

}