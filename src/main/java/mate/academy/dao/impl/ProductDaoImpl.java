package mate.academy.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.academy.dao.ProductDao;
import mate.academy.db.Storage;
import mate.academy.lib.Dao;
import mate.academy.model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> getByID(Long productId) {
        return Storage.products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    @Override
    public Product update(Product productUpdate) {
        IntStream.range(0, Storage.products.size())
                .filter(product -> Storage.products.get(product).getId().equals(productUpdate.getId()))
                .forEach(product -> Storage.products.set(product, productUpdate));
        return product;
    }

    @Override
    public boolean deleteById(long productId) {
        return Storage.products.remove(getByID(productId).get());
    }

    @Override
    public List<Product> getAllProducts() {
        return Storage.products;
    }
}
