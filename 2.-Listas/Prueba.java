public class Prueba {

    public static void main(String[] args) {

        ListaDoblementeLigada<Integer> lista = new ListaDoblementeLigada<>();

        System.out.println("=== PRUEBA LISTA DOBLEMENTE LIGADA ===");

        // 🔹 1. Agregar elementos
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        System.out.println("Lista después de agregar 10,20,30:");
        imprimir(lista);

        // 🔹 2. Agregar por índice
        lista.agregar(0, 5);   // inicio
        lista.agregar(2, 15);  // medio
        //lista.agregar(lista.size(), 40); // final

        System.out.println("\nDespués de agregar en índice:");
        imprimir(lista);

        // 🔹 3. Obtener por índice
       // System.out.println("\nElemento en índice 2: " + lista.obtener(2));

        // 🔹 4. Contiene
        System.out.println("\n¿Contiene 20? " + lista.contiene(20));
        System.out.println("¿Contiene 99? " + lista.contiene(99));

        // 🔹 5. Eliminar por índice
        lista.eliminar(0); // elimina primero
        System.out.println("\nDespués de eliminar índice 0:");
        imprimir(lista);

        lista.eliminar(2); // elimina en medio
        System.out.println("\nDespués de eliminar índice 2:");
        imprimir(lista);

        // 🔹 6. Eliminar por valor
        lista.eliminar(30);
        System.out.println("\nDespués de eliminar 30:");
        imprimir(lista);

        // 🔹 7. Primer elemento
        System.out.println("\nPrimer elemento: " + lista.primerElemento());
        // 🔹 8. Tamaño
        //System.out.println("\nTamaño actual: " + lista.size());

        // 🔹 9. Vaciar lista
        lista.vacia();
        System.out.println("\nDespués de vaciar:");
        imprimir(lista);
        System.out.println("¿Está vacía? " + lista.estaVacio());
    }

    // 🔹 Método auxiliar para imprimir
    public static <T> void imprimir(ListaDoblementeLigada<T> lista) {
        if (lista.estaVacio()) {
            System.out.println("[ ]");
            return;
        }

        System.out.print("[ ");

        var it = lista.iterador();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("]");
    }
}