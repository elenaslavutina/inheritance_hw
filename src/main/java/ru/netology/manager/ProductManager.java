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

    public void removeById(int id) {
        productRepository.removeById(id);
    }

    public Product[] searchByText(String text) {

        int count_matches = 0;
        for (Product product : productRepository.findAll()) {
            if (product.matches(text)) {
                count_matches = count_matches + 1;
            }
        }
        Product[] result = new Product[count_matches];
        int idx = 0;
        for (Product product : productRepository.findAll()) {
            if (product.matches(text)) {
                result[idx] = product;
                idx = idx + 1;
            }
        }
        return result;
    }

}
