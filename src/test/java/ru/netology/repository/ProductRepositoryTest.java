package ru.netology.repository;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book coreJava = new Book(1,"booki",1000,"vfi");
    @Test
    void shouldSaveOneItem(){
        repository.save(coreJava);
        Product [] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

}