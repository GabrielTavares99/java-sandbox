package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocket {

    public ClientSocket() {
        SocketUtils socketUtils = new SocketUtils();

        try {
            Socket localhost = new Socket("localhost", 15678);
            Thread.sleep(2000);
            socketUtils.read(localhost.getInputStream());

            OutputStream outputStream = localhost.getOutputStream();
            socketUtils.write(outputStream, "sucesso");
            localhost.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ClientSocket();
    }
}
