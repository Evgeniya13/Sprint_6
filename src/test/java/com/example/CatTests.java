package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class CatTests {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> food = cat.getFood();
        Assert.assertEquals("Животные", food.get(0));
        Assert.assertEquals("Птицы", food.get(1));
        Assert.assertEquals("Рыба", food.get(2));
    }
}
