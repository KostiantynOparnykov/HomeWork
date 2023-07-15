package homework.Module_11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Peter", "Vasyl", "Andrey", "Zoltan", "Yuriy", "Oleg");
//1
        System.out.println(StreamMethods.unevenNamesParser(names)+"\n");
//2
        System.out.println(StreamMethods.oddStringFormatter(names)+"\n");
//3
        String[] array = {"1, 2, 0", "4, 5", "20, 10", "40, 35, 21, 23, 15"};
        System.out.println(StreamMethods.arraySortAndPrint(array)+"\n");
//4
//        Uncomment to run (endless stream output)
//        Stream<Long> newStream = StreamMethods.LCNumberGenerator(25214903917L, 11, 2 ^ 48, 2);
//        newStream.forEach(System.out::println);
//5
        Stream<String> first = Stream.of("FirstStream", "FirstStream", "FirstStream","FirstStream","FirstStream");
        Stream<String> second = Stream.of("SecondStream", "SecondStream", "SecondStream", "SecondStream", "SecondStream", "SecondStream");

        Stream<String> result = StreamMethods.zip(first, second);
        result.forEach(System.out::println);
    }

}

