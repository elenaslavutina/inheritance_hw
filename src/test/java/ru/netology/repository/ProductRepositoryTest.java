package ru.netology.repository;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book coreJava = new Book(1,"booki",1000,"vfi");
    private Book[] listOfBooks = new Book[]{
            new Book(1, "The rich boy", 1010, "F.S.Fitzgerald"),
            new Book(2, "Three man on the bummel", 900, "Jerome K.Jerome"),
            new Book(3, "Three man in a boat", 890, "Jerome K.Jerome"),
            new Book(4, "Winter dreams", 1000, "F.S.Fitzgerald"),
            new Book(5, "The great Gatsby", 900, "F.S.Fitzgerald"),
            new Book(6, "Ninteen eighty-four", 897, "Orwell"),
            new Book(7, "The adventures of Tom Soyer", 1200, "Mark Twain"),
            new Book(8, "The Law of Life", 190, "Jack London"),
            new Book(9, "White Fang", 670, "Jack London"),
            new Book(10, "The adventures of Heckleberry Finn", 120, "Mark Twain"),
            new Book(11, "Life of the Mississippi", 350, "Mark Twain")
    };
    @Test
    void shouldSaveOneItem(){
        repository.save(coreJava);
        Product [] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        for (int i = 0; i < listOfBooks.length; i++) {
            repository.save(listOfBooks[i]);
        }
        int idToRemove = 5;
        repository.removeById(idToRemove);

        Product[] expected = new Product[]{
                new Book(1, "The rich boy", 1010, "F.S.Fitzgerald"),
                new Book(2, "Three man on the bummel", 900, "Jerome K.Jerome"),
                new Book(3, "Three man in a boat", 890, "Jerome K.Jerome"),
                new Book(4, "Winter dreams", 1000, "F.S.Fitzgerald"),
                new Book(6, "Ninteen eighty-four", 897, "Orwell"),
                new Book(7, "The adventures of Tom Soyer", 1200, "Mark Twain"),
                new Book(8, "The Law of Life", 190, "Jack London"),
                new Book(9, "White Fang", 670, "Jack London"),
                new Book(10, "The adventures of Heckleberry Finn", 120, "Mark Twain"),
                new Book(11, "Life of the Mississippi", 350, "Mark Twain")
        };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

}