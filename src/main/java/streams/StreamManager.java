package streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

}
