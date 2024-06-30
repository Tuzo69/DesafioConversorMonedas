import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        // Creamnos el scanner
        Scanner userIn = new Scanner(System.in);
        // Creamos nuestro Gson builder
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Inicializamos la variable opcion
        int opcion = 1;

        while (opcion != 7) {
            System.out.println("Bienvenido al conversor de monedas.\nDigite una opción para comenzar");
            System.out.println("**************************************\n" +
                    "1) Dólar -> Peso Argentino\n" +
                    "2) Peso Argentino -> Dólar\n" +
                    "3) Dólar -> Peso mexicano\n" +
                    "4) Peso mexicano -> Dólar\n" +
                    "5) Dólar -> Peso colombiano\n" +
                    "6) Peso colombiano -> Dólar\n" +
                    "7) Salir\n" +
                    "**************************************");
            opcion = userIn.nextInt();

            if (opcion > 0 && opcion < 7) {
                System.out.println("Ingrese la cantidad que deseé convertir:");
                double cantidadConvertir = userIn.nextFloat();

                // Obtenemos el json de respuesta de la API
                String jsonResponse = ConsultarCambioMoneda.consultaMoneda(opcion);
                // Convertimos el json a un record para trabajar con los datos
                MonedaRecord miMoneda = gson.fromJson(jsonResponse, MonedaRecord.class);
                // Obtenemos el valor de la moneda a convertir
                double monedaCambio = (miMoneda.conversion_rates().get(MapearOpcion.mapeaOpcion(opcion)[1]));

                double totalCambio = cantidadConvertir * monedaCambio;
                System.out.println("==============================================================\n" +
                        "El valor de " + cantidadConvertir + " [" +
                        MapearOpcion.mapeaOpcion(opcion)[0] + "] " +
                        "corresponde a " + totalCambio + " [" +
                        MapearOpcion.mapeaOpcion(opcion)[1] + "]\n" +
                        "==============================================================\n");
            } else if (opcion == 7){
                System.out.println("Gracias por utilizar nuestro servicio, vuelva pronto :D");
            } else {
                System.out.println("Digite una opción válida\n\n");
            }
        }
        userIn.close();
    }
}
