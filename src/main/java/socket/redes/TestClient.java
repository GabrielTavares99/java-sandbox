package socket.redes;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) {

        ClassLoader classLoader = TestClient.class.getClassLoader();
        for (int i = 1; i <= 10; i++) {
            try {
//                String filePath = classLoader.getResource("meme-byte.jpg").getPath();
                String filePath = "/home/gabriel/Documents/piramide.jpg";
                SocketStorageClient socket = new SocketStorageClient(String.valueOf(i), "localhost", 39975, filePath);
                socket.startConnection();
                socket.sendFile();
                socket.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
