import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsultarCambioMoneda {
    public static String consultaMoneda(int opcion) {
        String[] moneda = MapearOpcion.mapeaOpcion(opcion);

        URI direccionUri = URI.create("https://v6.exchangerate-api.com/v6/4ee5507e382f2f6e9c9d8e5d/latest/" + moneda[0]);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionUri)
                .build();
        try {
            HttpResponse<String> response;
            response = client
                        .send(request, BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
