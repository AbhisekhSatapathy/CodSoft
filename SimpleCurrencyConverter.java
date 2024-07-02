import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SimpleCurrencyConverter
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Specify the base currency as INR and target currency as USD
        String baseCurrency = "INR";
        String targetCurrency = "USD";

        // Step 2: Fetch real-time exchange rates from INR to USD
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        if (exchangeRate == -1)
        {
            System.out.println("Failed to fetch exchange rate. Exiting.");
            return;
        }

        // Step 3: Take input from user for the amount in INR
        System.out.print("Enter the amount in INR to convert to USD: ");
        double amountINR = scanner.nextDouble();

        // Step 4: Convert the currency
        double convertedAmountUSD = amountINR / exchangeRate;

        // Step 5: Display result
        System.out.printf("%.2f %s = %.2f %s%n", amountINR, baseCurrency, convertedAmountUSD, targetCurrency);

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try
        {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = reader.readLine();
            reader.close();

            // Parse JSON response
            int startIndex = line.indexOf("\"" + targetCurrency + "\":") + 5 + targetCurrency.length();
            int endIndex = line.indexOf(",", startIndex);
            String exchangeRateStr = line.substring(startIndex, endIndex);

            return Double.parseDouble(exchangeRateStr);
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
            return -1; // Return -1 to indicate failure
        }
    }
}
