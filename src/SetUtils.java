import collections.map.KeyNotFoundException;
import collections.map.Map;
import collections.map.HashMap;
import collections.set.Set;
import collections.set.SimpleSet;

public class SetUtils {

    private SetUtils() {
    }

    public static <T> Set<T> intersection(Set<Set<T>> sets) {
        // TODO
        Map<T, Integer> elementCount = countElements(sets);
        Set<T> keys = elementCount.keys();
        Set<T> result = new SimpleSet<>(keys.size());

        keys.reset();

        while (keys.hasNext()) {
            T key = keys.next();

            if (elementCount.get(key) == sets.size()) {
                result.add(key);
            }
        }

        return result;
    }

    private static <T> Map<T, Integer> countElements(Set<Set<T>> sets) {
        Map<T, Integer> elementCount = new HashMap<>();

        sets.reset();

        while (sets.hasNext()) {
            Set<T> set = sets.next();

            set.reset();

            while (set.hasNext()) {
                T element = set.next();

                try {
                    Integer count = elementCount.get(element);

                    count++;

                    elementCount.put(element, count);
                } catch (KeyNotFoundException exception) {
                    elementCount.put(element, 1);
                }
            }
        }

        return elementCount;
    }

}
