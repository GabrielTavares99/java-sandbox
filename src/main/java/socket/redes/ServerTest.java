package socket.redes;

import java.io.IOException;
import java.util.Random;

public class ServerTest {
    public static void main(String[] args) {
        int serverPort = 0;
        SocketStorageServer socketStorageServer = null;
        try {
            int i = new Random().nextInt(1000);
            socketStorageServer = new SocketStorageServer("server-top" + i);
            serverPort = socketStorageServer.startServer();
            socketStorageServer.startReceivingFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socketStorageServer.shutdownServer();
    }
}
