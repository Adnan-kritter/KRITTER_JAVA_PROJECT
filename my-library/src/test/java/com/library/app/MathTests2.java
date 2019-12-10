package com.library.app;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public final class MathTests2 {
    private Math math;

    @BeforeMethod
    public void setUp() {
        math = new Math();
    }

    @Test
    public void add_TwoPlusTwo_ReturnsFour() {
        final int expected = 4;

        final int actual = math.add(2, 2);

        assertEquals(actual, expected);
    }

    @Test
    public void divide_TenDividedByFive_ReturnsTwo() {
        final double expected = 2.0;

        final double actual = math.divide(10, 5);

        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        math = null;
    }
}