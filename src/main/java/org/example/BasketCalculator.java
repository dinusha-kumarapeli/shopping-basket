package org.example;

import java.util.List;

public class BasketCalculator {

    public int calculateTotal(List<String> items) {
        int total = 0;
        int melonCount = 0;
        int limeCount = 0;

        for (String item : items) {
            switch (item.toLowerCase()) {
                case "apple":
                    total += 35;
                    break;
                case "banana":
                    total += 20;
                    break;
                case "melon":
                    melonCount++;
                    break;
                case "lime":
                    limeCount++;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item: " + item);
            }
        }

        // Melons are buy one get one free
        total += (melonCount / 2 + melonCount % 2) * 50;

        // Limes are three for the price of two
        total += ((limeCount / 3) * 2 + limeCount % 3) * 15;

        return total;
    }
}
