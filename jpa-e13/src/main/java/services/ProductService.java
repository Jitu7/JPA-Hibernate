package services;

import entities.Product;
import repositories.ProductRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductService {

    private final EntityManagerFactory entityManagerFactory;

    public ProductService() {
        this.entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void addProduct(String name) {
        var entityManager = entityManagerFactory.createEntityManager();
        var productRepository = new ProductRepository(entityManager);

        Product product = new Product();
        product.setName(name);

        try {
            entityManager.getTransaction().begin();
            productRepository.addProduct(product);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }

    public List<Product> findAllProducts() {
        var entityManager = entityManagerFactory.createEntityManager();
        var productRepository = new ProductRepository(entityManager);

        return productRepository.findAllProducts();
    }
}
