import java.util.Scanner;


public class Maquina {


    Scanner sc = new Scanner(System.in);

    /**
     * Este método consta de varias partes:
     * 1 - Llamada al método de mostrar menú
     * 2 - Llamada al método de elegir opciones
     * 3 - Se encarga de que el Main reciba un boolean en el que indicamos
     *     que si pulsamos 0, la maquina debe apagarse.
     * @return menuMaquina
     */
    public boolean menuMaquina() {

        //1. Mostrar las instrucciones del menú
        //2. Introducir la opción
        //3. Comprobaciones
        //4. Asignación/elección de casos

        int opcion;
        boolean salir = false;

        //1 - Llamada al método que muestra el menú
        mostrarMenu();

        //2 - Asignación de la opción que se introduzca en el menú
        opcion = introducirOpcionMenu();

        //3 - Si la opción es 0, la máquina se apaga
        if (opcion == 0) {
            System.out.println("La máquina se apagará. ");
            //Devolvemos true a la clase Main, para terminar el bucle que hay en esta y finalizar el programa
            return true;
        }

        iniciarMenu(opcion);

        return salir;
    }


    /**
     * Método en el que una vez hechas las comprobaciones,
     * asignamos a cada caso sus funciones correspondientes
     * @param opcion (valor del menú)
     */
    private void iniciarMenu(int opcion) {

        switch (opcion) {
            case 1:
                introducirMonedas();
                break;
            case 2:
                crearSolo();
                break;
            case 3:
                crearDescafeinado();
                break;
            case 4:
                crearTe();
                break;
            case 5:
                menuAdmin();
                break;
            case 6:
                devolverMonedas();
                break;

        }
    }

    private void introducirMonedas() {
        System.out.println("introducirMonedas");
    }

    private void crearSolo() {
        System.out.println("crearSolo");
    }

    private void crearDescafeinado() {
        System.out.println("crearDescafeinado");
    }

    private void crearTe() {
        System.out.println("crearTe");
    }

    private void menuAdmin() {
        System.out.println("menuAdmin");
    }

    private void devolverMonedas() {
        System.out.println("devolverMonedas");
    }

    /**
     * Método que hace las comprobaciones necesarias
     * para que en el menú solo puedas introducir un valor del 0 al 6
     * así como impedir caracteres no númerico..
     * @return opMenu (int asignado a la opción del menú)
     */
    private int introducirOpcionMenu() {

        int opMenu = 0;
        boolean salir;
        //System.out.println("Introduce una de las opciones: ");
        do {
            salir = true;
            try {
                //Asignamos la opción del menú
                opMenu = sc.nextInt();

            } catch (Exception e) { //Control de excepción
                System.err.println("Has introducido un caracter no númerico.");
                salir = false; //repetimos el bucle
                sc.nextLine(); //limpiamos buffer
            }
            //Si no ha habido ninguna excepción, comprobaremos estas condiciones, si no se saltarán y repetimos el bucle.
            if (salir) {
                //Comprobamos si está dentro del rango 0-6
                if (rangoValido(opMenu)) { //llamada al método donde lo comprueba enviándole la opción de Menú (opMenu)
                    //Salimos del bucle
                    salir = true;
                } else {
                    //Sino está dentro del rango, repetiremos el bucle para introducir otra vez la opción
                    System.out.println("Has introducido un valor fuera del rango.");
                    salir = false;
                    //Volvemos a mostrar el menú
                    mostrarMenu();

                }

            }
        } while (!salir);
        return opMenu;
    }

    /**
     * Método que comprueba que la opción introducida está entre 1 y 6
     * @param opMenu (valor que introducimos en el menu)
     * @return rangoValido
     */
    private boolean rangoValido(int opMenu) {
        if (opMenu >= 0 && opMenu <= 6) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método en el que se imprimen las opciones del menú
     */
    public void mostrarMenu() {
        //Realiz
        System.out.println("\n MENÚ ");
        System.out.println("======");
        System.out.println("1: Introducir monedas");
        System.out.println("2: Café solo");
        System.out.println("3: Descafeinado");
        System.out.println("4: Té");
        System.out.println("5: Menú administración");
        System.out.println("6: Cancelar operación");
        System.out.println("0: Apagar la máquina");
    }
}
