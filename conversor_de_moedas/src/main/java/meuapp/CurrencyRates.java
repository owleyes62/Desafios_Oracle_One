package meuapp;

import com.google.gson.JsonObject;

public class CurrencyRates {
    private JsonObject rates;

    public CurrencyRates(JsonObject jsonObject) {
        this.rates = jsonObject.getAsJsonObject("rates");
    }

    public double getARSRate() {
        return rates.get("ARS").getAsDouble();
    }

    public double getBOBRate() {
        return rates.get("BOB").getAsDouble();
    }

    public double getCLPRate() {
        return rates.get("CLP").getAsDouble();
    }

    public double getCOPRate() {
        return rates.get("COP").getAsDouble();
    }


    public double convertBRLToARS(double amount) {
        double brlRate = rates.get("BRL").getAsDouble();
        double arsRate = rates.get("ARS").getAsDouble();
        return amount / brlRate * arsRate;
    }

    public double convertBRLToCOP(double amount) {
        double brlRate = rates.get("BRL").getAsDouble();
        double copRate = rates.get("COP").getAsDouble();
        return amount / brlRate * copRate;
    }

    public double convertBRLToCLP(double amount) {
        double brlRate = rates.get("BRL").getAsDouble();
        double clpRate = rates.get("CLP").getAsDouble();
        return amount / brlRate * clpRate;
    }

    public double convertARSToBRL(double amount) {
        double arsRate = rates.get("ARS").getAsDouble();
        double brlRate = rates.get("BRL").getAsDouble();
        return amount / arsRate * brlRate;
    }

    public double convertBOBToBRL(double amount) {
        double bobRate = rates.get("BOB").getAsDouble();
        double brlRate = rates.get("BRL").getAsDouble();
        return amount / bobRate * brlRate;
    }

    public double convertBRLToBOB(double amount) {
        double brlRate = rates.get("BRL").getAsDouble();
        double bobRate = rates.get("BOB").getAsDouble();
        return amount / brlRate * bobRate;
    }

    public double convertCLPToBRL(double amount) {
        double clpRate = rates.get("CLP").getAsDouble();
        double brlRate = rates.get("BRL").getAsDouble();
        return amount / clpRate * brlRate;
    }
    public double convertCOPToBRL(double amount) {
        double copRate = rates.get("COP").getAsDouble();
        double brlRate = rates.get("BRL").getAsDouble();
        return amount / copRate * brlRate;
    }
    public double convertUSDToBRL(double amount) {
        double usdRate = rates.get("USD").getAsDouble();
        double brlRate = rates.get("BRL").getAsDouble();
        return amount * usdRate / brlRate;
    }

    public double convertBRLToUSD(double amount) {
        double usdRate = rates.get("USD").getAsDouble();
        double brlRate = rates.get("BRL").getAsDouble();
        return amount / usdRate * brlRate;
    }
}