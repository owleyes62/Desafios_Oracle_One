package meuapp;

import com.google.gson.JsonObject;

public class CurrencyRates {
    private JsonObject rates;

    public CurrencyRates(JsonObject jsonObject) {
        this.rates = jsonObject.getAsJsonObject("rates");
    }

    // Métodos para obter as taxas de câmbio de cada moeda
    public double getARSRate() {
        return rates.get("ARS").getAsDouble();
    }

    public double getBOBRate() {
        return rates.get("BOB").getAsDouble();
    }

    public double getBRLRate() {
        return rates.get("BRL").getAsDouble();
    }

    public double getCLPRate() {
        return rates.get("CLP").getAsDouble();
    }

    public double getCOPRate() {
        return rates.get("COP").getAsDouble();
    }

    public double getUSDRate() {
        return rates.get("USD").getAsDouble();
    }

    // Métodos para realizar as conversões entre moedas
    public double convertToARS(double amount) {
        return amount * getARSRate();
    }

    public double convertToBOB(double amount) {
        return amount * getBOBRate();
    }

    public double convertToBRL(double amount) {
        return amount * getBRLRate();
    }

    public double convertToCLP(double amount) {
        return amount * getCLPRate();
    }

    public double convertToCOP(double amount) {
        return amount * getCOPRate();
    }

    // Método para converter de uma moeda para outra qualquer
    public double convertToCurrency(double amount, double targetRate) {
        return amount * targetRate;
    }
}
