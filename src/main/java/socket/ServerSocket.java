package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerSocket {

    public ServerSocket() {
        try {
            SocketUtils socketUtils = new SocketUtils();
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(15678);
            Socket clientSocket = serverSocket.accept();

            OutputStream outputStream = clientSocket.getOutputStream();
            socketUtils.write(outputStream, "vc esta conectado");

            InputStream inputStream = clientSocket.getInputStream();
            socketUtils.read(inputStream);

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ServerSocket();
    }


}
