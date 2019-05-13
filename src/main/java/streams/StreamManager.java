package streams;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamManager {


    public void writeLines(File file, List<String> lines) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : lines
        ) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public void appendLines(File file, List<String> lines) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : lines
        ) {
            fileWriter.append(line);
            fileWriter.append("\n");
        }
        fileWriter.close();
    }

    public List<String> readLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        int r;
        StringBuilder stringBuilder = new StringBuilder();
        while ((r = fileReader.read()) != -1) {
            char i = (char) (r);
            if (i == '\n') {
                lines.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else
                stringBuilder.append(i);
        }
        fileReader.close();
        return lines;
    }

}
