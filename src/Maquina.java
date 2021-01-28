import java.util.Scanner;

/**
 * @author Jaime Díaz Menéndez
 */


public class Maquina {

    /**
     * En esta clase realizamos todos los procesos necesarios para llevar a cabo las funciones de las máquina.
     * Seguimos la siguiente estructura:
     *  - Creación del menú de la máquina
     *  - Comprobaciones
     *  - Switch con los casos de las opciones a escoger y sus correspondientes procesos y métodos a usar
     *  - Menu Administración (el cual sigue la misma estructura que el menú principal)
     */

    Scanner sc = new Scanner(System.in);

    /**
     * Este método consta de varias partes:
     * 1 - Llamada al método de mostrar menú
     * 2 - Llamada al método de elegir opciones
     * 3 - Se encarga de que el Main reciba un boolean en el que indicamos
     * que si pulsamos 0, la maquina debe apagarse.
     *
     * @return menuMaquina (boolean) A la clase Main
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
     * Método en el que se imprimen las opciones del menú
     */
    public void mostrarMenu() {
        System.out.println("\n               MENÚ ");
        System.out.println("=====================================");
        System.out.println("1: Introducir monedas");
        System.out.println("2: Café solo ("+Producto.getPrecioActualSolo()+") (Cantidad: "+Producto.getCantidadSolo()+")");
        System.out.println("3: Descafeinado ("+Producto.getPrecioActualDescafeinado()+") (Cantidad: "+Producto.getCantidadDescafeinado()+")");
        System.out.println("4: Té ("+Producto.getPrecioActualTe()+") (Cantidad: "+Producto.getCantidadTe()+")");
        System.out.println("5: Menú administración");
        System.out.println("6: Devolver Monedas");
        System.out.println("0: Apagar la máquina");
    }

    /**
     * Método que hace las comprobaciones necesarias
     * para que en el menú solo puedas introducir un valor del 0 al 6
     * así como impedir caracteres no númerico..
     *
     * @return opMenu (int asignado a la opción del menú)..
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
            //Si no ha habido ninguna excepción, comprobaremos estas condiciones, sino se saltarán y se repetirá el bucle.
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
     *
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
     * Método en el que una vez hechas las comprobaciones,
     * asignamos a cada caso sus funciones correspondientes
     *
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

    /**
     * Método para crear un café solo
     */
    private void crearSolo() {

        //Asignamos el tipo del producto
        Tipo t = Tipo.SOLO;

        //PASO1(COMPROBAR QUE HAY CAMBIO)
        //PASO2(COMPROBAR QUE HAY DINERO PARA COMPRAR PRODUCTO)
        //PASO3(COMPROBAR STOCK)
        //PASO4(CREAR OBJETO)


        //Si hay stock, podemos crear cafés, sino, no.
        if (Producto.hayStock(t)) {
            //Creamos el objeto del producto enviándole el tipo en concreto (en este caso, un solo)
            Producto p = new Producto(t);
        }else{
            System.out.println("No hay más cafés solos disponibles.");
        }


    }

    /**
     * Método para crear un café descaféinado
     */
    private void crearDescafeinado() {
        Tipo t = Tipo.DESCAFEINADO;

        if (Producto.hayStock(t)) {
            //Creamos el objeto del producto enviándole el tipo en concreto (en este caso, un solo)
            Producto p = new Producto(t);
        }else{
            System.out.println("No hay más cafés descafeinados disponibles.");
        }

    }

    /**
     * Método para crear un té
     */
    private void crearTe() {
        Tipo t = Tipo.TE;
        if (Producto.hayStock(t)) {
            //Creamos el objeto del producto enviándole el tipo en concreto (en este caso, un solo)
            Producto p = new Producto(t);
        }else{
            System.out.println("No hay más te disponibles.");
        }

    }



    private void menuAdmin() {
        boolean saliradmin = false;
        //bucle que repite el programa hasta que le asignemos la opción de salir (0)
        do{
            menuAdministracion();
        }while(!saliradmin);

    }

    /**
     * Este método se encarga de realizar las operaciones necesarias para el menú de Administración.
     * La estructura es la misma que la del menú base de la máquina, cambiando solamente los métodos a los que llamamos.
     * Los comentarios también permanecen para explicar de nuevo los pasos que sigue el programa
     */
    private boolean menuAdministracion(){

        //1. Mostrar las instrucciones del menú
        //2. Introducir la opción
        //3. Comprobaciones
        //4. Asignación/elección de casos

        int opcion;
        boolean salirAdmin = false;

        //1 - Llamada al método que muestra el menú de administración
        mostrarMenuAdmin();

        //2 - Asignación de la opción que se introduzca en el menú
        opcion = introducirOpcionAdmin();

        //3 - Si la opción es 0, la máquina se apaga
        if (opcion == 0) {
            System.out.println("La máquina se apagará. ");
            //Devolvemos true a la clase Main, para terminar el bucle que hay en esta y finalizar el programa
            return true;
        }

        iniciarMenu(opcion);

        return salirAdmin;
    }

    private void mostrarMenuAdmin(){
        System.out.println("\nMENÚ ADMINISTRACIÓN");
        System.out.println("===================");
        System.out.println("1: Mostrar contenido de cajetines");
        System.out.println("2: Modificar precios de los productos");
        System.out.println("3: Mostrar unidades vendidas");
        System.out.println("4: Añadir productos no implementados");
        System.out.println("0: Volver");
    }

    /**
     * Método
     * @return opMenuAdmin a menuAdmin
     */
    private int introducirOpcionAdmin(){
        int opMenuAdmin = 0;
        boolean salirAdmin;
        //System.out.println("Introduce una de las opciones: ");
        do {
            salirAdmin = true;
            try {
                //Asignamos la opción del menú
                opMenuAdmin = sc.nextInt();

            } catch (Exception e) { //Control de excepción
                System.err.println("Has introducido un caracter no númerico.");
                salirAdmin = false; //repetimos el bucle
                sc.nextLine(); //limpiamos buffer
                mostrarMenuAdmin();
            }
            //Si no ha habido ninguna excepción, comprobaremos estas condiciones, sino se saltarán y se repetirá el bucle.
            if (salirAdmin) {
                //Comprobamos si está dentro del rango 0-4
                if (rangoValidoAdmin(opMenuAdmin)) { //llamada al método donde lo comprueba enviándole la opción de Menú (opMenu)
                    //Salimos del bucle
                    salirAdmin = true;
                } else {
                    //Sino está dentro del rango, repetiremos el bucle para introducir otra vez la opción
                    System.out.println("Has introducido un valor fuera del rango.");
                    salirAdmin = false;
                    //Volvemos a mostrar el menú
                    mostrarMenuAdmin();

                }

            }
        } while (!salirAdmin);
        return opMenuAdmin;
    }

    /**
     * Método que comprueba que los valores del menu admín van del 0 al 4
     * @param opMenuAdmin
     * @return rangoValidoAdmin al método introducirOpcionAdmin
     */
    private boolean rangoValidoAdmin(int opMenuAdmin) {
        if (opMenuAdmin >= 0 && opMenuAdmin <= 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método en el que una vez hechas las comprobaciones,
     * asigna a cada caso las funciones del menú Admin
     *
     * @param opMenuAdmin (valor del menú)
     */
    private void iniciarMenuAdmin(int opMenuAdmin) {

        switch (opMenuAdmin) {
            case 0:
                //volver al menu principal
            case 1:
                mostrarContenidoCajetines();
                break;
            case 2:
                modificarPrecio();
                break;
            case 3:
                mostrarVentas();
                break;
            case 4:
                addProducto();
                break;

        }
    }

    public void mostrarContenidoCajetines(){

    }
    public void modificarPrecio(){

    }
    public void mostrarVentas(){

    }
    public void addProducto(){

    }

    private void devolverMonedas() {
        System.out.println("devolverMonedas");
    }







}
