package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

public class FelineTests {

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