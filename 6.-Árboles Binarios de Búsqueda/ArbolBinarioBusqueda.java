public class ArbolBinarioBusqueda<T extends Comparable<T>> implements TDAArbolBinario<T> {
    
    private class Vertice implements VerticeArbolBinario<T> {
        public T elemento;
        public Vertice padre, izquierdo, derecho;

        public Vertice(T elemento, Vertice padre) {
            this.elemento = elemento;
            this.padre = padre;
        }

        @Override
        public boolean hayPadre() {
            return padre != null;
        }

        @Override
        public boolean hayIzquierdo() {
            return izquierdo != null;
        }

        @Override
        public boolean hayDerecho() {
            return derecho != null;
        }

        @Override
        public VerticeArbolBinario<T> padre() {
            return padre;
        }

        @Override
        public VerticeArbolBinario<T> izquierdo() {
            return izquierdo;
        }

        @Override
        public VerticeArbolBinario<T> derecho() {
            return derecho;
        }

        @Override
        public T get() {
            return elemento;
        }

        @Override
        public int altura() {
            return 1 + Math.max(
                izquierdo == null ? -1 : izquierdo.altura(),
                derecho == null ? -1 : derecho.altura()
            );
        }

        @Override
        public int profundidad() {
            return padre == null ? 0 : 1 + padre.profundidad();
        }
    }

    private Vertice raiz;

    @Override
    public void agregar(T elemento) {
        if (raiz == null) {
            raiz = new Vertice(elemento, null);
        } else {
            agregar(raiz, elemento);
        }
    }

    private void agregar(Vertice actual, T elemento) {
        if (elemento.compareTo(actual.elemento) < 0) {
            if (actual.izquierdo == null) actual.izquierdo = new Vertice(elemento, actual);
            else agregar(actual.izquierdo, elemento);
        } else {
            if (actual.derecho == null) actual.derecho = new Vertice(elemento, actual);
            else agregar(actual.derecho, elemento);
        }
    }

    @Override
    public VerticeArbolBinario<T> raiz() {
        return raiz;
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public void limpiar() {
        raiz = null;
    }

    @Override
    public int altura() {
        return raiz == null ? -1 : raiz.altura();
    }

    @Override
    public int profundidad() {
        // Nota: La profundidad del árbol es igual a su altura.
        return raiz == null ? -1 : raiz.altura();
    }

    public VerticeArbolBinario<T> buscar(T elemento) {
        return buscar(raiz, elemento);
    }

    private Vertice buscar(Vertice actual, T elemento) {
        if (actual == null || actual.elemento.equals(elemento)) return actual;
        if (elemento.compareTo(actual.elemento) < 0) return buscar(actual.izquierdo, elemento);
        return buscar(actual.derecho, elemento);
    }

    @Override
    public void eliminar(T elemento) {
        raiz = eliminar(raiz, elemento);
    }

    private Vertice eliminar(Vertice actual, T elemento) {
        if (actual == null) return null;
        int cmp = elemento.compareTo(actual.elemento);
        if (cmp < 0) actual.izquierdo = eliminar(actual.izquierdo, elemento);
        else if (cmp > 0) actual.derecho = eliminar(actual.derecho, elemento);
        else {
            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null) return actual.izquierdo;
            Vertice temp = actual.derecho;
            while (temp.izquierdo != null) temp = temp.izquierdo;
            actual.elemento = temp.elemento;
            actual.derecho = eliminar(actual.derecho, temp.elemento);
        }
        return actual;
    }

    @Override
    public String toString(){
        if(raiz == null) return "Árbol vacío";
        StringBuilder sb = new StringBuilder();
        imprimirArbol(raiz, 0, sb);
        return sb.toString();
    }

    private void imprimirArbol(Vertice v, int nivel, StringBuilder sb){
        if(v == null) return;
        imprimirArbol(v.derecho, nivel + 1, sb);

        sb.append("\n");
        for(int i =0; i< nivel; i++){
            sb.append("        ");
        }
        sb.append("|-").append(v.elemento);   
        
        imprimirArbol(v.izquierdo, nivel + 1, sb);
    }

    /**
     * Recorrido PreOrden: Raiz, Izquierda, Derecha
     * @return String con los vértices en el orden del recorrido
     */
    public String preOrden(){
        return preOrden(raiz).trim();
    }
    private String preOrden(Vertice v){
        if( v == null) return "";
        return v.elemento + " " + preOrden(v.izquierdo) + preOrden(v.derecho);
    }

    /**
     * Recorrido InOrden: Izquierdo, Raiz, Derecho
     * @return String del recorrido
     */
    public String inOrden(){
        return inOrden(raiz).trim();
    }

    private String inOrden(Vertice v){
        if(v == null) return "";
        return inOrden(v.izquierdo) + v.elemento + " " + inOrden(v.derecho);
    }

    /**
     * Recorrido PosOrden: Izquierdo, Derecho, Raiz
     * @return String del recorrido
     */
    public String posOrden(){
        return posOrden(raiz).trim();
    }

    private String posOrden(Vertice v){
        if(v== null) return "";
        return posOrden(v.izquierdo) + posOrden(v.derecho) + v.elemento + " ";
    }


    
}