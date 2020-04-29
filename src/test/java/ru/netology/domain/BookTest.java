package ru.netology.domain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
//    book.
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
//      book.
        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Book();
        if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;
            phone.setCompany("Samsung");
        } else
            System.out.println("Sorry");
        System.out.println(product);



    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        // Вопрос к аудитории: чей метод вызовется?
        product.toString();
    }
}
