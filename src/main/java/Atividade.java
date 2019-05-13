import java.io.*;

public class Atividade {
    public static void main(String[] args) throws IOException {

        File file = new File("/tmp/ordenado.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }

    }
}

