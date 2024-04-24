package meuapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExchangeRateApiExample {

    public static void main(String[] args) {
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

            // Acessando os valores das moedas e imprimindo
            System.out.println("ARS: " + currencyRates.getARSRate());
            System.out.println("BOB: " + currencyRates.getBOBRate());
            System.out.println("BRL: " + currencyRates.getBRLRate());
            System.out.println("CLP: " + currencyRates.getCLPRate());
            System.out.println("COP: " + currencyRates.getCOPRate());
            System.out.println("USD: " + currencyRates.getUSDRate());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
