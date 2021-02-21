import java.util.Scanner;

/**
 * @author Jaime Diaz Menendez
 */


public class Maquina {

    /**
     * En esta clase realizamos todos los procesos necesarios para llevar a cabo las funciones de las máquina.
     * Seguimos la siguiente estructura:
     * - Creacion del menú de la maquina
     * - Comprobaciones
     * - Switch con los casos de las opciones a escoger y sus correspondientes procesos y metodos a usar
     * - Menu Administración (el cual sigue la misma estructura que el menú principal)
     */

    Scanner sc = new Scanner(System.in);
    String insertarDinero = "No hay suficiente dinero para comprar el producto";

    /**
     * Este metodo consta de varias partes:
     * 1 - Llamada al método de mostrar menu
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

        //mostrar si falta alguna moneda en la maquina para el cambio
        Moneda.comprobarMonedas();
        //1 - Llamada al método que muestra el menu
        mostrarMenu();
        //Mostramos la suma de la caja de monedas
        System.out.println("Tu credito es de: " + String.format("%.2f", Moneda.getCajetin()) + "€");
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
     * Metodo en el que se imprimen las opciones del menu
     */
    public void mostrarMenu() {
        System.out.println("\n               MENÚ ");
        System.out.println("=====================================");
        System.out.println("1: Introducir monedas");
        System.out.println("2: Café solo (" + Producto.getPrecioActualSolo() + ") (Cantidad: " + Producto.getCantidadSolo() + ")");
        System.out.println("3: Descafeinado (" + Producto.getPrecioActualDescafeinado() + ") (Cantidad: " + Producto.getCantidadDescafeinado() + ")");
        System.out.println("4: Té (" + Producto.getPrecioActualTe() + ") (Cantidad: " + Producto.getCantidadTe() + ")");
        System.out.println("5: Menú administración");
        System.out.println("6: Devolver Monedas");
        System.out.println("0: Apagar la máquina\n");
    }

    /**
     * Metodo que hace las comprobaciones necesarias
     * para que en el menú solo puedas introducir un valor del 0 al 6
     * asi como impedir caracteres no numerico..
     *
     * @return opMenu (int asignado a la opción del menu)..
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
     * Metodo que comprueba que la opción introducida esta entre 1 y 6
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
     * Metodo en el que una vez hechas las comprobaciones,
     * asignamos a cada caso sus funciones correspondientes
     *
     * @param opcion (valor del menu)
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
        boolean salir, monedaAceptada;
        int moneda = -1;
        do {
            salir = false;
            monedaAceptada = true;
            //Muestro monedas aceptada
            Moneda.mostrarMonedas();

            //Mostrar cantidad de la caja
            System.out.println("Tu credito es de: " + String.format("%.2f", Moneda.getCajetin()) + "€");
            try {
                moneda = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Introduzca un caracter númerico.");
                monedaAceptada = false;
            }
            if (monedaAceptada) {
                if (moneda == 0) {
                    salir = true;
                    monedaAceptada = false;
                } else {
                    if (Moneda.esMonedaValida(moneda)) {
                        Moneda.totalCajetin(moneda);
                        System.out.println("Tu credito es de: " + String.format("%.2f", Moneda.getCajetin()) + "€");
                    } else {
                        System.out.println("Moneda introducida no valida.");
                    }
                }
            }
        } while (!salir);
    }

    /**
     * Método para crear un cafe solo
     */
    private void crearSolo() {

        //Asignamos el tipo del producto
        Tipo t = Tipo.SOLO;

        //PASO1(COMPROBAR QUE HAY DINERO PARA COMPRAR PRODUCTO)
        //PASO2(COMPROBAR QUE HAY CAMBIO)
        //PASO3(COMPROBAR STOCK)
        //PASO4(CREAR OBJETO)



        //Comprobar si hay dinero suficiente para comprar el producto
        if (Moneda.comprobarPrecio(t)) {

            //Comprobar que haya devolucion tras comprar el producto
            if (Moneda.hayCambio(Producto.getPrecioActualSolo())) {


                //Si hay stock, podemos crear cafés, sino, no.
                if (Producto.hayStock(t)) {
                    //Creamos el objeto del producto enviándole el tipo en concreto (en este caso, un solo)
                    Producto p = new Producto(t);

                } else {
                    System.out.println("No hay más cafés solos disponibles.");
                }
            }else{
                System.out.println("No hay suficiente cambio disponible para devolver.");
                Moneda.devolucionMonedas();
            }
        } else {
            System.out.println(insertarDinero);


        }

    }

    /**
     * Método para crear un cafe descaféinado
     */
    private void crearDescafeinado() {
        Tipo t = Tipo.DESCAFEINADO;

        if (Moneda.comprobarPrecio(t)) {
            if (Producto.hayStock(t)) {
                //Creamos el objeto del producto enviándole el tipo en concreto (en este caso, un solo)
                Producto p = new Producto(t);
            } else {
                System.out.println("No hay más cafés descafeinados disponibles.");

            }
        } else {
            System.out.println(insertarDinero);

        }

    }

    /**
     * Método para crear un te
     */
    private void crearTe() {
        Tipo t = Tipo.TE;
        if (Moneda.comprobarPrecio(t)) {
            if (Producto.hayStock(t)) {
                //Creamos el objeto del producto enviándole el tipo en concreto (en este caso, un solo)
                Producto p = new Producto(t);
            } else {
                System.out.println("No hay más te disponibles.");
            }
        } else {
            System.out.println(insertarDinero);

        }

    }


    private void menuAdmin() {
        boolean saliradmin = false;
        //bucle que repite el programa hasta que le asignemos la opción de salir (0)
        do {
            saliradmin = menuAdministracion();

        } while (!saliradmin);

    }

    /**
     * Este metodo se encarga de realizar las operaciones necesarias para el menú de Administración.
     * La estructura es la misma que la del menú base de la maquina, cambiando solamente los metodos a los que llamamos.
     * Los comentarios tambien permanecen para explicar de nuevo los pasos que sigue el programa
     */
    private boolean menuAdministracion() {

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
            System.out.println("Regresar al menu principal");
            //Devolvemos true a la clase Main, para terminar el bucle que hay en esta y finalizar el programa
            return true;
        }

        iniciarMenuAdmin(opcion);

        return salirAdmin;
    }

    private void mostrarMenuAdmin() {
        System.out.println("\nMENÚ ADMINISTRACIÓN");
        System.out.println("===================");
        System.out.println("1: Mostrar contenido de cajetines");
        System.out.println("2: Modificar precios de los productos");
        System.out.println("3: Mostrar unidades vendidas");
        System.out.println("4: Añadir productos no implementados");
        System.out.println("0: Volver");
    }

    /**
     * Metodo que hace las comprobaciones
     * del menu administración
     *
     * @return opMenuAdmin a menuAdmin
     */
    private int introducirOpcionAdmin() {
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
     * Metodo que comprueba que los valores del menu admín van del 0 al 4
     *
     * @param opMenuAdmin
     * @return rangoValidoAdmin al metodo introducirOpcionAdmin
     */
    private boolean rangoValidoAdmin(int opMenuAdmin) {
        if (opMenuAdmin >= 0 && opMenuAdmin <= 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo en el que una vez hechas las comprobaciones,
     * asigna a cada caso las funciones del menu Admin
     *
     * @param opMenuAdmin (valor del menu)
     */
    private void iniciarMenuAdmin(int opMenuAdmin) {

        switch (opMenuAdmin) {
            case 0:
                //volver al menu principal
                menuMaquina();
            case 1:
                Moneda.mostrarContenidoCajetines();
                break;
            case 2:
                Producto.modificarPrecio();
                break;
            case 3:
                Producto.mostrarVentas();
                break;
            case 4:
                System.out.println("Añadir productos (función no implementada).");
                break;


        }
    }




    /**
     * Metodo que se encarga de contar las monedas que va a devolver el tipo
     */
    private void devolverMonedas() {
        //Si la cajetilla no tiene ninguna moneda avisa de que no hay ninguna moneda
        if (Moneda.getCajetin()==0){
            System.out.println("No hay monedas disponibles.");
        }else {
            //Si hay monedas procede a la devolucion(en MONEDA)
            Moneda.devolucionMonedas();
        }

    }


}
