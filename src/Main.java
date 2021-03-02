/**
 * 
 * @author Jaime Díaz Menéndez
 *
 */

public class Main {

    /**
     * Programa para realizar la máquina de café.
     * @param args
     */

    public static void main(String[] args) {

        //Objeto que contendrá la estructura del programa.
        Maquina m = new Maquina();
        boolean salir = false;
        //bucle que repite el programa hasta que le asignemos la opción de salir (0)
        do{
            salir=m.menuMaquina();
        }while(!salir);
    }
}
