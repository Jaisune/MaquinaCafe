import java.text.DecimalFormat;
import java.util.Scanner;

public class Producto {

    private static Scanner sc = new Scanner (System.in);

    //Atributos de clase
    private Tipo nombre;
    private double precio;


    //Atributos GENERALES
    private static int cantidadTotal=0;

    //Precios de cada producto
    private static double precioActualSolo = 0.5;
    private static double precioActualDescafeinado = 0.7;
    private static double precioActualTe = 0.5;

    //Cantidades en el stock de cada producto
    private static int cantidadSolo=10;
    private static int cantidadDescafeinado=10;
    private static int cantidadTe=10;

    //Cantidades vendidas de cada producto
    private static int cantidadSoloVendida=0;
    private static int cantidadDescafeinadoVendida=0;
    private static int cantidadTeVendida=0;

    //Constructor
    public Producto(Tipo t){
        nombre=t;
        cantidadTotal++;
        creacionProducto(nombre);
    }

    public Tipo getNombre() {
        return nombre;
    }

    public void setNombre(Tipo nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static int getCantidadTotal() {
        return cantidadTotal;
    }

    public static void setCantidadTotal(int cantidadTotal) {
        Producto.cantidadTotal = cantidadTotal;
    }

    public static double getPrecioActualSolo() {
        return precioActualSolo;
    }

    public static void setPrecioActualSolo(double precioActualSolo) {
        Producto.precioActualSolo = precioActualSolo;
    }

    public static double getPrecioActualDescafeinado() {
        return precioActualDescafeinado;
    }

    public static void setPrecioActualDescafeinado(double precioActualDescafeinado) {
        Producto.precioActualDescafeinado = precioActualDescafeinado;
    }

    public static double getPrecioActualTe() {
        return precioActualTe;
    }

    public static void setPrecioActualTe(double precioActualTe) {
        Producto.precioActualTe = precioActualTe;
    }

    public static int getCantidadSolo() {
        return cantidadSolo;
    }

    public static void setCantidadSolo(int cantidadSolo) {
        Producto.cantidadSolo = cantidadSolo;
    }

    public static int getCantidadDescafeinado() {
        return cantidadDescafeinado;
    }

    public static void setCantidadDescafeinado(int cantidadDescafeinado) {
        Producto.cantidadDescafeinado = cantidadDescafeinado;
    }

    public static int getCantidadTe() {
        return cantidadTe;
    }

    public static void setCantidadTe(int cantidadTe) {
        Producto.cantidadTe = cantidadTe;
    }

    public static int getCantidadSoloVendida() {
        return cantidadSoloVendida;
    }

    public static void setCantidadSoloVendida(int cantidadSoloVendida) {
        Producto.cantidadSoloVendida = cantidadSoloVendida;
    }

    public static int getCantidadDescafeinadoVendida() {
        return cantidadDescafeinadoVendida;
    }

    public static void setCantidadDescafeinadoVendida(int cantidadDescafeinadoVendida) {
        Producto.cantidadDescafeinadoVendida = cantidadDescafeinadoVendida;
    }

    public static int getCantidadTeVendida() {
        return cantidadTeVendida;
    }

    public static void setCantidadTeVendida(int cantidadTeVendida) {
        Producto.cantidadTeVendida = cantidadTeVendida;
    }

    /**
     * Método que se encarga de que una vez se cree el tipo de producto deseado
     * se le asignen los valores que este emplea, es decir, su precio, así como de
     * actualizar las cantidades en stock y cantidades vendidas
     * @param t (tipo del producto)
     */
    private void creacionProducto(Tipo t){

        //Si lo que me llega es igual al valor de la clase tipo, y tiene el valor "SOLO"...
        if (t==Tipo.valueOf(Tipo.class,"SOLO")){
            precio=precioActualSolo;  //Asigno su precio correspondiente
            cantidadSoloVendida++; //Se suma al contador de cantidades vendidas
            cantidadSolo--; //A la cantidad que había en stock, se le descuenta el producto creado
            Moneda.restarCajetin(precioActualSolo);
            //Moneda.actualizarCambioMaquina();
        }else if(t==Tipo.valueOf(Tipo.class,"DESCAFEINADO")){
            precio=precioActualDescafeinado;
            cantidadDescafeinadoVendida++;
            cantidadDescafeinado--;
            Moneda.restarCajetin(precioActualDescafeinado);
            //Moneda.actualizarCambioMaquina();
        }else if(t==Tipo.valueOf(Tipo.class,"TE")){
            precio=precioActualSolo;
            cantidadTeVendida++;
            cantidadTe--;
            Moneda.restarCajetin(precioActualTe);
            //Moneda.actualizarCambioMaquina();
        }
    }

    //Comprobaciones de stock
    public static boolean hayStock(Tipo t){
        boolean hayStock=false;
        if(t==Tipo.valueOf(Tipo.class,"SOLO")) {
            if (cantidadSolo>0){
                hayStock= true;
            } else {
                hayStock = false;
            }
        }
        if(t==Tipo.valueOf(Tipo.class,"DESCAFEINADO")) {
            if (cantidadDescafeinado>0){
                hayStock = true;
            } else {
                hayStock = false;
            }
        }
        if(t==Tipo.valueOf(Tipo.class,"TE")) {
            if (cantidadTe>0){
                hayStock = true;
            } else {
                hayStock = false;
            }
        }
        return hayStock;

    }

    public static void mostrarVentas(){
        System.out.println("Cantidad de descafeinado vendida: "+ getCantidadDescafeinadoVendida());
        System.out.println("Cantidad de café solo vendido: "+ getCantidadSoloVendida());
        System.out.println("Cantidad té vendida: "+ getCantidadTeVendida());
    }

    /**
     * Método que modifica el precio del producto.
     */
    public static void modificarPrecio() {

        int numProducto=-1;
        int cantidad=0;
        boolean salir=false,numProductoValido,cantidadValida;
        boolean repetir=true;

        do {
            numProductoValido=true;
            cantidadValida=true;

            //Se muestran los productos
            mostrarProductos();

            System.out.println("Selecciona un producto: ");
            try {
                numProducto = sc.nextInt();
            }catch(Exception e ){
                System.out.println("Has introducido un caracter erroneo.");
                numProductoValido=false;
                sc.nextLine();
            }
            //Si es igual a 0, saldremos del metodo
            if (numProducto==0) {
                salir=true;
                numProductoValido=false;
            }

            //Comprobamos que el numero esté dentro del rango del producto
            if (!comprobarNumProducto(numProducto)){
                numProductoValido=false;
            }

            if (numProductoValido){
                System.out.println("Introduce el nuevo precio (en céntimos)");

                try {
                    cantidad = sc.nextInt();
                }catch(Exception e){
                    System.out.println("No has introducido un número.");
                    cantidadValida=false;
                    sc.nextLine();
                }
            }

            //Si se dan todas las condiciones
            if (numProductoValido && cantidadValida){
                //Se hace un casteo al nuevo precio para que sea double
                double cantidadDouble = (double) cantidad;

                //Se pasa el precio a número con decimales
                double cant=cantidadDouble/100;
                //Si el producto se ha modificado, saldrá del bucle
                if (cambiarPrecio(numProducto, cant)){
                    salir=true;
                    numProductoValido=false;
                    cantidadValida=false;
                }else {
                    //Si no se ha modificado el precio, saldremos del bucle
                    System.out.println("Se ha cancelado la modificación del precio.");
                    salir=true;
                    numProductoValido=false;
                    cantidadValida=false;
                }
            }else {
                //Si es inferior o igual a 0, se repetirá el bucle
                salir=false;
                repetir=false;
            }

        }while(!salir);



    }

    private static void mostrarProductos(){
        System.out.println("\n------Productos------");
        System.out.println("1 - Solo: "+getPrecioActualSolo());
        System.out.println("2 - Descafeinado: "+getPrecioActualDescafeinado());
        System.out.println("3 - Te: "+getPrecioActualTe());
        System.out.println("0 - Salir.");
    }

    private static boolean comprobarNumProducto(int numProducto){
        if (numProducto>=0 && numProducto<=3){
            return true;
        } else {
            System.out.println("El número está fuera del rango.");
            return false;
        }
    }

    private static boolean cambiarPrecio(int numProducto, double cant){
        boolean modif = false;
        double precioAntiguo;


        //Se aplicará este formato para mostrar los precios.
        DecimalFormat df = new DecimalFormat("0.00");

        switch (numProducto){
            case 0:
                modif=false;
                break;
            case 1:
                //En caso de seleccion del producto con este numero

                //Se guarda el precio actual, el cual mostrara el precio anterior a la modificacion
                precioAntiguo=precioActualSolo;

                //Se asigna el nuevo precio del producto como precio actual
                precioActualSolo=cant;
                //Se muestra el precio antiguo y el actual
                System.out.println("Precio antiguo: "+df.format(precioAntiguo)+"€");
                System.out.println("Precio modificado: "+df.format(precioActualSolo)+"€");

                modif = true;
                break;
            case 2:
                precioAntiguo=precioActualDescafeinado;

                precioActualDescafeinado=cant;
                System.out.println("Precio antiguo: "+df.format(precioAntiguo)+"€");
                System.out.println("Precio modificado: "+df.format(precioActualDescafeinado)+"€");

                modif = true;
                break;
            case 3:
                precioAntiguo=precioActualTe;

                precioActualTe=cant;
                System.out.println("Precio antiguo: "+df.format(precioAntiguo)+"€");
                System.out.println("Precio modificado: "+df.format(precioActualTe)+"€");

                modif = true;
                break;
            default:
                modif=false;

        }return modif;
    }

}
