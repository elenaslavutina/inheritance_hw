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
    private Book[] listOfBooks = new Book[]{
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

    private Smartphone[] listOfPhones = new Smartphone[]{
            new Smartphone(12, "Galaxy 10", 25000, "Samsung"),
            new Smartphone(13, "Galaxy 8", 20000, "Samsung"),
            new Smartphone(14, "Galaxy 9", 21000, "Samsung"),
            new Smartphone(15, "iPhone 6", 25000, "iPhone"),
            new Smartphone(16, "iPhone 7", 25000, "iPhone"),
            new Smartphone(17, "12345", 15000, "Huawei"),
            new Smartphone(18, "123410", 13000, "Huawei"),

    };

    @BeforeEach
    public void addAllItemsToRepository() {

        // add all books to repository
        for (int i = 0; i < listOfBooks.length; i++) {
            manager.add(listOfBooks[i]);
        }
        // add all phones to repository
        for (int i = 0; i < listOfPhones.length; i++) {
            manager.add(listOfPhones[i]);
        }

    }

    @Test
    public void shouldSortProductsByClass() {

        Product[] actual = repository.findAll();
        Book[] actualBook = new Book[listOfBooks.length];
        Smartphone[] actualPhone = new Smartphone[listOfPhones.length];
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
        assertArrayEquals(listOfBooks, actualBook);

    }

    @Test
    public void shouldSearchByText() {

        Product[] expected = new Book[] {
            new Book(7, "The adventures of Tom Soyer", 1200, "Mark Twain"),
            new Book(10, "The adventures of Heckleberry Finn", 120, "Mark Twain"),
            new Book(11, "Life of the Mississippi", 350, "Mark Twain")
        };

        Product[] foundProducts =  manager.searchByText("Mark Twain");
        assertArrayEquals(expected, foundProducts);
    }

}