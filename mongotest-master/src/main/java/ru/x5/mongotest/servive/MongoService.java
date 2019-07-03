package ru.x5.mongotest.servive;

import org.springframework.web.bind.annotation.RequestBody;
import ru.x5.mongotest.model.Cis;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.Product;

import java.util.List;
import java.util.Optional;

public interface MongoService {
    void createProduct(Product product);
    List<GetProductsListResponse> getAllProduct();
//    Optional<Cis> getCisByCisId(Long cisId);
    Optional<Product> findProductById(String productId);
//    void updateCis(Cis cis);
    void updateProducerINNOfProduct(Product product);
    void updateStatusOfCis(Cis cis);
    void createCis(Cis cis);
}
