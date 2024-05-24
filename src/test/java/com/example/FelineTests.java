package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;


@RunWith(Enclosed.class)
public class FelineTests {

    @RunWith(Parameterized.class)
    public static class FelineTestsParameterized {
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


    public static class FelineTestsSingle {

        @Test
        public void testEatMeat() throws Exception {
            Feline feline = new Feline();
            List<String> food = feline.eatMeat();
            List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
            Assert.assertEquals(expectedList, food);
        }

        @Test
        public void testGetFamily() {
            Feline feline = new Feline();
            Assert.assertEquals("Кошачьи", feline.getFamily());
        }

        @Test
        public void testGetKittens() {
            Feline feline = new Feline();
            int kittens = feline.getKittens();
            Assert.assertEquals(1, kittens);
        }
    }
}