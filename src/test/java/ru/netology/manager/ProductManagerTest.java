package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book[] list_of_books = new Book[]{
            new Book(1, "The rich boy", 1010, "F.S.Fitzgerald"),
            new Book(2, "Three man on the bummel ", 900, "Jerome K.Jerome"),
            new Book(3, "Three man in a boat ", 890, "Jerome K.Jerome"),
            new Book(4, "Winter dreams ", 1000, "F.S.Fitzgerald"),
            new Book(5, "The great Gatsby", 900, "F.S.Fitzgerald"),
            new Book(6, "Ninteen eighty-four", 897, "Orwell"),
            new Book(7, "The adventures of Tom Soyer", 1200, "Mark Twain"),
            new Book(8, "The Law of Life", 190, "Jack London"),
            new Book(9, "White Fang", 670, "Jack London"),
            new Book(10, "The adventures of Heckleberry Finn", 120, "Mark Twain"),
            new Book(11, "Life of the Mississippi", 350, "Mark Twain")
    };

    private Smartphone[] list_of_phones = new Smartphone[]{
            new Smartphone(1, "Galaxy 10", 25000, "Samsung"),
            new Smartphone(1, "Galaxy 8", 20000, "Samsung"),
            new Smartphone(1, "Galaxy 9", 21000, "Samsung"),
            new Smartphone(1, "iPhone 6", 25000, "iPhone"),
            new Smartphone(1, "iPhone 7", 25000, "iPhone"),
            new Smartphone(1, "12345", 15000, "Huawei"),
            new Smartphone(1, "123410", 13000, "Huawei"),

    };

    @BeforeEach
    public void addAllItemsToRepository() {

        // add all books to repository
        for (int i = 0; i < list_of_books.length; i++) {
            manager.add(list_of_books[i]);
        }
        // add all phones to repository
        for (int i = 0; i < list_of_phones.length; i++) {
            manager.add(list_of_phones[i]);
        }

    }

    @Test
    public void shouldSortProductsByClass() {

        Product[] actual = repository.findAll();
        Book[] actualBook = new Book[list_of_books.length];
        Smartphone[] actualPhone = new Smartphone[list_of_phones.length];
        int j = 0;
        int k = 0;

        // why do you need k ?
        for (int i = 0; i < actual.length; i++) {
            if (actual[i] instanceof Book) {
                actualBook[j] = (Book) actual[i];
                j++;
            } else if (actual[i] instanceof Smartphone) {
                actualPhone[k] = (Smartphone) actual[i];
                k++;
            }
        }
        assertArrayEquals(list_of_books, actualBook);

    }

    @Test
    public void shouldSearchByText() {

        Product[] expected = new Book[] {
            new Book(7, "The adventures of Tom Soyer", 1200, "Mark Twain"),
            new Book(10, "The adventures of Heckleberry Finn", 120, "Mark Twain"),
            new Book(11, "Life of the Mississippi", 350, "Mark Twain")
        };

        Product[] found_products =  manager.searchByText("Mark Twain");
        assertArrayEquals(expected, found_products);
    }

}