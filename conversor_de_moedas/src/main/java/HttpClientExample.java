import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Criar um cliente HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Criar uma requisição GET para a API de taxas de câmbio
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
                .build();

        // Enviar a requisição e receber a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Exibir o código de status da resposta
        System.out.println("Status Code: " + response.statusCode());

        // Exibir o corpo da resposta
        System.out.println("Response Body: " + response.body());
    }
}