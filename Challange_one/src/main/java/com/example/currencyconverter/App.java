package main.java.com.example.currencyconverter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        // Configura HttpClient
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://api.exchangerate-api.com/v4/latest"; // URL base, asegúrate de usar una válida
        String baseCurrency = "USD"; // Moneda base para la solicitud
        String symbols = "ARS,BOB,BRL"; // Símbolos de las monedas de destino
        String query = "?base=" + baseCurrency + "&symbols=" + symbols;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + query))
                .build();

        // Envía la solicitud y obtén la respuesta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Respuesta de la API:");
            System.out.println(response.body());

            // Convierte la respuesta JSON a objetos Java usando Gson
            Gson gson = new Gson();
            ExchangeRates rates = gson.fromJson(response.body(), ExchangeRates.class);

            // Ejemplo de interacción con el usuario
            interactuarConUsuario(rates);

        } catch (Exception e) {
            System.err.println("Error al realizar la solicitud HTTP: " + e.getMessage());
        }
    }

    // Clase para mapear la respuesta JSON
    static class ExchangeRates {
        private String base;
        private String date;
        private Rates rates;

        // Getters y Setters
        // toString, etc.
    }

    // Clase interna para mapear el objeto de tasas de cambio
    static class Rates {
        private double ARS;
        private double BOB;
        private double BRL;
        // Agrega más monedas según sea necesario

        // Getters y Setters
        // toString, etc.
    }

    // Método para interactuar con el usuario
    private static void interactuarConUsuario(ExchangeRates rates) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.println("Tasas de cambio disponibles:");
        System.out.println("ARS: " + rates.getRates().getARS());
        System.out.println("BOB: " + rates.getRates().getBOB());
        System.out.println("BRL: " + rates.getRates().getBRL());
        // Agrega más monedas según sea necesario

        System.out.print("Ingrese el monto en USD a convertir: ");
        double amount = scanner.nextDouble();

        System.out.print("Ingrese el código de la moneda destino (ARS, BOB, BRL): ");
        String currencyCode = scanner.next();

        // Realiza la conversión
        double convertedAmount = convertCurrency(amount, currencyCode, rates);

        System.out.println("El monto convertido es: " + convertedAmount + " " + currencyCode);

        scanner.close();
    }

    // Método para realizar la conversión de moneda
    private static double convertCurrency(double amount, String currencyCode, ExchangeRates rates) {
        double rate = 0.0;

        switch (currencyCode) {
            case "ARS":
                rate = rates.getRates().getARS();
                break;
            case "BOB":
                rate = rates.getRates().getBOB();
                break;
            case "BRL":
                rate = rates.getRates().getBRL();
                break;
            // Agrega más casos según sea necesario

            default:
                System.out.println("Moneda no soportada.");
        }

        return amount * rate;
    }
}
