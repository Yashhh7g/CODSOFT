import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter base currency (INR, USD, EUR, GBP): ");
            String from = sc.next().toUpperCase();

            System.out.print("Enter target currency (INR, USD, EUR, GBP): ");
            String to = sc.next().toUpperCase();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            String apiUrl = "https://api.frankfurter.app/latest?from="
                    + from + "&to=" + to;

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // Extract exchange rate safely
            String json = response.toString();
            int index = json.indexOf(to);
            String ratePart = json.substring(index);
            String rateString = ratePart.split(":")[1]
                    .replace("}", "")
                    .trim();

            double rate = Double.parseDouble(rateString);
            double convertedAmount = amount * rate;

            System.out.println("\n===============================");
            System.out.println("Converted Amount: "
                    + convertedAmount + " " + to);
            System.out.println("===============================");

        } catch (Exception e) {
            System.out.println("❌ Error occurred!");
            System.out.println("Check currency code or internet.");
        }

        sc.close();
    }
}
