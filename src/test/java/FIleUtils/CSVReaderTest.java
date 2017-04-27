package FIleUtils;

import FileUtils.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CSVReaderTest {

    private File file;

    @Before
    public void setUp() {
        ClassLoader classLoader = getClass().getClassLoader();
        file  = new File(classLoader.getResource("testData.txt").getFile());
    }

    @Test
    public void loadFileTest() throws IOException {
        List<List<String>> result = new CSVReader().loadFile(file.getAbsolutePath());
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(5, result.size());
        Assert.assertEquals(11, result.get(0).size());
    }
}
