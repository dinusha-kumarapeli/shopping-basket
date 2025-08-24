package org.example;

import java.util.List;

/**
 * A simple basket calculator for a grocery store.
 *
 * Supports the following pricing rules:
 *  - Apples: 35p each
 *  - Bananas: 20p each
 *  - Melons: 50p each, Buy One Get One Free
 *  - Limes: 15p each, 3 for the price of 2
 */
public class BasketCalculator {

    /**
     * Calculates the total price of all items in the basket.
     *
     * @param items a list of item names (e.g. "Apple", "Banana")
     * @return total cost in pence
     */
    public static int calculateTotal(List<String> items) {
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
                    // Unknown items are ignored
                    System.out.println("Ignoring unknown item: " + item);
            }
        }

        // Apply melon offer: Buy One Get One Free
        total += ((melonCount / 2) + (melonCount % 2)) * 50;

        // Apply lime offer: 3 for the price of 2
        total += (limeCount / 3) * 2 * 15 + (limeCount % 3) * 15;

        return total;
    }

}
