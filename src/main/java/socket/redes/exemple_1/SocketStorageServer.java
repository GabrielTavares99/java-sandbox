package socket.redes.exemple_1;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class SocketStorageServer {

    private String id;
    private ServerSocket serverSocket;
    private String tempFolder;
    private String instancesFolder;
    private String filesFolder;

    public SocketStorageServer(String id) {
        this.id = id;
        System.out.println("CREATING FOLDER TO REQUESTS");
        tempFolder = String.format("/tmp/%s", id);
        instancesFolder = String.format("%s/serialized-instances", tempFolder);
        filesFolder = String.format("%s/received-files", tempFolder);

        boolean newFile = new File(tempFolder).mkdirs();
        boolean newFile2 = new File(instancesFolder).mkdirs();
        boolean newFile3 = new File(filesFolder).mkdirs();
        System.out.println(String.format("IS FOLDER CREATED? %b", newFile));
    }

    public void startReceivingFiles() throws IOException, ClassNotFoundException {
        int cont = 0;
        while (true) {
            System.out.println(String.format("CONNECTION #%d", ++cont));

            System.out.println("WAITING CONNECTION");
            Socket connection = serverSocket.accept();

            String pathInstance = String.format("%s/instance-%d.instance", instancesFolder, cont);

            System.out.println("GETTING INPUT");
            InputStream inputStream = connection.getInputStream();

            System.out.println("DESERIALIZATION");
            File instanceFile = new File(pathInstance);

            Files.copy(inputStream, instanceFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            FileInputStream fileInputStream = new FileInputStream(instanceFile.getAbsoluteFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            CustomFile transferreddObject = (CustomFile) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            String pathFile = String.format("%s/file-%d.%s", filesFolder, cont, transferreddObject.getExtension());
            File targetFile = new File(pathFile);
            Files.copy(new ByteArrayInputStream(transferreddObject.getFileInBytes()), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            inputStream.close();
            System.out.println("CLOSING INPUT CHANNEL");

            Files.delete(instanceFile.toPath());
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
