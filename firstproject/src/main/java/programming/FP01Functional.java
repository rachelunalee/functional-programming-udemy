
package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }


    private static void printAllNumbersInListStructured(List<Integer> numbers) {

        numbers.stream().forEach(System.out::println);
    }
}
