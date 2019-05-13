package socket.redes;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;

public class SocketStorageClient {

    private String id;
    private String serverIp;
    private int serverPort;
    private String sourceFilePath;
    private Socket socket;

    public SocketStorageClient(String id, String serverIp, int serverPort, String sourceFilePath) {
        this.id = id;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.sourceFilePath = sourceFilePath;
    }

    public void startConnection() throws IOException {
        System.out.println(String.format("ID:#%s - STARTING CONNECTION ON %s:%d", id, serverIp, serverPort));
        socket = new Socket(serverIp, serverPort);
        System.out.println("CONNECTION STARTED");
    }

    public void closeConnection() throws IOException {
        System.out.println(String.format("ID:#%s - CLOSSING CONNECTION, BECAUSE, WELINGTON SAYS " +
                "\"THE CLIENT CLOSE DE CONNECTION, NOT THE SERVER\"", id));
        socket.close();
    }

    public void sendFile() throws IOException {
        System.out.println(String.format("ID:#%s - SENDING FILE TO THE SOCKET", id));
        File file = new File(sourceFilePath);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(Files.readAllBytes(file.toPath()));
        outputStream.close();
        System.out.println(String.format("ID:#%s - SEND FILE COMPLETED", id));
    }


}
