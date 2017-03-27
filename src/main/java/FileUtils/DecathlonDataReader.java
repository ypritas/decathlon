package FileUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by p998tbd on 2016.12.13.
 */
public interface DecathlonDataReader {

    List<List<String>> loadFile(String fileName) throws IOException;
}
