
import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class DiffTest {

    private String expectedStylish;
    private String expectedPlain;
    private String expectedJson;

    @BeforeEach
    public void beforeEach() throws IOException {
        expectedStylish = Files.readString(Paths.get("src/test/resources/stylish"));
        expectedPlain = Files.readString(Paths.get("src/test/resources/plain"));
        expectedJson = Files.readString(Paths.get("src/test/resources/json.json"));
    }

    @Test
    public void stylishJsonTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.json",
                    "src/test/resources/file2.json", "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void stylishYamlTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.yaml",
                    "src/test/resources/file2.yaml", "stylish");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void plainJsonTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.json",
                    "src/test/resources/file2.json", "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void plainYamlTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.yaml",
                    "src/test/resources/file2.yaml", "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void jsonJsonTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.json",
               "src/test/resources/file2.json", "json");
        actual = actual.replace("\r", "");
        assertEquals(expectedJson, actual);
    }

    @Test
    public void jsonYamlTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.yaml",
                    "src/test/resources/file2.yaml", "json");
        actual = actual.replace("\r", "");
        assertEquals(expectedJson, actual);
    }

    @Test
    public void generateDefaultJsonTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        assertEquals(expectedStylish, actual);
    }

    @Test
    public void generateYamlJsonTest() throws Exception {
        String actual = Differ.generate("src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml");
        assertEquals(expectedStylish, actual);
    }


}

