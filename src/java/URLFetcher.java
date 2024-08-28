
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
https://stackoverflow.com/questions/9349703/server-returned-http-response-code-400
 */
public class URLFetcher {

    public static void main(String[] args) throws Exception {
        String name = "n";
        name = URLEncoder.encode(name, "UTF-8");
        String url = "http://localhost:8080/SudapornWab/getFoodDataService/" + name;

        URL myURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder results = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            results.append(line);
        }

        connection.disconnect();
        System.out.println(results.toString());
    }
}
