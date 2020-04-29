package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone phone = new Smartphone();

    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;

        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Smartphone();
        if (product instanceof Book) {
            Book book = (Book) product;
            book.setAuthor("Mark Twain");
        } else
           return;
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Smartphone();
        // Вопрос к аудитории: чей метод вызовется?
        product.toString();
    }
}
