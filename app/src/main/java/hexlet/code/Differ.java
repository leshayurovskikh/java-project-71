package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = readFile (filepath1);
        String content2 = readFile (filepath2);

        String fileFormat1 = getFileType (filepath1);
        String fileFormat2 = getFileType (filepath2);

       Map<String, Object> file1 = Parser.parse (content1, fileFormat1);
       Map<String, Object> file2 = Parser.parse (content2, fileFormat2);

        List<Map<String, Object>> compareResult = Comparator.compare (file1,file2);

        return Formatter.format (compareResult);

    }

public static String readFile(String filepath) throws Exception {
    Path path = Paths.get(filepath).toAbsolutePath().normalize();
    if (!Files.exists(path)) {
        throw new Exception("File '" + path + "' does not exist");
    }
    String content = Files.readString(path);
    return content;
}

    private static String getFileType(String filepath) {
        var type = filepath.substring(filepath.lastIndexOf(".") + 1);
        return type;
    }

}
