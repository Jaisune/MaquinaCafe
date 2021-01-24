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
        }else if(t==Tipo.valueOf(Tipo.class,"DESCAFEINADO")){
            precio=precioActualDescafeinado;
            cantidadDescafeinadoVendida++;
            cantidadDescafeinado--;
        }else if(t==Tipo.valueOf(Tipo.class,"TE")){
            precio=precioActualSolo;
            cantidadTeVendida++;
            cantidadTe--;
        }
    }

}
