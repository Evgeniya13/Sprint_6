package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(Enclosed.class)
public class LionTests{

    @RunWith(Parameterized.class)
    public static class LionTestsParameterized {
        private final String sex;
        private final boolean hasMane;

        public LionTestsParameterized(String sex, boolean hasMane) {
            this.sex = sex;
            this.hasMane = hasMane;
        }

        @Parameterized.Parameters
        public static Object[][] getSexData() {
            return new Object[][] {
                    { "Самец", true},
                    { "Самка", false},
            };
        }
        Feline feline;

        @Test
        public void testDoesHaveMane() throws Exception {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static  class LionTestsSingle {

        @Mock
        Feline feline;

        @Test
        public void testGetKittens() throws Exception {
            Lion lion = new Lion("Самец", feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            int kittens = lion.getKittens();
            Assert.assertEquals(1, kittens);
        }

        @Test
        public void testGetFood() throws Exception {
            Lion lion = new Lion("Самец", feline);
            List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);
            List<String> food = lion.getFood();
            Assert.assertEquals(expectedList, food);
        }

        @Test
        public void testConstructorWithInvalidParameters() {
            Assert.assertThrows(Exception.class, () -> {new Lion("Неизвестное животное", feline);});
        }
    }
}