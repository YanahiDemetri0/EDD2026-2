import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaLigada<T> implements Listable<T> {

    // 🔹 Clase interna Nodo
    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    // Constructor
    public ListaLigada() {
        cabeza = null;
    }

    // 🔹 Agregar al final
    @Override
    public void agregar(T elem) {
        Nodo nuevo = new Nodo(elem);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // 🔹 Buscar elemento
    @Override
    public boolean contiene(T elem) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(elem)) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    // 🔹 Verificar si está vacía
    @Override
    public boolean estaVacio() {
        return cabeza == null;
    }

    // 🔹 Vaciar lista
    @Override
    public void vacia() {
        cabeza = null;
    }

    // 🔹 Obtener primer elemento
    @Override
    public T primerElemento() {
        if (cabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }
        return cabeza.dato;
    }

    public void bubbleSort() {
        if (cabeza == null || cabeza.siguiente == null) {
            return; // lista vacía o de un solo elemento
        }
        
        boolean intercambio;

        do {
            intercambio = false;
            Nodo actual = cabeza;

            while (actual.siguiente != null) {

                Comparable<T> a = (Comparable<T>) actual.dato;
                T b = actual.siguiente.dato;

                if (a.compareTo(b) > 0) {
                    // intercambiar datos
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;

                    intercambio = true;
                }

                actual = actual.siguiente;
            }

        } while (intercambio);
    }

   
    // 🔹 Eliminar elemento
    @Override
    public void eliminar(T elem) {
        if (cabeza == null) return;

        // Caso especial: eliminar cabeza
        if (cabeza.dato.equals(elem)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(elem)) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }

    public void agregar(int indice, T elem) {
    if (indice < 0) {
        throw new IndexOutOfBoundsException("Índice negativo");
    }

    Nodo nuevo = new Nodo(elem);

    // 🔹 Insertar al inicio
    if (indice == 0) {
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        return;
    }

    Nodo actual = cabeza;
    int contador = 0;

    // Llegar al nodo anterior al índice
    while (actual != null && contador < indice - 1) {
        actual = actual.siguiente;
        contador++;
    }

    // 🔹 Índice fuera de rango
    if (actual == null) {
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    // 🔹 Insertar
    nuevo.siguiente = actual.siguiente;
    actual.siguiente = nuevo;
}

    // 🔹 Iterador
    @Override
    public Iterator<T> iterador() {
        return new Iterator<T>() {

            private Nodo actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }
}
