import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        // Obtener URLs de los servicios a través de variables de entorno
        String authUrl = "http://localhost:8080/login";
        String greetingUrl = "http://localhost:8080/saludo";

        // Generar usuario y clave aleatorios
        String username = "user_" + UUID.randomUUID();
        String password = "pass_" + UUID.randomUUID();

        // Autenticación: Solicitar token
        String authResponse = authenticate(authUrl, username, password);
        System.out.println("Token recibido: " + authResponse);

        // Llamar al servicio de saludo
        String greetingResponse = callGreetingService(greetingUrl, authResponse);
        System.out.println("Respuesta del servicio de saludo: " + greetingResponse);
    }

    private static String authenticate(String url, String username, String password) throws Exception {
        try{
        HttpClient client = HttpClient.newHttpClient();

        // Crear JSON para la autenticación
        String json = String.format("{\"usuario\":\"%s\",\"clave\":\"%s\"}", username, password);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
        }catch(Exception e){
            System.out.println("Error: "+e);
            return null;
        }
         // Suponiendo que el token se devuelve en el cuerpo
    }

    private static String callGreetingService(String url, String token) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "Bearer " + token)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
