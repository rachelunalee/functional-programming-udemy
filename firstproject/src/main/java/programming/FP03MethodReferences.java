package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {
    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");

        courses.stream()
//                .map(str -> str.toUpperCase())
                .map(String::toUpperCase)//Object reference
                .forEach(FP03MethodReferences::print);//Method reference

        Supplier<String> supplier = String::new; //Constructor reference
    }
}
