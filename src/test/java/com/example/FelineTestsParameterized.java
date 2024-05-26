package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineTestsParameterized {
    private final int numberOfKittens;
    private final int expected;

    public FelineTestsParameterized(int numberOfKittens, int expected) {
        this.numberOfKittens = numberOfKittens;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][] {
                { 1, 1},
                { 5, 5},
        };
    }

    @Test
    public void testGetKitten() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(numberOfKittens);
        Assert.assertEquals(expected, kittens);
    }
}

