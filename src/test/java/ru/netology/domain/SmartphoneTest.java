package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone[] list_of_phones = new Smartphone[]{
            new Smartphone(1, "Galaxy 10", 25000, "Samsung"),
            new Smartphone(2, "Galaxy 8", 20000, "Samsung"),
            new Smartphone(3, "Galaxy 9", 21000, "Samsung"),
            new Smartphone(4, "iPhone 6", 25000, "iPhone"),
            new Smartphone(5, "iPhone 7", 25000, "iPhone"),
            new Smartphone(6, "12345", 15000, "Huawei"),
            new Smartphone(7, "123410", 13000, "Huawei"),

    };

    @Test
    public void shouldFindIfCompanyExist() {
        String text = "Samsung";
        int count = 3;
        int index = 0;
        for (Smartphone phone : list_of_phones) {
            if (phone.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    };

    @Test
    public void shouldCallProductMatchesIfNameExist() {
        String text = "Galaxy 9";
        int count = 1;
        int index = 0;
        for (Smartphone phone : list_of_phones) {
            if (phone.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    };

    @Test
    public void shouldNotFindIfCompanyNotExist() {
        String text = "Nokia";
        int count = 0;
        int index = 0;
        for (Smartphone phone : list_of_phones) {
            if (phone.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    }
}
