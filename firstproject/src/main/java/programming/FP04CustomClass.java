package programming;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }


    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }


}

public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<Course> reviewScoreGreaterThan95Predicate
                = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate
                = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate
                = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList())
        );
        System.out.println(courses.stream()
                .max(comparingByNoOfStudentsAndNoOfReviews));
        System.out.println(courses.stream()
                .min(comparingByNoOfStudentsAndNoOfReviews));


        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );//use primitive method(maptoint) for primitives
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(
                                Course::getCategory,Collectors.counting()))
        );//count courses by category

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,Collectors.toList())))
        );
    }
}
