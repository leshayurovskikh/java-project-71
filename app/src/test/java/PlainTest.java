import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlainTest {
    private static String expected;

    @BeforeAll
    static void init() throws IOException {
        String expectedFile = "src/test/resources/expectedPlain.txt";
        expected = Files.readString(Paths.get(expectedFile));
    }

    @Test
    void jsonTest() throws Exception {
        String file1 = "src/main/resources/file1.json";
        String file2 = "src/main/resources/file2.json";
        assertThat(Differ.generate(file1, file2, "plain"))
                .isEqualTo(expected);
    }

}
