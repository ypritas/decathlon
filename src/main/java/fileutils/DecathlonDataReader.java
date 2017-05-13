package fileutils;

import java.io.IOException;
import java.util.List;

public interface DecathlonDataReader {

    List<List<String>> loadFile(String fileName) throws IOException;
}
