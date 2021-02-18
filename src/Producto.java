public class Producto {

    //Atributos de clase
    private Tipo nombre;
    private double precio;


    //Atributos GENERALES
    private static int cantidadTotal=0;

    //Precios de cada producto
    private static double precioActualSolo = 0.8;
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
        }else if(t==Tipo.valueOf(Tipo.class,"DESCAFEINADO")){
            precio=precioActualDescafeinado;
            cantidadDescafeinadoVendida++;
            cantidadDescafeinado--;
            Moneda.restarCajetin(precioActualDescafeinado);
        }else if(t==Tipo.valueOf(Tipo.class,"TE")){
            precio=precioActualSolo;
            cantidadTeVendida++;
            cantidadTe--;
            Moneda.restarCajetin(precioActualTe);
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

}
