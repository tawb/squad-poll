package flyweight;

import java.util.HashMap;
import java.util.Map;

public class IconFactory {
    private static final Map<String, Icon> POOL = new HashMap<>();

    public static Icon get(String symbol) {
        return POOL.computeIfAbsent(symbol, Icon::new);//check if symbol is already a key in the map.
        // If it is just return the existing value
        // If it's not there yet create a new one
    }

    public static int poolSize() {
        return POOL.size();
    }
}