package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        Assert.assertEquals("Животные", food.get(0));
        Assert.assertEquals("Птицы", food.get(1));
        Assert.assertEquals("Рыба", food.get(2));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetFamily2() {
        Feline feline = new Feline();
        Assert.assertNotEquals("sdfj", feline.getFamily());
    }

    @Test
    public void testGetKitten() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        Assert.assertEquals(1, kittens);

        kittens = feline.getKittens(1);
        Assert.assertEquals(1, kittens);

        kittens = feline.getKittens(5);
        Assert.assertEquals(5, kittens);
    }

}
