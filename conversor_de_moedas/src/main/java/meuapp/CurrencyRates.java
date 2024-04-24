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
}
