package ru.x5.mongotest.servive;

import ru.x5.mongotest.model.Cis;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.Product;

import java.util.List;
import java.util.Optional;

public interface MongoService {
    void createProduct(Product product);
    List<GetProductsListResponse> getAllProduct();
//    Optional<Cis> getCisByCisId(Long cisId);
    Optional<Product> findProductById(Long productId);
//    void updateCis(Cis cis);
//    void updateProduct(Product productDto);
}
