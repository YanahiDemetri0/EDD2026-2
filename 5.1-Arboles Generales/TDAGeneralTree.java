import java.util.List; 

public interface TDAGeneralTree<T> {

    /**
     * Metodo que devuelve la raiz del arbol
     * @return node del arbol
     */
    public GeneralNode<T> raiz();

    /**
     * Método para agregar un elemento al arbol
     * @param T dato por agregar
     * @param Nodo padre del nuevo elemento
     */
    public void agregar(T dato, GeneralNode<T> padre);

    /**
     * Método que devuelva todos los hijos de un nodo 
     * @return List de nodos
     */
    public List<GeneralNode<T>> hijos(GeneralNode<T> nodo);

    /**
     * Método para saber cuantos nodos hay 
     * @return int tamaño del arbol
     */
    public int tamaño();

    /**
     * Método para saber la altura de un árbol
     * @return int altura del arbol
     */
    public int altura();

    /**
     * Método para saber si un árbo tiene elementos
     * @return boolean True si es vacio, False si tiene uno o más elementos
     */
     public boolean esVacio();

     /**
      * Método para limpiar el árbol
      */
     public void vaciar();


}