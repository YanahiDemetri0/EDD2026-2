

public class Hospital{
    public static void main(String[] args) {
        TDAQueue<Paciente> urgencias = new ColaPrioridadHospital<>();

        urgencias.agregar(new Paciente("Juan (Resfriado)" ,2 ));
        urgencias.agregar(new Paciente("Miguel (Dolor de estomago)" ,4 ));
        urgencias.agregar(new Paciente("Brenda (Infarto)" ,10 ));
        urgencias.agregar(new Paciente("Mariana (Fracturo el brazo)" ,6 ));
        urgencias.agregar(new Paciente("Donají (Ataque de asma)" ,8 ));

        System.out.println("\n Pacientes en espera: "+ urgencias.tamaño());
        System.out.println("\n El siguiente en ser atendido: " + urgencias.primero());

        while (!urgencias.estaVacia()) {
            Paciente atendido = urgencias.eliminar();
            System.out.println("Atendiendo a: " + atendido);
        }
    }
}