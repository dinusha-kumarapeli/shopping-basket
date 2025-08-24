package com.example.basket;

import org.example.BasketCalculator;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasketCalculatorTest {

    private final BasketCalculator calculator = new BasketCalculator();

    @Test
    void emptyBasketShouldCostZero() {
        assertEquals(0, calculator.calculateTotal(Collections.emptyList()));
    }

    @Test
    void singleAppleShouldCost35p() {
        assertEquals(35, calculator.calculateTotal(Arrays.asList("Apple")));
    }

    @Test
    void appleAndBananaTogetherShouldAddUp() {
        assertEquals(55, calculator.calculateTotal(Arrays.asList("Apple", "Banana")));
    }

    @Test
    void twoMelonsShouldCost50pBecauseOfBogof() {
        assertEquals(50, calculator.calculateTotal(Arrays.asList("Melon", "Melon")));
    }

    @Test
    void threeMelonsShouldCost100p() {
        assertEquals(100, calculator.calculateTotal(Arrays.asList("Melon", "Melon", "Melon")));
    }

    @Test
    void threeLimesShouldCost30pBecauseOfThreeForTwoOffer() {
        assertEquals(30, calculator.calculateTotal(Arrays.asList("Lime", "Lime", "Lime")));
    }

    @Test
    void fiveLimesShouldCost75p() {
        assertEquals(75, calculator.calculateTotal(Arrays.asList("Lime", "Lime", "Lime", "Lime", "Lime")));
    }

    @Test
    void mixedBasketShouldApplyAllOffers() {
        // Apple (35) + Banana (20) + two Melons (50) + three Limes (30) = 135p
        assertEquals(135, calculator.calculateTotal(
                Arrays.asList("Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime")));
    }

    @Test
    void unknownItemShouldThrowError() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateTotal(List.of("Chocolate")));
    }
}
