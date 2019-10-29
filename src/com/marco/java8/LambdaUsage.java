package com.marco.java8;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.*;

public class LambdaUsage {
    // fields
    private static ExecutorService threadPool;

    /*@FunctionalInterface
    interface Adder {
        int add(int a, int b);
    }

    // below is not a Functional Interface
    interface SmarterAdder extends Adder {
        int add(long a, long b);
    }

    @FunctionalInterface
    interface Nothing extends Adder {

    }*/

    public static void main(String[] args) {
        /*threadPool = Executors.newFixedThreadPool(10);

        Runnable r1 = () -> System.out.println("Hello World!");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola Amigo!");
            }
        };

        process(r1);
        process(r2);
        process(()->System.out.println("How are you doing?"));*/

        List<Apple> list = Arrays.asList(new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170));

        List<Apple> appleList = filter(list, (apple) -> "green".equals(apple.getColor()));
        System.out.println(appleList);

        List<Apple> appleList1 = filterByWeight(list, (weight) -> weight > 150);
        System.out.println(appleList1);

        List<Apple> appleList2 = filterByBiPredicate(list, (color, weight) -> "green".equals(color) && weight >= 170);
        System.out.println(appleList2);

        System.out.println("Simple Consumer processing------------------");
        testSimpleConsumer(list, apple -> System.out.println(apple));
        System.out.println("Simple Consumer finished--------------------");

        System.out.println("BiConsumer processing------------------");
        testBiConsumer(list, (apple, condition)-> System.out.println(condition + apple.getColor() + ", weight=>" + apple.getWeight()), "###");
        System.out.println("BiConsumer finished--------------------");

        String result = testFunction(new Apple("Red", 135), (apple) -> apple.toString());
        System.out.println(result);

        //Supplier<String> s = String::new;
        System.out.println("Supplier usage start-------------------");
        Apple purpleApple = createApple(() -> new Apple("Purple", 190));
        System.out.println(purpleApple);
        System.out.println("Supplier usage end---------------------");

        doFinalizedWork();
    }

    private static void doFinalizedWork() {
        if (threadPool != null && !threadPool.isShutdown()) {
            threadPool.shutdown();
        }
    }

    private static void process(Runnable runnable) {
        threadPool.submit(runnable);
    }

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : source) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }

        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }

        return result;
    }

    private static void testSimpleConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }

    private static void testBiConsumer(List<Apple> source, BiConsumer<Apple, String> consumer, String condition) {
        for (Apple apple : source) {
            consumer.accept(apple, condition);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }
}
