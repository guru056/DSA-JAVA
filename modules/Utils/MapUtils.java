package Utils;

import java.util.Map;

public class MapUtils {

    public static <K,V> void printMap(Map<K,V> map) {
        for (Map.Entry<K,V> entry: map.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            System.out.println(entry.getValue());

        }
    }
}
