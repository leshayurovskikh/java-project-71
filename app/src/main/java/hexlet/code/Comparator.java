package hexlet.code;

import java.util.*;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object> data1,
                                                    Map<String, Object> data2) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        Set<String> keysSet = new TreeSet<>(data1.keySet());
        keysSet.addAll(data2.keySet());

        for (String key: keysSet) {
            Map<String, Object> result = new LinkedHashMap<>();
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put("key", key);
                result.put("oldValue", data1.get(key));
                result.put("status", "removed");
            } else if (data2.containsKey(key) && !data1.containsKey(key)) {
                result.put("key", key);
                result.put("newValue", data2.get(key));
                result.put("status", "added");
            } else if (Objects.equals(data1.get(key), (data2.get(key)))) {
                result.put("key", key);
                result.put("oldValue", data1.get(key));
                result.put("newValue", data2.get(key));
                result.put("status", "unmodified");
            } else if (!Objects.equals(data1.get(key), (data2.get(key)))) {
                result.put("key", key);
                result.put("oldValue", data1.get(key));
                result.put("newValue", data2.get(key));
                result.put("status", "updated");
            } else {
                throw new RuntimeException("Unknown key: " + key);
            }
            resultList.add(result);
        }
        return resultList;
    }
    }