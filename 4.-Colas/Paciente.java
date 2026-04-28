public class Paciente implements Comparable<Paciente>{

    private String nombre;
    private int nivelGravedad; //Suponer una escala 1(leve) a 10(critico)

    /**
     * Método constructor
     * 
     * @param String nombre del paciente
     * @param int escala de gravedad
     */
    public Paciente(String nombre, int nivelGravedad){
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getNivelGravedad(){
        return nivelGravedad;
    }
    @Override
    public int compareTo(Paciente otro){
        if(this.nivelGravedad > otro.nivelGravedad){
            return -1; //Indicamos que va antes
        }else if(this.nivelGravedad < otro.nivelGravedad){
            return 1; //Significa que va antes que yo
        }else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return nombre + "(Gravedad: " + nivelGravedad + ")";
    }



}