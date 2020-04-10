package socket.redes.exemple_2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket {

    private final String url;
    private final String path;
    private final String method;
    private final String params;

    public ClientSocket(String url, String path, String method, String params) {
        this.url = url;
        this.path = path;
        this.method = method;
        this.params = params;
    }

    public void doRequest() throws IOException {
        int port = 80;

        InetAddress byName = InetAddress.getByName(url);
        Socket socket = new Socket(byName, port);

        // Send headers
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), "UTF8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(String.format("%s %s HTTP/1.0rn", method, path));
        bufferedWriter.write(method + " " + path + " HTTP/1.0rn");
        bufferedWriter.write("Content-Length: " + params.length() + "rn");
        bufferedWriter.write("Content-Type: */*");
        bufferedWriter.write("rn");

//      SEND PARAMETERS
        bufferedWriter.write(params);
        bufferedWriter.flush();

        // Get response
        BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

        bufferedWriter.close();
        rd.close();
    }

}
