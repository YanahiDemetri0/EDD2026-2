/**
 * Interfaz que define las funciones principales de un árbol AVL
 * @since 23 de abril 
 */
public interface TDAArbolAVL<T extends Comparable<T>> {

    /**
     * Insertar un elemento en el árbol y lo balancea si es necesario
     * @param dato El elemento a insertar
     */
    public void insertar(T elemento);

    /**
     * Eliminar un elemento del árbol y baleancear después
     * @param dato el elemento a eliminar
     */
    public void eliminar(T elemento);

    /**
     * Busca un elemento en el árbol
     * @param el elemento a buscar
     * @return boolean, true si se encuentra en el árbol, false en caso contrario
     */
    public boolean buscar(T elemento);

    /**
     * Devuelve la altura de un arbol
     * @return int con la altura
     */
    public int altura();   
}