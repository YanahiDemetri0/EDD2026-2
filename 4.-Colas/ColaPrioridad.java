import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementación de una Cola de Prioridad usando un Montículo Binario (Max-Heap)
 * sobre un ArrayList.
 */
public class ColaPrioridad<T extends Comparable<T>> implements TDAQueue<T> {
    
    // Usaremos un ArrayList como nuestro "árbol aplanado"
    private ArrayList<T> heap;

    public ColaPrioridad() {
        heap = new ArrayList<>();
    }

    // ==========================================
    // MÉTODOS DE LA INTERFAZ TDAQueue
    // ==========================================

    @Override
    public void agregar(T e) {
        heap.add(e); // 1. Lo agregamos al final (como la última hoja)
        flotar(heap.size() - 1); // 2. Lo hacemos flotar hasta su posición correcta
    }

    @Override
    public T eliminar() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }

        T elementoAtendido = heap.get(0); // Guardamos la raíz (el de mayor prioridad)
        T ultimoElemento = heap.remove(heap.size() - 1); // Sacamos al último elemento del arreglo

        // Si la cola no quedó vacía tras sacar al último, lo ponemos en la raíz y lo hundimos
        if (!estaVacia()) {
            heap.set(0, ultimoElemento); 
            hundir(0); 
        }

        return elementoAtendido;
    }

    @Override
    public T primero() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }
        return heap.get(0); // La raíz siempre es el elemento de mayor prioridad
    }

    @Override
    public boolean estaVacia() {
        return heap.isEmpty();
    }

    @Override
    public int tamaño() {
        return heap.size();
    }

    @Override
    public void vaciar() {
        heap.clear();
    }

    @Override
    public void mostrar() {
        // Muestra los elementos en el orden en que están guardados en el arreglo (por niveles del árbol)
        System.out.println(heap);
    }

    // ==========================================
    // MÉTODOS INTERNOS (MAGIA DEL HEAP)
    // ==========================================

    // Fórmulas matemáticas para encontrar a los familiares en el arreglo
    private int indicePadre(int i) { return (i - 1) / 2; }
    private int indiceHijoIzq(int i) { return (2 * i) + 1; }
    private int indiceHijoDer(int i) { return (2 * i) + 2; }

    /**
     * Intercambia dos elementos de posición dentro del ArrayList.
     */
    private void intercambiar(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Sube un elemento si su prioridad es mayor que la de su padre (Sift-Up).
     */
    private void flotar(int indice) {
        // Mientras no lleguemos a la raíz, y el elemento sea MAYOR que su padre
        while (indice > 0 && heap.get(indice).compareTo(heap.get(indicePadre(indice))) > 0) {
            intercambiar(indice, indicePadre(indice));
            indice = indicePadre(indice); // Actualizamos el índice para seguir evaluando
        }
    }

    /**
     * Baja un elemento si su prioridad es menor que la de sus hijos (Sift-Down).
     */
    private void hundir(int indice) {
        int tamaño = heap.size();
        
        while (true) {
            int izq = indiceHijoIzq(indice);
            int der = indiceHijoDer(indice);
            int mayor = indice; // Asumimos inicialmente que el padre es el mayor

            // Comparamos con el hijo izquierdo
            if (izq < tamaño && heap.get(izq).compareTo(heap.get(mayor)) > 0) {
                mayor = izq;
            }
            // Comparamos con el hijo derecho
            if (der < tamaño && heap.get(der).compareTo(heap.get(mayor)) > 0) {
                mayor = der;
            }

            // Si el padre sigue siendo el mayor de los tres, el árbol está ordenado
            if (mayor == indice) {
                break;
            }

            // Si uno de los hijos era mayor, intercambiamos y repetimos el proceso
            intercambiar(indice, mayor);
            indice = mayor;
        }
    }
}