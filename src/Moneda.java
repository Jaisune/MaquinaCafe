public class Moneda {

    //Atributos de clase
    private static double cajetin=0; //contiene las monedas para pagar el producto
    private static double totalCaja=0; //contiene el cambio total(la suma total de todas las monedas) para la devolución

    //las variables que contienen "e" al final se refieren a euros, el resto son céntimos
    //monedas para el cambio
    private static int cant2e=5;
    private static int cant1e=5;
    private static int cant50=5;
    private static int cant20=5;
    private static int cant10=5;
    private static int cant5=5;

    //Monedas insertadas en la cajetilla para comprar el producto
    private static int cant2eInsertada=0;
    private static int cant1eInsertada=0;
    private static int cant50Insertada=0;
    private static int cant20Insertada=0;
    private static int cant10Insertada=0;
    private static int cant5Insertada=0;

    //Getters y Setters de los atributos

    public static double getCajetin() {
        return cajetin;
    }

    public static void setCajetin(double cajetin) {
        Moneda.cajetin = cajetin;
    }

    public static double getTotalCaja() {
        return totalCaja;
    }

    public static void setTotalCaja(double totalCaja) {
        Moneda.totalCaja = totalCaja;
    }

    public static int getCant2e() {
        return cant2e;
    }

    public static void setCant2e(int cant2e) {
        Moneda.cant2e = cant2e;
    }

    public static int getCant1e() {
        return cant1e;
    }

    public static void setCant1e(int cant1e) {
        Moneda.cant1e = cant1e;
    }

    public static int getCant50() {
        return cant50;
    }

    public static void setCant50(int cant50) {
        Moneda.cant50 = cant50;
    }

    public static int getCant20() {
        return cant20;
    }

    public static void setCant20(int cant20) {
        Moneda.cant20 = cant20;
    }

    public static int getCant10() {
        return cant10;
    }

    public static void setCant10(int cant10) {
        Moneda.cant10 = cant10;
    }

    public static int getCant5() {
        return cant5;
    }

    public static void setCant5(int cant5) {
        Moneda.cant5 = cant5;
    }

    public static int getCant2eInsertada() {
        return cant2eInsertada;
    }

    public static void setCant2eInsertada(int cant2eInsertada) {
        Moneda.cant2eInsertada = cant2eInsertada;
    }

    public static int getCant1eInsertada() {
        return cant1eInsertada;
    }

    public static void setCant1eInsertada(int cant1eInsertada) {
        Moneda.cant1eInsertada = cant1eInsertada;
    }

    public static int getCant50Insertada() {
        return cant50Insertada;
    }

    public static void setCant50Insertada(int cant50Insertada) {
        Moneda.cant50Insertada = cant50Insertada;
    }

    public static int getCant20Insertada() {
        return cant20Insertada;
    }

    public static void setCant20Insertada(int cant20Insertada) {
        Moneda.cant20Insertada = cant20Insertada;
    }

    public static int getCant10Insertada() {
        return cant10Insertada;
    }

    public static void setCant10Insertada(int cant10Insertada) {
        Moneda.cant10Insertada = cant10Insertada;
    }

    public static int getCant5Insertada() {
        return cant5Insertada;
    }

    public static void setCant5Insertada(int cant5Insertada) {
        Moneda.cant5Insertada = cant5Insertada;
    }

    public static void totalCajetin(int num){
        cantidadMonedasInsertadas(num);
        cajetin=calcularCajetin();
    }

    private static void cantidadMonedasInsertadas(int num){
        switch (num) {
            case 1:
                cant1eInsertada++;
                break;
            case 2:
                cant2eInsertada++;
                break;
            case 50:
                cant50Insertada++;
                break;
            case 20:
                cant20Insertada++;
                break;
            case 10:
                cant10Insertada++;
                break;
            case 5:
                cant5Insertada++;
                break;
        }
    }
    private static double calcularCajetin(){
        double suma;
        return suma=(cant1eInsertada*1.00)+(cant2eInsertada*2.00)+(cant50Insertada*0.50)+(cant10Insertada*0.10)+(cant20Insertada*0.20)+(cant5Insertada*0.05);
    }

    public static void mostrarMonedas(){
        System.out.println("\n INTRODUCIR MONEDAS");
        System.out.println("Monedas aceptadas:");
        System.out.println("5 -> 5 Cts.");
        System.out.println("10 -> 10 Cts.");
        System.out.println("20 -> 20 Cts.");
        System.out.println("50 -> 50 Cts.");
        System.out.println("1 -> 1 €.");
        System.out.println("2 -> 2 €.");
        System.out.println("0 -> Finalizar.");
    }

    public static boolean esMonedaValida(int moneda){
        if(moneda==1 || moneda==2 || moneda == 5 || moneda == 10 || moneda == 20 || moneda == 50){
            return true;
        }else{
            return false;
        }
    }

    public static boolean comprobarPrecio(Tipo t){
        boolean respuesta=false;
        switch (t) {
            case SOLO:
                if (cajetin>=Producto.getPrecioActualSolo()) {
                    respuesta=true;
                }else{
                    respuesta=false;
                }
                break;
            case DESCAFEINADO:
                if (cajetin>=Producto.getPrecioActualDescafeinado()) {
                    respuesta=true;
                }else{
                    respuesta=false;
                }
                break;
            case TE:
                if (cajetin>=Producto.getPrecioActualTe()) {
                    respuesta=true;
                }else{
                    respuesta=false;
                }
                break;
        }
        return respuesta;
    }
}
