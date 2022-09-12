package programming;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        filterAndPrint(numbers, x -> x % 2 == 0);
        filterAndPrint(numbers, x -> x % 2 != 0);

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);
        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);
        System.out.println(doubledNumbers);

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number < 10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(5, "in28minutes"));

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };
        System.out.println(biFunction.apply(15, "in28minutes"));

        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept(15, "in28minutes");

        //use primitive functional to deal with primitive operations to avoid
        //unnecessary boxing/unboxing

        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator


    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
                                                     Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
}
