package com.marco.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {
    // fields
    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    private static class GreenAnd160WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return "green".equals(apple.getColor()) && apple.getWeight() >= 160;
        }
    }

    private static class YellowLess150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return "yellow".equals(apple.getColor()) && apple.getWeight() < 150;
        }
    }

    // methods
    public static List<Apple> findApples(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple: apples) {
            if (appleFilter.filter(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150),
                                            new Apple("yellow", 120),
                                            new Apple("green", 170));

        //List<Apple> greenApples = findGreenApple(list);
        //assert greenApples.size() == 2 : "error";

        //List<Apple> greenApples = findApple(list, "green");
        //System.out.println(greenApples);

        //List<Apple> yellowApples = findApple(list, "yellow");
        //System.out.println(yellowApples);

        //List<Apple> greenApples = findApples(list, new GreenAnd160WeightFilter());
        //System.out.println(greenApples);

        //List<Apple> yellowApples = findApples(list, new YellowLess150WeightFilter());
        //System.out.println(yellowApples);

        /*List<Apple> greenApples = findApples(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
        System.out.println(greenApples);*/

        List<Apple> lambdaResult = findApples(list, (apple) -> {
            return apple.getColor().equals("green");
        });
        System.out.println(lambdaResult);
    }
}
