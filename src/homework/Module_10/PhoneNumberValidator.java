package homework.Module_10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PhoneNumberValidator {
    static final String regexNumFormat1 = "\\d{3}-\\d{3}-\\d{4}";
    static final String regexNumFormat2 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
    public static void readFile() {
        try (FileReader reader = new FileReader("file.txt")) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()){
                String number = scanner.nextLine();
                if(number.trim().matches(regexNumFormat1)||number.trim().matches(regexNumFormat2)){
                    System.out.println(number);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

