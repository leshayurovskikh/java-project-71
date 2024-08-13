package hexlet.code;

import java.util.*;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        var keys = new TreeSet<> ( );
        keys.addAll (file1.keySet ( ));
        keys.addAll (file2.keySet ( ));
        List<Map<String, Object>> result = new ArrayList<> ( );
return result;
    }
}