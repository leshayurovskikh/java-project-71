package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.json;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> compareResult, String format)
            throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.stylishResult(compareResult);
            case "plain" -> Plain.plainResult(compareResult);
            case "json" -> json.jsonResult(compareResult);
            default -> throw new Exception("This format is unknown: " + format);
        };
    }
}
