import static java.lang.System.*;
import java.util.Scanner;

/**
 * Clase que permite probar la Coleccion <b>Conjunto</b>.
 * 
 * @author Rodrigo Alejandro Sánchez Morales.
 * @version Febrero de 2022.
 */
public class PruebaConjunto {

    /**
     * Menu de la aplicacion
     */
    public static void menu() {
        out.println("1. Crear un conjunto");
        out.println("2. Agregar un elemento al conjunto");
        out.println("3. Eliminar un elemento del conjunto");
        out.println("4. Buscar un elemento en el conjunto");
        out.println("5. Crear un segundo conjunto");
        out.println("6. Union de conjuntos");
        out.println("7. Interseccion de conjuntos");
        out.println("8. Diferencia de conjuntos");
        out.println("9. Mostrar alguno de los conjuntos");
        out.println("10. Salir");
        out.print("\nElige una opcion: ");
    }// Fin menu()

    /**
     * Metodo que prueba toda la funcionalidad de la clase Conjunto
     * 
     * @param args Arreglo de tipo String, no se usa en esta implementaci�n
     */
    public static void main(String[] args) {
        Conjunto<Integer> a, b, c;
        Scanner lector = new Scanner(in);
        int tam, opcion, op, elem;
        char resp, imprime;
        a = b = c = null;
        do {
            menu(); // invocamos el menu principal
            opcion = lector.nextInt();
            switch (opcion) {
                case 1: // Crear Conjunto.
                    do {
                        out.println("1. Tamaño estandar.");
                        out.println("2. Definido por el usuario.");
                        out.println("3. Salir.");
                        out.print("\nElige una opcion: ");
                        op = lector.nextInt();
                        switch (op) {
                            case 1: // Omisión.
                                a = new Conjunto<>();
                                break;
                            case 2: // Por parametros
                                try {
                                    out.println("Dame el tamaño del conjunto:");
                                    tam = lector.nextInt();
                                    a = new Conjunto<>(tam);
                                } catch (java.util.InputMismatchException ime) {
                                    err.println("El valor debe entero!\n");
                                    lector.next();
                                }
                                break;
                            case 3:
                                out.println("Regresando al menu principal...");
                                break;
                            default:
                                out.println("Opción no valida.");
                        }// fin switch case 1
                    } while (op != 3); // fin do-while case 1
                    break;
                case 2: // Agregar elementos
                    try {
                        char r;
                        do {
                            out.print("Dame el elemento a agregar: ");
                            elem = lector.nextInt();
                            a.agregar(elem);
                            out.print("�Deseas seguir agregando? (s/n):");
                            r = lector.next().toLowerCase().charAt(0);
                        } while (r == 's');
                    } catch (NullPointerException npe) {
                        err.println("Debes crear primero un conjunto!\n");
                    }
                    break;
                case 3: // Eliminar elementos
                    try {
                        out.print("Dame el elemento a eliminar: ");
                        elem = lector.nextInt();
                        a.eliminar(elem);
                    } catch (NullPointerException npe) {
                        err.println("Debes crear primero un conjunto!\n");
                    }
                    break;
                case 4: // Buscar elementos
                    out.print("Dame el elemento a buscar: ");
                    elem = lector.nextInt();
                    if (a.contiene(elem))
                        out.println("El elemento " + elem + " esta contenido!");
                    else
                        out.println("El elemento " + elem + " no esta contenido!");
                    break;

                case 5: // Crear un segundo conjunto
                    try {
                        out.println("Dame el tama�o del conjunto:");
                        tam = lector.nextInt();
                        b = new Conjunto<>(tam);
                        out.println("Ahora agrega los elementos del conjunto...");
                        do {
                            out.print("Dame el elemento a agregar: ");
                            elem = lector.nextInt();
                            b.agregar(elem);
                            out.println("Deseas agregar otro elemento?(s/n)");
                            resp = lector.next().toLowerCase().charAt(0);
                        } while (resp != 'n');
                    } catch (java.util.InputMismatchException ime) {
                        err.println("El valor debe entero!\n");
                        lector.next();
                    }
                    break;

                case 6: // Unir conjuntos
                    c = null;
                    try {
                        out.println("La union de los conjuntos es:");
                        c = a.union(b);
                        out.println(c);
                    } catch (NullPointerException npe) {
                        err.println("Debes tener dos conjuntos creados!\n");
                    }
                    break;

                case 7: // Intersectar conjuntos
                    c = null;
                    try {
                        out.println("La interseccion de los conjuntos es:");
                        c = a.interseccion(b);
                        out.println(c);
                    } catch (NullPointerException npe) {
                        err.println("Debes tener dos conjuntos creados!\n");
                    }
                    break;

                case 8: // Diferencia de conjuntos
                    c = null;
                    try {
                        out.println("La diferencia de los conjuntos es:");
                        c = a.resta(b);
                        out.println(c);
                    } catch (NullPointerException npe) {
                        err.println("Debes tener dos conjuntos creados!\n");
                    }
                    break;

                case 9: // Imrprimir alguno de los conjuntos
                    try {
                        out.println("Indica el conjunto que deseas imprimir (a,b,c):");
                        imprime = lector.next().toLowerCase().charAt(0);
                        switch (imprime) {
                            case 'a':
                                if (a == null)
                                    out.println("El conjunto a�n no ha sido creado\n");
                                else
                                    out.println(a);
                                break;
                            case 'b':
                                if (b == null)
                                    out.println("El conjunto a�n no ha sido creado\n");
                                else
                                    out.println(b);
                                break;
                            case 'c':
                                if (c == null)
                                    out.println("El conjunto a�n no ha sido creado\n");
                                else
                                    out.println(c);
                                break;
                            default:
                                out.println("Conjunto no v�lido!");
                        }
                    } catch (NullPointerException npe) {
                        err.println("Debes tener dos conjuntos creados!\n");
                    }
                    break;

                case 10: // Salir
                    out.println("Hasta luego");
                    break;

                default:
                    out.println("Opcion no valida!");
            }// Fin switch
        } while (opcion != 10); // fin do-while
    }// Fin main
}// Fin PruebaConjuntos