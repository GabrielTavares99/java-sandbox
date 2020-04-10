package filters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestFilter {
    public static void main(String[] args) throws IOException {

        FilterManager filterManager = new FilterManager();
        File source = new File("/tmp/source.txt");
        File target = new File("/tmp/target.txt");
        source.createNewFile();
        target.createNewFile();
        filterManager.copyFileContent(source, target);


        File sourceCSV = new File("/tmp/a.csv");
        List<String> lines = Arrays.asList("Antonio Rodrigues; 6,5", "Katia Toledo; 7,4", "Guilherme Prado; 4,6", "Brenno;9");
        filterManager.writeLines(sourceCSV, lines);

        List<String> oldLines = filterManager.readLines(sourceCSV);
        List<String> newLines = new ArrayList<>();
        oldLines.forEach(line -> {
            String[] split = line.split(";");
            double grade = Double.valueOf(split[1].replace(",", ".")) + 1.0;
            newLines.add(String.format("%s;%.1f", split[0], grade));
        });
        File targetCSV = new File("/tmp/b.csv");
        filterManager.writeLines(targetCSV, newLines);


        lines = filterManager.readLines(new File("/tmp/b.csv"));
        Collections.sort(lines);
        filterManager.writeLines(new File("/tmp/ordenado.csv"), lines);
    }
}
