package com.marco.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {
        /*Consumer<String> consumer = (s) -> System.out.println(s);
        useConsumer(consumer, "How are you doing?");

        useConsumer(s-> System.out.println(s), "I am doing great!");
        useConsumer(System.out::println, "How could I help you?");*/

        /*List<Apple> list = Arrays.asList(new Apple("green", 150),
                                            new Apple("yellow", 120),
                                            new Apple("purple", 170));
        System.out.println(list);
        System.out.println("sorting by color...");
        list.sort((a,b)->a.getColor().compareTo(b.getColor()));
        //list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);
        System.out.println("process by stream starting...");
        list.stream().forEach(System.out::println);
        System.out.println("process by stream done!");*/

        Integer value = Integer.valueOf("769");
        Function<String, Integer> function = Integer::valueOf;
        int result = function.apply("890");
        System.out.println(result);

        BiFunction<String, Integer, Character> function1 = String::charAt;
        Character ch = function1.apply("All things are difficult before they are easy", 2);
        System.out.println(ch);

        BiFunction<String, Long, Apple> appleBiFunction = Apple::new;//it will automatically locate the right constructor
        Apple apple = appleBiFunction.apply("Blue",784L);
        System.out.println(apple);

        TriFunction<String, Long, String, ComplexApple> triFunction = ComplexApple::new;
        ComplexApple complexApple = triFunction.apply("Red", 157L, "Fushi");
        System.out.println(complexApple);

        List<Apple> list2 = Arrays.asList(new Apple("green", 150),
                                            new Apple("yellow", 120),
                                            new Apple("purple", 170));
        System.out.println(list2);
        System.out.println("process sorting...");
        list2.sort(Comparator.comparing(Apple::getColor));// look into the source code if having time
        System.out.println(list2);
    }

    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
