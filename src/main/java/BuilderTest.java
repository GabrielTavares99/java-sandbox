import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BuilderTest {
    public static void main(String[] args) throws Exception {

        sendPost();
        System.out.println("OLA XUXU");
        EmailBuilder gabriel = EmailBuilder.builder()
                .html("<hmtl></hmtl>")
                .build();
        System.out.println(gabriel);

    }


    private static void sendPost() throws Exception {

        // url is missing?
        //String url = "https://selfsolve.apple.com/wcResults.do";
        String url = "https://preview.documentodoestudante.com.br/homolog/preview/generate-scholarity_document";

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        //add reuqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Content-Type", "application/json");
        httpClient.setRequestProperty("X-Auth-Token", "");

        String urlParameters = "{ \"items\": [ { \"label\": \"Nome\", \"value\": \"Gabs Tozera 2\" } ],  \"orderId\": 1230433 }";
        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("Sending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //print result
            System.out.println(response.toString());

        }

    }

}
