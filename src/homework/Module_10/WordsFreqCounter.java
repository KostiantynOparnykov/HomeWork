package homework.Module_10;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordsFreqCounter {
    public static Map<String, Integer> words = new LinkedHashMap<>();
    public static void countFreq(){
        try{
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String word = scanner.next();
                if(!word.isEmpty()){
                    words.put(word, words.getOrDefault(word, 0)+1);
                }
            }
            scanner.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        words = sortByValues(words);
        words.forEach((K,V) -> System.out.println(K + " " + V));
    }
    public static <K, V> Map<K, V> sortByValues(Map<K, V> map)
    {
        Comparator<K> comparator = new CustomComparator(map);

        Map<K, V> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);

        return sortedMap;
    }
}
