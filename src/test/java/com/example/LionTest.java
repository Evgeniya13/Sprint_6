package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion1 = new Lion("Самка");
        Assert.assertFalse(lion1.doesHaveMane());

        Lion lion2 = new Lion("Самец");
        Assert.assertTrue(lion2.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lion.getFood();
        Assert.assertEquals("Животные", food.get(0));
        Assert.assertEquals("Птицы", food.get(1));
        Assert.assertEquals("Рыба", food.get(2));
    }
    @Test

    public void testConstructorWithInvalidParameters() {
        String message= "";
        try {
            new Lion("Неизвестное животное");
        } catch (Exception e) {
            message = e.getMessage();
        }
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", message);
    }
}
