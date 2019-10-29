package com.marco.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        Comparator<Apple> colorComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple a, Apple b) {
                return b.getColor().compareTo(a.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        list.sort(colorComparator);

        Comparator<Apple> colorComparator2 = (a, b)->a.getColor().compareTo(b.getColor());
        Comparator<Apple> colorComparator3 = (o1, o2) -> {return (int)(o1.getWeight() - o2.getWeight());};

        Function<String, Integer> function  = (String s) -> s.length();

        Predicate<Apple> predicate = (Apple a) -> a.getColor().equals("green");
        Function<Apple, Boolean> function1 = (a) -> "green".equals(a.getColor());

        Supplier<Apple> supplier = Apple::new;
    }
}
