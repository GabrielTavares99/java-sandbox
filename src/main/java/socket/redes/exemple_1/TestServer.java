package socket.redes.exemple_1;

import java.io.IOException;
import java.util.Random;

public class TestServer {
    public static void main(String[] args) {
        int serverPort = 0;
        SocketStorageServer socketStorageServer = null;
        try {
            int i = new Random().nextInt(1000);
            socketStorageServer = new SocketStorageServer("server-top" + i);
            serverPort = socketStorageServer.startServer();
            socketStorageServer.startReceivingFiles();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        socketStorageServer.shutdownServer();
    }
}
