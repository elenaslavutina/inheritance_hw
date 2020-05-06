package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book[] list_of_books2 = new Book[]{
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
    public void shouldFindIfAutorExist() {
        String text = "Jerome K.Jerome";
        int count = 2;
        int index = 0;
        for (Book book : list_of_books2) {
            if (book.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    };

    @Test
    public void shouldCallProductMatchesIfNameExist() {
        String text = "Three man on the bummel";
        int count = 1;
        int index = 0;
        for (Book book : list_of_books2) {
            if (book.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    }


    @Test
    public void shouldNotFindIfAutorNotExist() {
        String text = "Jules Verne";
        int count = 0;
        int index = 0;
        for (Book book : list_of_books2) {
            if (book.matches(text)) index++;
        }
        ;
        assertEquals(count, index);
    }

    ;


}
