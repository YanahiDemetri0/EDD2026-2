

public class ArbolAVL<T extends Comparable<T>> implements TDAArbolAVL<T> {

    private class Nodo {
        T dato;
        int altura;
        Nodo izquierdo, derecho;

        public Nodo(T dato){
            this.dato = dato;
            this.altura = 1;
        }
    }

    private Nodo raiz;

    private int altura(Nodo n) {
        return (n == null) ? 0 : n.altura;
    }

    private int getFactorEquilibrio(Nodo n) {
        return (n == null) ? 0 : altura(n.izquierdo) - altura(n.derecho);
    }

    /**
     * Metodo para actualizar la altura de un nodo
     * @param nodo que se modificara su altura.
     */
    private void actualizarAltura(Nodo n) {
        n.altura = 1 + Math.max(altura(n.izquierdo) , altura(n.derecho));
    }

    /**
     * Metodo para rotar un nodo a la derecha
     * @param y nodo que se va a rotar
     * @return nodo que es la nueva raiz local
     */
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        x.derecho = y;
        y.izquierdo =T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    /**
     * Metodo para rotar un vértice a la izquerda
     * @param x vertice que será rotado
     * @return nodo que es la nueva raiz local
     */
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        y.izquierdo = x.derecho;
        x.derecho = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }


    private Nodo balancear(Nodo nodo) {
        actualizarAltura(nodo);
        int b = getFactorEquilibrio(nodo);

        //Caso Izquierda-Izquierda
        if(b > 1 && getFactorEquilibrio(nodo.izquierdo) >=0){
            return rotarDerecha(nodo);
        }

        //Caso Izquierda-Derecha
        if(b > 1 && getFactorEquilibrio(nodo.derecho)<= 0){
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        //Caso Derecha-Derecha
        if(b < -1 && getFactorEquilibrio(nodo.derecho)<= 0){
            return rotarIzquierda(nodo);
        }

        //Caso Derecha-Izquierda
        if(b < -1 & getFactorEquilibrio(nodo.derecho)> 0 ){
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }


    @Override
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo nodo, T dato) {
        if (nodo == null) return new Nodo(dato);

        int comparacion = dato.compareTo(nodo.dato);
        if(comparacion < 0){
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        }else if(comparacion > 0){
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }else{
            return nodo;
        }
       
        return balancear(nodo);
    }


    @Override
    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private Nodo eliminarRecursivo(Nodo nodo, T dato) {
        if(nodo == null) return null;

        int comparacion = dato.compareTo(nodo.dato);

        if(comparacion < 0){
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        }else if(comparacion > 0){
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        }else{
            if(nodo.izquierdo == null || nodo.derecho == null){
                nodo = (nodo.izquierdo != null) ? nodo.izquierdo : nodo.derecho;
            }else{
                Nodo temp =obtenerMinimo(nodo.derecho);
                nodo.dato = temp.dato;
                nodo.derecho = eliminarRecursivo(nodo.derecho, temp.dato);
            }
        }
        if( nodo == null) return null;
        return balancear(nodo);
        
    }

    private Nodo obtenerMinimo(Nodo nodo) {
       while(nodo.izquierdo!=null) nodo = nodo.izquierdo;
       return nodo;

    }

    
    @Override
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz,dato);
    }
    private boolean buscarRecursivo(Nodo actual, T dato){
        if(actual == null){
            return false;
        }

        int comparacion = dato.compareTo(actual.dato);

        if(comparacion == 0){
            return true;
        }

        return comparacion < 0
            ? buscarRecursivo(actual.izquierdo, dato)
            : buscarRecursivo(actual.derecho, dato);
    }

   
    @Override
    public int altura() {
        return altura(raiz);
    }

    @Override
    public String toString() {
        if (raiz == null) return "Árbol vacío";
        return generarToString(raiz, 0);
    }

    private String generarToString(Nodo nodo, int nivel) {
        StringBuilder sb = new StringBuilder();
        
        // Primero procesamos el hijo derecho (aparecerá arriba en la consola)
        if (nodo.derecho != null) {
            sb.append(generarToString(nodo.derecho, nivel + 1));
        }

        // Agregamos sangría según el nivel y el valor del nodo
        sb.append("    ".repeat(nivel))
        .append(nodo.dato)
        .append(" (h:")
        .append(nodo.altura)
        .append(")\n");

        // Luego el hijo izquierdo (aparecerá abajo)
        if (nodo.izquierdo != null) {
            sb.append(generarToString(nodo.izquierdo, nivel + 1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ArbolAVL<Integer> arbol = new ArbolAVL<>();

        System.out.println("--- INSERCIÓN QUE GENERA ROTACIÓN SIMPLE ---");
        // Insertar 10, 20, 30 causará una rotación simple a la izquierda en el 10
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        System.out.println(arbol);

        System.out.println("--- INSERCIÓN QUE GENERA ROTACIÓN DOBLE ---");
        // Insertar 5 y luego 8 causará un desbalance en el 10 (hijo izquierdo del 20)
        // El 8 forzará una rotación doble (Derecha-Izquierda o Izquierda-Derecha según el caso)
        arbol.insertar(5);
        arbol.insertar(8); 
        System.out.println(arbol);

        System.out.println("--- BUSCANDO ELEMENTOS ---");
        System.out.println("¿Existe el 20?: " + arbol.buscar(20));
        System.out.println("¿Existe el 100?: " + arbol.buscar(100));

        System.out.println("\n--- ELIMINACIÓN Y RE-BALANCEO ---");
        System.out.println("Eliminando la raíz (20)...");
        arbol.eliminar(20);
        System.out.println(arbol);
    }
}
