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
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
                .build();

        Scanner scanner = new Scanner(System.in); // Movida para fora do bloco try

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertendo o JSON para um objeto Java
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            // Criando uma instância de CurrencyRates
            CurrencyRates currencyRates = new CurrencyRates(jsonObject);

            while (true) {
                System.out.println("""
                    Escolha uma opção:
                    1 - Converter BRL para ARS
                    2 - Converter BRL para BOB
                    3 - Converter BRL para CLP
                    4 - Converter BRL para COP
                    5 - Converter ARS para BRL
                    6 - Converter BOB para BRL
                    7 - Converter CLP para BRL
                    8 - Converter COP para BRL
                    0 - Sair
                    """);

                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    break;
                }

                System.out.println("Digite o valor:");

                double valor = scanner.nextDouble();

                switch (opcao) {
                    case 1:
                        double valorARS = currencyRates.convertBRLToARS(valor);
                        System.out.println("ARS: " + valorARS);
                        break;
                    case 2:
                        double valorBOB = currencyRates.convertBRLToBOB(valor);
                        System.out.println("BOB: " + valorBOB);
                        break;
                    case 3:
                        double valorCLP = currencyRates.convertBRLToCLP(valor);
                        System.out.println("CLP: " + valorCLP);
                        break;
                    case 4:
                        double valorCOP = currencyRates.convertBRLToCOP(valor);
                        System.out.println("COP: " + valorCOP);
                        break;
                    case 5:
                        double valorBRLtoARS = currencyRates.convertARSToBRL(valor);
                        System.out.println("BRL: " + valorBRLtoARS);
                        break;
                    case 6:
                        double valorBRLtoBOB = currencyRates.convertBOBToBRL(valor);
                        System.out.println("BRL: " + valorBRLtoBOB);
                        break;
                    case 7:
                        double valorBRLtoCLP = currencyRates.convertCLPToBRL(valor);
                        System.out.println("BRL: " + valorBRLtoCLP);
                        break;
                    case 8:
                        double valorCOPtoBRL = currencyRates.convertCOPToBRL(valor);
                        System.out.println("BRL: " + valorCOPtoBRL);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Certifique-se de fechar o scanner no final
        }
    }

}
