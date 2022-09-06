
package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = addListStructured(numbers);
        System.out.println(sum);

        System.out.println(doubleList(numbers));

    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    private static int sum(int a, int b) {
        System.out.println(a + " " + b);
        return a + b;
    }

    private static int addListStructured(List<Integer> numbers) {
        return numbers.stream()
//                .reduce(0, FP02Functional::sum);
                .reduce(0, (x, y) -> x + y);

    }


}
