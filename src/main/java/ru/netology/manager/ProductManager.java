package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository productRepository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
        this.productRepository = repository;
    }

    public void add(Product item) {
        productRepository.save(item);
    }

    public Product[] getAll() {
        Product[] items = productRepository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        productRepository.removeById(id);
    }

    public void removeAll() {
        productRepository.removeAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public Product[] searchByText(String text) {
        int count_matches = 0;
        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                count_matches = count_matches + 1;
            }
        }
        Product[] result = new Product[count_matches];
        int idx = 0;
        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                result[idx] = product;
                idx = idx + 1;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        if (product instanceof Book) {

            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        } else {

            Smartphone phone = (Smartphone) product;
            if (phone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (phone.getCompany().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
    }

}
