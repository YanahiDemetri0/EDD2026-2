/**
 * Interfaz que define la Coleccion <b>Conjunto</b>.
 * 
 * @author Yanahi Demetrio Torres.
 * @version Febrero 2026.
 */
public interface Conjuntable<T> {

    /**
     * Metodo que permite agregar un elemento al conjunto 
     * siempre que esto sea posible.
     * 
     * @param elem el elemento a agregar
     */
    void agregar(T elem);

    /**
     * Metodo que permite eliminar un elemento del conjunto
     * siempre que esto sea posible.
     * 
     * @param elem el elemento a eliminar
     */
    void eliminar(T elem);

    /**
     * Metodo que permite saber si un elemento se encuentra
     * contenido dentro del conjunto.
     * 
     * @param elem el elemento a buscar.
     * @return boolean true si lo encontro, false en otro caso.
     */
    boolean contiene(T elem);

    /**
     * Metodo que permite saber si un conjunto esta vacio.
     * 
     * @return boolen true si esta vacio, false en otro caso
     */
    boolean estaVacio();

    /**
     * Metodo que permite conocer la cardinalidad de un conjunto.
     * 
     * @return int la cantidad de elementos almacenados
     */
    int cardinalidad();

    /**
     * Metodo que permite unir dos conjuntos.<br>
     * 
     * @param a El conjunto con el que se hara la union
     * @return Conjunto El conjunto resultante de la union
     */
    Conjunto<T> union(Conjunto<T> a);

    /**
     * Metodo que permite intersectar dos conjuntos.
     * 
     * @param a El conjunto con el que se hara la interseccion
     * @return Conjunto El conjunto resultante de la interseccion
     */
    Conjunto<T> interseccion(Conjunto<T> a);

    /**
     * Metodo que permite obtener la diferencia de dos conjuntos.
     * 
     * @param a El conjunto con el que se hara la resta
     * @return Conjunto El conjunto resultante de la resta
     */
    Conjunto<T> resta(Conjunto<T> a);
}