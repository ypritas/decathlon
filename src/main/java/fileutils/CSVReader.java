package fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader implements DecathlonDataReader {

    public List<List<String>> loadFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            Stream<String> lines = Files.lines(file.toPath());
            return lines.map(line -> Arrays.asList(line.split(";")))
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            throw new IOException("Failed to read data file " + fileName);
        }
    }

}
