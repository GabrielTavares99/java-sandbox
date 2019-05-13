package filters;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilterManager {

    private void readDecorators() throws IOException {
        File file = new File("/tmp/b.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);

    }

    private List<String> copyFileContent(BufferedReader bufferedReader) throws IOException {
        List<String> lines = new ArrayList<>();
        while (bufferedReader.ready()) {
            lines.add(bufferedReader.readLine());
        }
        return lines;
    }

    private void writeLines(BufferedWriter bufferedWriter, List<String> lines) throws IOException {
        for (String line : lines) {
            bufferedWriter.append(line);
            bufferedWriter.newLine();
        }
    }

    public void writeLines(File file, List<String> lines) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line : lines) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public List<String> readLines(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        while (bufferedReader.ready()) {
            lines.add(bufferedReader.readLine());
        }
        return lines;
    }

    public void copyFileContent(File source, File target) throws IOException {
        FileReader fileReader = new FileReader(source);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> readLines = copyFileContent(bufferedReader);
        bufferedReader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(target);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        writeLines(bufferedWriter, readLines);
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

}
