import jdk.swing.interop.SwingInterOpUtils;

/**
 * 
 * @author Jaime Diaz Menendez
 *
 */

public class Moneda {

    //Atributos de clase
    private static double cajetin = 0; //contiene las monedas para pagar el producto
    private static double totalCaja = 0; //contiene el cambio total(la suma total de todas las monedas) para la devolución

    //las variables que contienen "e" al final se refieren a euros, el resto son centimos
    //monedas para el cambio
    private static int cant2e = 20;
    private static int cant1e = 20;
    private static int cant50 = 20;
    private static int cant20 = 20;
    private static int cant10 = 20;
    private static int cant5 = 20;

    //Monedas insertadas en la cajetilla para comprar el producto
    private static int cant2eInsertada = 0;
    private static int cant1eInsertada = 0;
    private static int cant50Insertada = 0;
    private static int cant20Insertada = 0;
    private static int cant10Insertada = 0;
    private static int cant5Insertada = 0;

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


    /**
     * Método que sumará las monedas introducidas en el cajetín una a una y sumandose en el cajetín de monedas de la máquina.
     * @param num
     */
    public static void totalCajetin(int num) {
        cantidadMonedasInsertadas(num);
        cajetin = calcularCajetin();
    }

    /**
     * Método que incrementa el contador de monedas del cajetín sobre la moneda que le llega.
     * @param num
     */
    private static void cantidadMonedasInsertadas(int num) {
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

    /**
     * Método que calcula las monedas que introducimos al comprar un producto
     *
     * @return
     */
    protected static double calcularCajetin() {
        double suma= (cant1eInsertada * 1.00) + (cant2eInsertada * 2.00) + (cant50Insertada * 0.50) + (cant10Insertada * 0.10) + (cant20Insertada * 0.20) + (cant5Insertada * 0.05);
        return suma;
    }

    /**
     * Método que se encarga de mostrar el tipo de monedas que aceptamos en el menú
     */
    public static void mostrarMonedas() {
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

    /**
     * Método que comprobará si la moneda introducida es válida (todas menos las de 1 cent y 2 cent.
     * @param moneda
     * @return
     */
    public static boolean esMonedaValida(int moneda) {
        if (moneda == 1 || moneda == 2 || moneda == 5 || moneda == 10 || moneda == 20 || moneda == 50) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * * Método que hará el proceso de cambio con la devolución del producto y reseteará el cajetin.
     */
    public static void restarCajetin(double precio) {
        //Calculamos el precio restante (a devolver) en numero entero
        int centimos = calcularCambioCajetin(precio);
        //Calcularemos las monedas a devolver
        devolucionCambio(centimos);
        //Método en el que sumamos las monedas restantes a las monedas que va a tener la maquina
        vaciarCajetin();
        cajetin = calcularCajetin();
    }

    /**
     * Este método se encarga de sumar las monedas restantes de la compra a las monedas que va a tener la máquina
     */
    private static void vaciarCajetin() {
        cant2e = cant2e + cant2eInsertada;
        cant2eInsertada = 0;

        cant1e = cant1e + cant1eInsertada;
        cant1eInsertada = 0;

        cant50 = cant50 + cant50Insertada;
        cant50Insertada = 0;

        cant20 = cant20 + cant20Insertada;
        cant20Insertada = 0;

        cant10 = cant10 + cant10Insertada;
        cant10Insertada = 0;

        cant5 = cant5 + cant5Insertada;
        cant5Insertada = 0;
    }

    /**
     * Metodo que resta el precio del producto de la caja
     *
     * @param centimos
     */
    private static void devolucionCambio(int centimos) {
        //Variables que representan a las cantidades de los tipos de monedas que se restan completamente de este tipo
        int aux2 = 0;
        int aux1 = 0;
        int aux50 = 0;
        int aux20 = 0;
        int aux10 = 0;
        int aux5 = 0;

        //Variables que representan al stock de monedas de los tipos de monedas que se restan completamente de este tipo, en vez de descontar del contador de la clase se hará con el auxiliar.
        int auxCant2 = cant2e;
        int auxCant1 = cant1e;
        int auxCant50 = cant50;
        int auxCant20 = cant20;
        int auxCant10 = cant10;
        int auxCant5 = cant5;

        //Mostramos la cantidad que tendremos que devolver.
        System.out.println("El cambio a devolver es el siguiente:" + centimos + " cént.");

        //Este condicional se encarga de que si podemos realizar la operacion, significa
        // que podemos devolver monedas de 2 euros (y así con el resto...)
        if (centimos / 200 > 0) {

            if ((cant2e >= centimos / 200)) {

                aux2 = centimos / 200;
                centimos %= 200;

            } else if (cant2e > 0) {

                centimos -= 200;
                auxCant2--;
                aux2++;
                while (centimos != 0) {
                    if (auxCant2 == 0) {
                        break;
                    }
                    centimos -= 200;
                    auxCant2--;
                    aux2++;
                }
            }
            //Si hay alguna moneda de este tipo se mostrará la cantidad, sino no se mostrará pues entrar entra dentro de esta condicional.
            if (auxCant2 > 0) {
                System.out.printf("%nMonedas de 2€: %d", aux2);
            }
        }

        if (centimos / 100 > 0) {


            if ((cant1e >= centimos / 100)) {

                aux1 = centimos / 100;
                centimos %= 100;
            } else if (cant1e > 0) {

                centimos -= 100;
                auxCant1--;
                aux1++;
                while (centimos != 0) {
                    if (auxCant1 == 0) {
                        break;
                    }
                    centimos -= 100;
                    auxCant1--;
                    aux1++;
                }
            }
            if (auxCant1 > 0) {
                System.out.printf("%nMonedas de 1€: %d", aux1);
            }
        }

        if ((centimos / 50) > 0) {

            if (cant50 >= (centimos / 50)) {
                aux50 = centimos / 50;
                centimos %= 50;

            } else if (cant50 > 0) {

                centimos -= 50;
                auxCant50--;
                aux50++;
                while (centimos != 0) {
                    if (auxCant50 == 0) {
                        break;
                    }
                    centimos -= 50;
                    auxCant50--;
                    aux50++;
                }
            }
            if (auxCant50 > 0) {
                System.out.printf("%nMonedas de 50 cent: %d", aux50);
            }

        }

        if (centimos / 20 > 0) {

            if ((cant20 >= (centimos / 20))) {

                aux20 = centimos / 20;
                centimos %= 20;

            } else if (cant20 > 0) {

                centimos -= 20;
                auxCant20--;
                aux20++;
                while (centimos != 0) {
                    if (auxCant20 == 0) {
                        break;
                    }
                    centimos -= 20;
                    auxCant20--;
                    aux20++;
                }
            }

            if (aux20 > 0) {
                System.out.printf("%nMonedas de 20 cent: %d", aux20);
            }
        }

        if (centimos / 10 > 0) {

            if ((cant10 >= (centimos / 10))) {

                aux10 = centimos / 10;
                centimos %= 10;
            } else if (cant10 > 0) {

                centimos -= 10;
                auxCant10--;
                aux10++;
                while (centimos != 0) {
                    if (auxCant10 == 0) {
                        break;
                    }
                    centimos -= 10;
                    auxCant10--;
                    aux10++;
                }
            }
            if (aux10 > 0) {
                System.out.printf("%nMonedas de 10 cent: %d", aux10);
            }
        }

        if (centimos / 5 > 0) {

            if ((cant5 >= (centimos / 5))) {

                aux5 = centimos / 5;
                centimos %= 5;

            } else if (cant5 > 0) {

                centimos -= 5;
                auxCant5--;
                aux5++;
                while (centimos != 0) {
                    if (auxCant5 == 0) {
                        break;
                    }
                    centimos -= 5;
                    auxCant5--;
                    aux5++;
                }
            }
            if (aux5 > 0) {
                System.out.printf("%nMonedas de 5 cent: %d", aux5);
            }
            System.out.println();
        }

        //Se restan las cantidades de los contadores auxiliares que han ido acumulando las devoluciones de las monedas.
        cant2e -= aux2;
        cant1e -= aux1;
        cant50 -= aux50;
        cant20 -= aux20;
        cant10 -= aux10;
        cant5 -= aux5;

    }

    /**
     * Método para calcular el resto de cajetin - precioProducto para obtener el total en centimos para los calculos de devolucion de moneda
     *
     * @param precioProducto
     * @return
     */
    private static int calcularCambioCajetin(double precioProducto) {

        double cajetinMonedas = calcularCajetin() * 100;
        int centimos = (int) cajetinMonedas;

        double precio = precioProducto * 100;
        int precioProductoEntero = (int) precio;
        centimos -= precioProductoEntero;

        return centimos;
    }


    /**
     * Método que comprueba que se haya introducido el precio correspondiente
     * o superior para comprar el producto que se ha elegido.
     * @param t
     * @return
     */
    public static boolean comprobarPrecio(Tipo t) {
        boolean respuesta = false;
        switch (t) {
            case SOLO:
                if (cajetin >= Producto.getPrecioActualSolo()) {
                    respuesta = true;
                } else {
                    respuesta = false;
                }
                break;
            case DESCAFEINADO:
                if (cajetin >= Producto.getPrecioActualDescafeinado()) {
                    respuesta = true;
                } else {
                    respuesta = false;
                }
                break;
            case TE:
                if (cajetin >= Producto.getPrecioActualTe()) {
                    respuesta = true;
                } else {
                    respuesta = false;
                }
                break;
        }
        return respuesta;
    }

    /**
     * Metodo que muestra el contenido del cajetin, total de euros en caja y cuantas monedas hay de cada tipo
     */
    public static void mostrarContenidoCajetines() {
        //obtener el calculo del total de monedas

        System.out.println("\nTotal de euros en caja: "+calcularSumaTotalMonedas());

        System.out.println(getCant2e() + " Monedas de 2 €");
        System.out.println(getCant1e() + " Monedas de 1 €");
        System.out.println(getCant50() + " Monedas de 50 cent");
        System.out.println(getCant20() + " Monedas de 20 cent");
        System.out.println(getCant10() + " Monedas de 10 cent");
        System.out.println(getCant5() + " Monedas de 5 cent");
    }

    /**
     * Metodo que calcula el valor total de las monedas que tenemos en la cafetera
     *
     * @return
     */
    public static double calcularSumaTotalMonedas() {
        double sumaMonedas;
        sumaMonedas = (cant1e * 1.00) + (cant2e * 2.00) + (cant50 * 0.50) + (cant10 * 0.10) + (cant20 * 0.20) + (cant5 * 0.05);

        return sumaMonedas;
    }

    /**
     * Metodo que se encarga de la devolucion de las monedas
     *
     * @return
     */
    public static void devolucionMonedas() {

        System.out.println("Se han devuelto: ");

        //Si hay alguna moneda, muestro el texto, la cantidad devuelta y lo reseteo.
        if (cant2eInsertada != 0) {
            System.out.println("Monedas de: " + getCant2eInsertada() + "de 2€");
            cant2eInsertada = 0;
        }
        if (cant1eInsertada != 0) {
            System.out.println("Monedas de: " + getCant1eInsertada() + "de 1€");
            cant1eInsertada = 0;
        }
        if (cant50Insertada != 0) {
            System.out.println("Monedas de: " + getCant50Insertada() + "de 50 cent");
            cant50Insertada = 0;
        }
        if (cant20Insertada != 0) {
            System.out.println("Monedas de: 20 cent" + getCant20Insertada());
            cant20Insertada = 0;
        }
        if (cant10Insertada != 0) {
            System.out.println("Monedas de: " + getCant10Insertada() + "de 10 cent");
            cant10Insertada = 0;
        }
        if (cant5Insertada != 0) {
            System.out.println("Monedas de: " + getCant5Insertada() + "de 5 cent");
            cant5Insertada = 0;
        }
        cajetin = calcularCajetin();
    }

    /**
     * Metodo que nos indica si hay suficiente cambio para devolver
     * @param precioProducto
     * @return
     */
    public static boolean hayCambio(double precioProducto) {
        double cambioDecimal=calcularSumaTotalMonedas()*100;
        //Obtenemos todo el cambio de la caja en INT
        int cambio = (int) cambioDecimal;

        //Calculamos el resto del cajetin - precio
        int centimos = calcularCambioCajetin(precioProducto);
        /*Comparamos que el cambio a devolver de la cajetilla sea inferior o igual que el cambio de la maquina y que haya
        la cantidad de monedas de cambio suficientes*/
        if (centimos <= cambio && comprobarStockMonedas(centimos)) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que comprueba si hay la cantidad de monedas necesarias para proporcionar el cambio del producto.
     */
    public static boolean comprobarStockMonedas(int centimos) {

        //Variables auxiliares que harán de contador de las veces que devuelve una cantidad concreta de moneda.
        int aux2 = 0;
        int aux1 = 0;
        int aux50 = 0;
        int aux20 = 0;
        int aux10 = 0;
        int aux5 = 0;

        //Si el cambio está dentro del rango de la cantidad de la moneda se comprobara si...
        if (centimos / 200 > 0) {
            //Si hay la misma cantidad de monedas de cambio del tipo que es o mayor cantidad...
            if ((cant2e >= centimos / 200)) {

                //Se restaran directamente la cantidad de monedas del tipo que es.
                cant2e -= (centimos / 200);
                //Al contador se le dirá cuantas monedas hay de este tipo.
                aux2 += (centimos / 200);
                //Se resta el cambio por completo pues hay cambio de esta moneda.
                centimos %= 200;

            } else if (cant2e > 0) {
                //Si no hay cambio total de esta moneda pues se hará vía devolucion de lo que se pueda.

                //Se resta la cantidad del tipo de moneda en la que está.
                centimos -= 200;
                //Se resta un contador de la cantidad.
                cant2e--;
                //Se suma un contador del tipo de moneda que es para saber cuantas monedas ha restado.
                aux2++;

                //Mientras que quede alguna moneda se repite el bucle.
                while (centimos != 0) {
                    //Si se gastan las monedas de este tipo y queda aun por devolver se romperá el ciclo y se pasará a comprobar con la moneda inferior a esta.
                    if ((cant2e * 100) != centimos) {
                        break;
                    }
                    //Si siguen quedando monedas se hará el mismo proceso de antes del bucle mientras que queden monedas.
                    centimos -= 200;
                    cant2e--;
                    aux2++;
                }
            }
        }

        if (centimos / 100 > 0) {

            if ((cant1e >= centimos / 100)) {

                cant1e -= (centimos / 100);
                aux1 += (centimos / 100);
                centimos %= 100;
            } else if (cant1e > 0) {

                centimos -= 100;
                cant1e--;
                aux1++;
                while (centimos != 0) {
                    if ((cant1e * 100) != centimos) {
                        break;
                    }
                    centimos -= 100;
                    cant1e--;
                    aux1++;
                }
            }
        }
        if ((centimos / 50) > 0) {

            if (cant50 >= (centimos / 50)) {
                cant50 -= (centimos / 50);
                aux50 += (centimos / 50);
                centimos %= 50;

            } else if (cant50 > 0) {

                centimos -= 50;
                cant50--;
                aux50++;
                while (centimos != 0) {
                    if ((cant50 * 10) != centimos) {
                        break;
                    }
                    centimos -= 50;
                    cant50--;
                    aux50++;
                }
            }
        }

        if (centimos / 20 > 0) {

            if ((cant20 >= (centimos / 20))) {

                cant20 -= (centimos / 20);
                aux20 += (centimos / 20);
                centimos %= 20;
            } else if (cant20 > 0) {

                centimos -= 20;
                cant20--;
                aux20++;
                while (centimos != 0) {
                    if ((cant20 * 10) != centimos) {
                        break;
                    }
                    centimos -= 20;
                    cant20--;
                    aux20++;
                }
            }
        }

        if (centimos / 10 > 0) {

            if ((cant10 >= (centimos / 10))) {

                cant10 -= (centimos / 10);
                aux10 += (centimos / 10);
                centimos %= 10;
            } else if (cant10 > 0) {

                centimos -= 10;
                cant10--;
                aux10++;
                while (centimos != 0) {
                    if (cant10 == 0) {
                        break;
                    }
                    centimos -= 10;
                    cant10--;
                    aux10++;
                }
            }
        }

        if (centimos / 5 > 0) {

            if ((cant5 >= (centimos / 5))) {

                cant5 -= (centimos / 5);
                aux5 += (centimos / 5);
                centimos %= 5;
            } else if (cant5 > 0) {

                centimos -= 5;
                cant5--;
                aux5++;
                while (centimos != 0) {
                    if (cant5 == 0) {
                        break;
                    }
                    centimos -= 5;
                    cant5--;
                    aux5++;
                }
            }
        }

        //Dado que este método es de comprobacion y no de aplicar pues se restauran los valores de las cantidades a como estaban inicialmente con los auxiliares que contienen las cantidades restadas.
        cant2e += aux2;
        cant1e += aux1;
        cant50 += aux50;
        cant20 += aux20;
        cant10 += aux10;
        cant5 += aux5;

        //Si se ha podido restar todo el cambio significa que hay cambio, si ha quedado algun centimo por falta de stock de monedas significará que no hay cambio disponible.
        if (centimos != 0) {
            return false;
        } else {
            return true;


        }
    }

    /**
     *  Metodo que comprueba si falta stock en alguna moneda de cambio.
     */
    public static void comprobarMonedas(){
        System.out.println();
        if (cant2e == 0) {
            System.out.println("Se han agotado las monedas de 2€, por favor introduzca en la caja de cambio, gracias.");
        }
        if (cant1e == 0) {
            System.out.println("Se han agotado las monedas de 1€, por favor introduzca en la caja de cambio, gracias.");
        }
        if (cant50 == 0) {
            System.out.println("Se han agotado las monedas de 50 cent, por favor introduzca en la caja de cambio, gracias.");
        }
        if (cant20 == 0) {
            System.out.println("Se han agotado las monedas de 20 cent, por favor introduzca en la caja de cambio, gracias.");
        }
        if (cant10 == 0) {
            System.out.println("Se han agotado las monedas de 10 cent, por favor introduzca en la caja de cambio, gracias.");
        }
        if (cant5 == 0) {
            System.out.println("Se han agotado las monedas de 5 cent, por favor introduzca en la caja de cambio, gracias.");
        }
    }

    /**
     * Metodo que actualiza las monedas de cambio de la maquina
     */
    public static void actualizarCambioMaquina(){


        int aux2,aux1,aux50,aux20,aux10,aux5;

        aux2=cant2e;
        aux1=cant1e;
        aux50=cant50;
        aux20=cant20;
        aux10=cant10;
        aux5=cant5;

        cant2e=aux2;
        cant1e=aux1;
        cant50=aux50;
        cant20=aux20;
        cant10=aux10;
        cant5=aux5;
    }
}