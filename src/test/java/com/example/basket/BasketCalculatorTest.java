package com.example.basket;

import org.example.BasketCalculator;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link BasketCalculator}.
 *
 * Covers:
 *  - Individual items
 *  - Special offers (melons and limes)
 *  - Mixed baskets
 *  - Edge cases (empty basket, unknown items)
 */
public class BasketCalculatorTest {

    @Test
    void appleShouldCost35p() {
        assertEquals(35, BasketCalculator.calculateTotal(List.of("Apple")));
    }

    @Test
    void bananasShouldCost20pEach() {
        assertEquals(40, BasketCalculator.calculateTotal(List.of("Banana", "Banana")));
    }

    @Test
    void melonsShouldBeBuyOneGetOneFree() {
        assertEquals(50, BasketCalculator.calculateTotal(List.of("Melon", "Melon"))); // 2 for 1
        assertEquals(100, BasketCalculator.calculateTotal(List.of("Melon", "Melon", "Melon"))); // 3 for 2
    }

    @Test
    void limesShouldBeThreeForTwo() {
        assertEquals(30, BasketCalculator.calculateTotal(List.of("Lime", "Lime", "Lime"))); // 3 for 2
        assertEquals(45, BasketCalculator.calculateTotal(List.of("Lime", "Lime", "Lime", "Lime"))); // 4 for 3
    }

    @Test
    void mixedBasketShouldApplyAllRules() {
        // 2 Apples = 70p
        // 1 Banana = 20p
        // 3 Melons = 100p (Buy One Get One)
        // 4 Limes = 45p (3 for 2)
        // Total = 235p
        int total = BasketCalculator.calculateTotal(
                List.of("Apple", "Apple", "Banana",
                        "Melon", "Melon", "Melon",
                        "Lime", "Lime", "Lime", "Lime")
        );
        assertEquals(235, total);
    }

    @Test
    void emptyBasketShouldCostZero() {
        assertEquals(0, BasketCalculator.calculateTotal(List.of()));
    }

    @Test
    void unknownItemsShouldBeIgnored() {
        // "Orange" is ignored, only Apple counts (35p)
        assertEquals(35, BasketCalculator.calculateTotal(List.of("Apple", "Orange")));
    }
}
