import java.util.NoSuchElementException;

public class TestQueue {

    public static void main(String[] args) {
        TDAQueue<String> queue = new Queue<>();
        try {
            System.out.println("EL tope es " + queue.primero());
        } catch (NoSuchElementException e) {
            System.out.println("La cola esta vacia");
        }

        queue.agregar("Marco");
        queue.agregar("Antonio");
        queue.agregar("Miguel");
        queue.agregar("Danhe");
        queue.agregar("David");
        queue.agregar("Santiago");

        queue.mostrar();

        queue.eliminar();

        System.out.println("El tope es " +  queue.primero());
        System.out.println("---------------");

        queue.mostrar();


        queue.agregar("Oscar");
        queue.agregar("Carlos");
        queue.agregar("Luis");
        System.out.println("---------------");
        queue.mostrar();
        System.out.println("---------------");
        queue.vaciar();
        queue.mostrar();
    }
}