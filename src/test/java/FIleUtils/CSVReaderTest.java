package FIleUtils;

import FileUtils.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by p998tbd on 2016.12.13.
 */
public class CSVReaderTest {

    private File file;

    @Before
    public void setUp() {
        ClassLoader classLoader = getClass().getClassLoader();
        file  = new File(classLoader.getResource("testData.txt").getFile());
    }

    @Test
    public void loadFileTest() throws IOException {
        List<List<String>> result = new CSVReader().loadFile(file.getAbsolutePath().toString());
        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue(result.size() == 5);
        Assert.assertTrue(result.get(0).size() == 11);
    }
}
