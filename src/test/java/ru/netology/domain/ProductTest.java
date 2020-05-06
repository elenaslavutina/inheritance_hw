package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product[] list_of_products = new Product[]{
            new Product(1, "The rich boy", 1010),
            new Product(2, "Three man on the bummel ", 900),
            new Product(3, "Three man in a boat ", 890),
            new Product(4, "The Law of Life", 1000),
            new Product(5, "The great Gatsby", 900),
            new Product(6, "Ninteen eighty-four", 897),
            new Product(7, "The adventures of Tom Soyer", 1200),
            new Product(8, "The Law of Life", 190),
            new Product(9, "White Fang", 670),
            new Product(10, "The adventures of Heckleberry Finn", 120),
            new Product(11, "Life of the Mississippi", 350),
            new Product(1, "Galaxy 10", 25000),
            new Product(1, "Galaxy 8", 20000),
            new Product(1, "Galaxy 10", 21000),
            new Product(1, "iPhone 6", 25000),
            new Product(1, "iPhone 7", 25000),
            new Product(1, "12345", 15000),
            new Product(1, "123410", 13000),

    };

    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        assertEquals(first, second);
    }

    @Test
    public void shouldFindIfNameExist() {
        String text = "The Law of Life";
        int count = 2;
        int index = 0;
        for (Product product : list_of_products) {
            if (product.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    }

    @Test
    public void shouldNotFindIfNameNotExist() {
        String text = "Dandelion wine";
        int count = 0;
        int index = 0;
        for (Product product : list_of_products) {
            if (product.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    }


}