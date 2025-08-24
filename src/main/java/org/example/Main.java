package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasketCalculator calculator = new BasketCalculator();

        List<String> basket1 = Arrays.asList("Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime");
        List<String> basket2 = Arrays.asList("Apple", "Apple", "Apple");
        List<String> basket3 = Arrays.asList("Melon", "Melon", "Melon", "Melon");
        List<String> basket4 = Arrays.asList("Lime", "Lime", "Lime", "Lime", "Lime");

        printBasketTotal(calculator, basket1);
        printBasketTotal(calculator, basket2);
        printBasketTotal(calculator, basket3);
        printBasketTotal(calculator, basket4);
    }

    private static void printBasketTotal(BasketCalculator calculator, List<String> basket) {
        int totalInPence = calculator.calculateTotal(basket);
        String formatted = String.format("£%.2f", totalInPence / 100.0);
        System.out.println("Basket: " + basket + " => Total: " + formatted);
    }
}
