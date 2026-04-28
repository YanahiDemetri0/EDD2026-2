public class TestStack{
    public static void main(String[] args) {
        TDAStack<String> pila = new Stack<>();
        pila.push("Buho");
        pila.push("Pinguino");
        pila.push("Perro");
        pila.push("Oso");

        pila.show();

        System.out.println("El tope es: " + pila.top());

        pila.pop();

        System.out.println(" - - -- - - ");
        pila.show();

        pila.clear();
        System.out.println(" - - -- - - ");
        pila.show();

    }
}