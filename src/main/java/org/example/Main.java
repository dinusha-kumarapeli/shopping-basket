package org.example;

import org.example.BasketCalculator;

import java.util.List;

/**
 * Entry point for demonstrating the BasketCalculator.
 *
 * This class is optional but provides a quick example
 * of how the calculator can be used without running tests.
 */
public class Main {
    public static void main(String[] args) {
        // Example basket
        List<String> basket = List.of(
                "Apple", "Apple", "Banana",
                "Melon", "Melon", "Melon",
                "Lime", "Lime", "Lime", "Lime"
        );

        // Calculate total
        int total = BasketCalculator.calculateTotal(basket);

        // Print result
        System.out.println("Basket: " + basket);
        System.out.printf("Total cost: %dp (£%.2f)%n", total, total / 100.0);
    }
}
