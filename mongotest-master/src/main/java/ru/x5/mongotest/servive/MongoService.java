package ru.x5.mongotest.servive;

import ru.x5.mongotest.model.*;

import java.util.List;
import java.util.Optional;

public interface MongoService {
    void createProduct(Product product);
    List<GetProductsListResponse> getAllProduct();
//    Optional<CisBox> getCisByCisId(Long cisId);
    Optional<Product> findProductById(String productId);
//    void updateCis(CisBox cis);
    void updateProducerINNOfProduct(Product product);
    void updateStatusOfCis(CisBox cisBox);
    void createCisPallet(CisPallet cisPallet);
    void createCisBox(CisBox cisBox);
    void createCisPack(CisPack cisPack);
}
