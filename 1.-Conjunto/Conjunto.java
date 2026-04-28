/**
 * Clase que modela la Coleccion Conjunto
 * La clase implementa la interfaz Conjuntable para mostrar la utilizacion de un
 * TAD.
 * 
 * @author Yanahi Demetrio Torres
 * @version Febrero de 2026.
 */
public class Conjunto<T> implements Conjuntable<T> {
    
    //Atributos.
    private Object datos[]; // Arreglo de los elementos.
    private int ne; // Los números de elementos del Conjunto.

    /**
     * Constructor por omision.
     * Crear un conjunto para 20 elementos.
     */
    public Conjunto() {
        datos = new Object[20];
        ne = 0;
        
    }

    /**
     * Constructor por parametros.
     * Constructor que permite definir un tamaño particular para el Conjunto.
     * 
     * @param tam El tamaño definido por el usuario.
     */
    public Conjunto(int tam) {
        try {
            datos = new Object[tam];
            ne = 0;
        } catch (Exception e) {
            System.out.println("El tamaño debe ser mayor a 1");
        } 
    }

    /**
     * Método que permite agregar un elemento al conjunto siempre que esto sea
     * posible.
     * 
     * @param e El elemento a agregar.
     */
    public void agregar(T e) {
        try {
            if(!contiene(e)){
                datos[ne] = e;
                ne++;
            }else{
                System.out.println("Este elemento ya esta en el Conjunto");
            }
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("No es posible agregar más elementos");

        }
    }

    /**
     * Método que permite eliminar un elemento del conjunto siempre que esto sea
     * posible.<br>
     * 
     * @param e El elemento a eliminar.
     */
    public void eliminar(T e) {
        if(!estaVacio() && contiene(e)){
            for(int i = 0; i< ne; i++){
                if(datos[i].equals(e)){
                    datos[i] = null; 
                    ne--;
                }
                break;
            }
        }else{
            System.out.println(" No esta en el conjunto");
        }
    }

    /**
     * Método que permite saber si un elemento se encuetra contenido dentro del
     * Conjunto.
     * 
     * @param e El elemento a buscar
     * @return boolean true si lo encontro, false en otro caso
     */
    public boolean contiene(T e) {
        for(int i = 0; i < ne; i++){
            if(datos[i].equals(e)){
                return true;
            }
        }
        return false;        
    }

    /**
     * Método que permite saber si un conjunto esta vacio.
     * 
     * @return boolen true si esta vacio, false en otro caso
     */
    public boolean estaVacio() {
        return ne == 0;
    }

    /**
     * Método que permite conocer la cardinalidad de un conjunto.<br>
     * 
     * @return int la cantidad de elementos almacenados
     */
    public int cardinalidad() {
        return ne;
    }

    /**
     * Método que permite unir dos conjuntos.<br>
     * 
     * @param b El conjunto con el que se hará la unión.
     * @return Conjunto El conjunto resultante de la unión.
     */
    public Conjunto<T> union(Conjunto<T> b) {
        Conjunto<T> conjuntoUnion = new Conjunto<>(cardinalidad() + b.cardinalidad());
        for( int i =0; i< ne; i++){
            T obj = (T) datos[i];
            conjuntoUnion.agregar(obj);
        }
        for (int i = 0; i < b.ne; i++) {
            T obj = (T) b.datos[i];
            if(!conjuntoUnion.contiene(obj)){
                conjuntoUnion.agregar(obj);
            }
        }
        return conjuntoUnion;
       
    }

    
    /*****
     * Métodos definidos en Conjunto, que no pertenecen a la Interfaz Conjuntable.
     *****/

    /**
     * Método que permite devolver un conjunto como una cadena de caracteres
     * 
     * @return String el Conjunto en formato String
     */
    public String toString() {
        String conjunto = "El conjunto tiene: ";
        for (int i = 0; i< ne; i++){
            conjunto += datos[i] + ", ";
        }
        return conjunto;
    }
}