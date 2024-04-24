package meuapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExchangeRateApiExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertendo o JSON para um objeto Java
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            // Criando uma instância de CurrencyRates
            CurrencyRates currencyRates = new CurrencyRates(jsonObject);

            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Converter USD para ARS");
                System.out.println("2 - Converter USD para BOB");
                System.out.println("3 - Converter USD para BRL");
                System.out.println("4 - Converter USD para CLP");
                System.out.println("5 - Converter USD para COP");
                System.out.println("0 - Sair");

                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    break;
                }

                System.out.println("Digite o valor em USD:");
                double amountUSD = scanner.nextDouble();

                switch (opcao) {
                    case 1:
                        double amountARS = currencyRates.convertToARS(amountUSD);
                        System.out.println("ARS: " + amountARS);
                        break;
                    case 2:
                        double amountBOB = currencyRates.convertToBOB(amountUSD);
                        System.out.println("BOB: " + amountBOB);
                        break;
                    case 3:
                        double amountBRL = currencyRates.convertToBRL(amountUSD);
                        System.out.println("BRL: " + amountBRL);
                        break;
                    case 4:
                        double amountCLP = currencyRates.convertToCLP(amountUSD);
                        System.out.println("CLP: " + amountCLP);
                        break;
                    case 5:
                        double amountCOP = currencyRates.convertToCOP(amountUSD);
                        System.out.println("COP: " + amountCOP);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
