public class Main {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        int[] datos = {10,90,30,4,50,60,70,100};
        for(int dato : datos){
            arbol.agregar(dato);
        }


        System.out.println(arbol.toString());

        System.out.println("Recorrido PreOrden");
        //[50,30,20,40,70,60,80]
        System.out.println(arbol.preOrden());
        System.out.println("Recorrido InOrden");
        //[20,30,40,50,60,70,80]
        System.out.println(arbol.inOrden());
        System.out.println("Recorrido PosOrden");
        //[20,40,30,60,80,70,50]
        System.out.println(arbol.posOrden());
        System.out.println(arbol.bfs());

    }
}