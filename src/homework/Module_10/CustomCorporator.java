package homework.Module_10;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class CustomComparator<K,V extends Comparable<V>> implements Comparator<K>
{
    private final Map<K, V> map;

    public CustomComparator(Map<K, V> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public int compare(K s1, K s2) {
        return map.get(s2).compareTo(map.get(s1));
    }
}
