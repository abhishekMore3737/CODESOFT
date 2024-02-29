package com;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter{

    public static void main(String[] args) {
        try {
            // Step 1: Allow the user to choose base and target currency
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter base currency (e.g., USD): ");
            String baseCurrency = reader.readLine().toUpperCase();
            System.out.print("Enter target currency (e.g., EUR): ");
            String targetCurrency = reader.readLine().toUpperCase();

            // Step 2: Fetch real-time exchange rates from a reliable API
            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

            if (exchangeRate == -1) {
                System.out.println("Failed to fetch exchange rate. Please try again later.");
                return;
            }

            // Step 3: Take input from the user for the amount they want to convert
            System.out.print("Enter amount to convert: ");
            double amount = Double.parseDouble(reader.readLine());

            // Step 4: Convert the input amount from base currency to target currency
            double convertedAmount = amount * exchangeRate;

            // Step 5: Display the result to the user
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = in.readLine();
                in.close();

                // Parse JSON response to get the exchange rate for the target currency
                String[] parts = response.split("\"" + targetCurrency + "\":");
                if (parts.length > 1) {
                    String rateStr = parts[1].split(",")[0];
                    return Double.parseDouble(rateStr);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to fetch exchange rate: " + e.getMessage());
        }
        return -1; // Indicates failure
    }
}
