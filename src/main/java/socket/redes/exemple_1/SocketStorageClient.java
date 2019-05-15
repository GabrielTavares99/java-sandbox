package socket.redes.exemple_1;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class SocketStorageClient {

    private String id;
    private String serverIp;
    private int serverPort;
    private String sourceFilePath;
    private Socket socket;

    public SocketStorageClient(String id, String serverIp, int serverPort) {
        this.id = id;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
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

    public void sendFile(String sourceFilePath) throws IOException {
        System.out.println(String.format("ID:#%s - SENDING FILE TO THE SOCKET", id));

        File file = new File(sourceFilePath);
        CustomFile customFile = new CustomFile();
        customFile.setExtension(file.getName().split("\\.")[1]);
        customFile.setFilename(file.getName());
        customFile.setFileInBytes(Files.readAllBytes(new File(sourceFilePath).toPath()));

        File instanceFile = new File("/tmp/object-in-memory" + id);

        FileOutputStream fileOutputStream = new FileOutputStream(instanceFile.getAbsoluteFile());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(customFile);
        fileOutputStream.close();
        fileOutputStream.close();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(Files.readAllBytes(instanceFile.toPath()));
        outputStream.close();
        System.out.println(String.format("ID:#%s - SEND FILE COMPLETED", id));
    }


}
