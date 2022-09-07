
package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println(evenList(numbers));
    }

    private static List<Integer> evenList(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }


}
