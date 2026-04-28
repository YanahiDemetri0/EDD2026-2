import java.util.Scanner;


/**
 * Representación del comportamientode un restaurante
 * para la asignación de mesa a los comensales
 * 
 * @version 24 marzo de 20226
 * @since EDD 2026-2
 */
public class Restaurante {
    
    /**
     * cliente
     */
    public class Cliente{
        public String nombre;
        public int cantidad;

        public Cliente(String nombre, int cantidad){
            this.nombre = nombre;
            this.cantidad = cantidad; 
        }
    }


    /**
     * Mesa del restaurante
     */
    public class Mesa{
        public int capacidad;

        public Mesa(int capacidad){
            this.capacidad = capacidad;
        }
    }

    public Mesa[] mesas;
    public TDAQueue<Cliente> clientes; 

    public Restaurante(){
        Scanner sc = new Scanner(System.in);

        System.err.println("¿Cuantas mesas quieres en el restaurante?");
        int cantidadMesas = sc.nextInt();
        mesas = new Mesa[cantidadMesas];

        for(int i = 0; i< cantidadMesas; i++){
            System.err.print("'Cual es a capacidad de la mesa " + i +"?");
            int capacidadActual = sc.nextInt();
            mesas[i] = new Mesa(capacidadActual);
        }


        System.err.println("¿Cuantos clientes quieres en el restaurante?");
        clientes = new Queue<>();
        int cantidadClientes = sc.nextInt();
        
        for(int j = 0; j< cantidadMesas; j++){
            System.err.print("'Cual es la canatidad de comensales totales del cliente" + j +"?");
            int comensalActual = sc.nextInt();
            Cliente nuevoCliente = new Cliente(""+j, comensalActual);
            clientes.agregar(nuevoCliente);

        }
    }


    public void atenderClientes(){
    
        while(!clientes.estaVacia()){
            Cliente actual =clientes.eliminar();
            int minimo  = 100;
            int mesaAsignada = -1;

            for(int i = 0; i< mesas.length; i++){
                if(actual.cantidad == mesas[i].capacidad){
                    mesaAsignada= i;
                    break;
                }

                int diferencia = mesas[i].capacidad - actual.cantidad;
                if(diferencia>0 && diferencia < minimo){
                    minimo = diferencia;
                    mesaAsignada = i;
                }
            }

            if(mesaAsignada == -1){
                System.out.println("El cliente " + actual.nombre+ "no pudo ser atendido");
            }else{
                System.out.println("El cliente" + actual.nombre +"fue asignado a la mesa " + mesaAsignada);
            }
        }  

    }

    public static void main(String[] args) {
        Restaurante toks = new Restaurante();
        toks.atenderClientes();
    }
}
