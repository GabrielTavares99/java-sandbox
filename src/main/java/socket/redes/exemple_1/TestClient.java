package socket.redes.exemple_1;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) {

        ClassLoader classLoader = TestClient.class.getClassLoader();
        for (int i = 1; i <= 10; i++) {
            try {
//                String filePath = classLoader.getResource("meme-byte.jpg").getPath();
                String filePath;
                if (i % 2 == 0)
                    filePath = "/home/gabriel/Documents/piramide.jpg";
                else
                    filePath = "/home/gabriel/Documents/versao-com-referencias-800x600-thiago-v1.mp4";
                SocketStorageClient socket = new SocketStorageClient(String.valueOf(i), "localhost", 39975);
                socket.startConnection();
                socket.sendFile(filePath);
                socket.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
