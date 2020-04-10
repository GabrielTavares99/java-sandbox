package socket;

import java.io.*;

public class SocketUtils {


    public void read(InputStream inputStream) throws IOException {
        int key;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        while (inputStreamReader.ready()) {
            System.out.println((char) inputStreamReader.read());
        }
    }

    public void write(OutputStream outputStream, String line) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(line);
        outputStream.flush();
        outputStream.close();
    }
}
