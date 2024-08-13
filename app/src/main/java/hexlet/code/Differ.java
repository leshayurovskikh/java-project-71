package hexlet.code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = readFile (filepath1);
        String content2 = readFile (filepath2);

        String fileFormat1 = getFileType (filepath1);
        String fileFormat2 = getFileType (filepath2);


        return "";
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
