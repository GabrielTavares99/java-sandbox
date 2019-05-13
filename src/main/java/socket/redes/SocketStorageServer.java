package socket.redes;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class SocketStorageServer {

    private String id;
    private ServerSocket serverSocket;
    private String tempFolder;

    public SocketStorageServer(String id) {
        this.id = id;
        System.out.println("CREATING FOLDER TO REQUESTS");
        tempFolder = String.format("/tmp/%s", id);
        boolean newFile = new File(tempFolder).mkdirs();
        System.out.println(String.format("IS FOLDER CREATED? %b", newFile));
    }

    public void startReceivingFiles() throws IOException {
        int cont = 0;
        while (true) {
            System.out.println(String.format("CONNECTION #%d", ++cont));

            System.out.println("WAITING CONNECTION");
            Socket connection = serverSocket.accept();

            System.out.println("READING INPUT");
            InputStream inputStream = connection.getInputStream();
            File file = new File(String.format("%s/file-%d.png", tempFolder, cont));
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
            System.out.println("CLOSING INPUT CHANNEL");

            closeClientSocket(connection);
        }

    }

    private void closeClientSocket(Socket connection) throws IOException {
        System.out.println("CLOSING CONNECTION");
        connection.close();
    }

    public void shutdownServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int startServer() throws IOException {
        System.out.println("STARTING SERVER");
        serverSocket = new ServerSocket(39975);
        System.out.println("LISTING ON PORT:" + serverSocket.getLocalPort());
        return serverSocket.getLocalPort();
    }

}
