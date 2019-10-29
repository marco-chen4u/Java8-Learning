package com.marco.java8;

public class ComplexApple extends Apple{
    private String name;

    public ComplexApple(String color, long weight, String name) {
        super(color, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "color='" + getColor() + '\'' +
                ", weight=" + getWeight() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
