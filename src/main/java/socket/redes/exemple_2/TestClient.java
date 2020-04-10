package socket.redes.exemple_2;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) throws IOException {

        String url = "google.com";
        String path = "";
        String method = "GET";
        String params = "";

        ClientSocket clientSocket = new ClientSocket(url, path, method, params);
        clientSocket.doRequest();
    }
}
