
package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        printSquaresOfEvenNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printSquaresOfEvenNumbersInListStructured(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }
}
