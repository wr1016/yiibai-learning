package com.yiibai.rayit;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTester {

    public static void stream() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<String> filtered2 = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("filtered = " + filtered);
        System.out.println("filtered2 = " + filtered2);
    }

    public static void forEach() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    public static void map() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        System.out.println("squaresList = " + squaresList);
    }

    public static void filter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //get count of empty string
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count = " + count);
    }

    public static void limit() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    public static void sorted() {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    public static void collect() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }

    public static void statistics() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest  number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all  numbers : " + stats.getAverage());
    }

    public static void main(String[] args) {
        stream();
        forEach();
        map();
        filter();
        limit();
        sorted();
        collect();
        statistics();
    }

}
