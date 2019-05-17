package socket.redes.exemple_2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket {

    public static void main(String[] args) throws IOException {

        String url = "siga.cps.sp.gov.br";
        String path = "/";
        String method = "GET";
        String params = "";

        int port = 80;

        InetAddress byName = InetAddress.getByName(url);
        Socket socket = new Socket(byName, port);

        // Send headers
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), "UTF8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(String.format("%s %s HTTP/1.0rn", method, path));
        bufferedWriter.write("GET " + path + " HTTP/1.0rn");
        bufferedWriter.write("Content-Length: " + params.length() + "rn");
        bufferedWriter.write("Content-Type: application/x-www-form-urlencodedrn");
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
