package homework.Module_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {

    public static String unevenNamesParser(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + "." + names.get(i))
                .collect(Collectors.joining(", "));
    }
    public static List<String> oddStringFormatter(List<String> names){
        return names.stream().map(String::toUpperCase)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static String arraySortAndPrint(String[] numbers){
        return Arrays.stream(numbers)
                .flatMap(s -> Stream.of(s.split(", ")))
                .map(String::trim).map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

    }

    public static Stream<Long> LCNumberGenerator(long a, long c, long m, long seed){
        return Stream.iterate(seed, x->(a*x+c)%m);
    }

    public static <T> Stream<T> zip(Stream<T> firstStream, Stream<T> secondStream) {
        Iterator<T> iterator1 = firstStream.iterator();
        Iterator<T> iterator2 = secondStream.iterator();

        Stream.Builder<T> builder = Stream.builder();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            builder.add(iterator1.next());
            builder.add(iterator2.next());
        }
        return builder.build();
    }
}

