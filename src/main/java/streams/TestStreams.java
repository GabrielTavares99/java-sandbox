package streams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStreams {

    public static void main(String[] args) throws IOException {

        StreamManager streamManager = new StreamManager();

        File file = new File("/tmp/simple-file.txt");
        List<String> lines = new ArrayList<>(Arrays.asList("Whats your name", "My name is Gabriel"));
        streamManager.writeLines(file, lines);


    }

}
