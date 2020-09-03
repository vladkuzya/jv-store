package mate.academy.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.model.Product;

public interface ProductDao {
    Product create(Product product);

    Optional<Product> getByID(Long productId);

    Product update(Product product);

    boolean deleteById(long productId);

    List<Product> getAllProducts();
}
